import subprocess
import shutil
import torch
import os

from transformers import pipeline, AutoModelForCausalLM, AutoTokenizer
from openai import OpenAI

MVN_PATH="path/to/Maven/3.6.0/bin/mvn"
JAVA_PATH="path/to/Java/21.0.5/bin/java"

LLAMA_PATH = "path/to/models--meta-llama--Meta-Llama-3.1-8B-Instruct/snapshots/0e9e39f249a16976918f6564b8830bc894c89659"

project_dir = os.path.dirname(os.path.abspath(__file__))
src_dir = os.path.join(project_dir, 'src/main/java/main')

def run_command(command):
    result = subprocess.run(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    return result.stdout + '\n' + result.stderr

def compile_package():
    run_command([MVN_PATH, "clean", "package"])

def run_test():
    print("Running tests...")
    return run_command([MVN_PATH, "test"])

def run_benchmarks():
    print("Running benchmark...")
    return run_command([JAVA_PATH, "-jar", "target/benchmarks.jar"])

def run_test_benchmarks(flag):
    test_result = run_test()
    with open(f"test_result_{flag}.txt", "w") as test_file:
        test_file.write(test_result)

    benchmark_result = run_benchmarks()
    with open(f"benchmark_result_{flag}.txt", "w") as benchmark_file:
        benchmark_file.write(benchmark_result)


def extract_java_code(model_output: str) -> str:
    code_begin = model_output.find("package main;")
    if code_begin == -1:
        return "Java code extraction failed."
    
    code_end = model_output.find("package main;", code_begin + len("package main;"))
    if code_end == -1:
        code_end = len(model_output)

    # Extract the content between the first and second "package main;"
    extracted_code = model_output[code_begin:code_end].strip()

    return extracted_code


def improve_code_LLAMA(java_code: str) -> str:
    # Load the LLAMA model
    tokenizer = AutoTokenizer.from_pretrained(LLAMA_PATH, trust_remote_code=True)
    model_llama = AutoModelForCausalLM.from_pretrained(LLAMA_PATH, torch_dtype=torch.float16, device_map="auto")
    generator = pipeline("text-generation", model=model_llama, tokenizer=tokenizer, return_full_text=False)

    prompt = (
        "Optimize the performance of the given Java code. "
        "Keep the class name aligned with the input. "
        "Only return valid java code. No extra text at all!"
        f"{java_code}"
    )
    # Generate the improved code
    outputs = generator(prompt, max_length=500, truncation=True, num_return_sequences=1)
    improved_code = outputs[0]['generated_text']
    return extract_java_code(improved_code)


def imorove_code_deepseek(java_code: str) -> str:
    client = OpenAI(api_key="my_deepseek_key", base_url="https://api.deepseek.com")

    system_prompt = """
    The user will provide inefficient Java code.
    Please optimize the performance, 
    returning only valid Java code with the same structure and class name as the input, 
    without any extra text or formatting such as markdown.
    """
    response = client.chat.completions.create(
        # DeepSeek R1
        model="deepseek-reasoner",
        # DeepSeek V3: "deepseek-chat"
        messages=[
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": java_code},
        ],
        stream=False,
        temperature=0
    )
    return response.choices[0].message.content


def improve_code(file_path):
    print(f"Improving the code in {file_path}...")
    
    with open(file_path, 'r') as f:
        original_code = f.read()
    
    improved_code = imorove_code_deepseek(original_code)
    
    backup_file = file_path.replace(".java", ".backup")
    shutil.move(file_path, backup_file)
    
    with open(file_path, 'w') as f:
        f.write(improved_code)


def discover_files(suffix):
    java_files = []
    for root, dirs, files in os.walk(src_dir):
        for file in files:
            if file.endswith(suffix):
                java_files.append(os.path.join(root, file))
    return java_files


def recover_files():
    java_files = discover_files(".java")
    for file_path in java_files:
        improved_file = file_path.replace(".java", ".improved")
        shutil.move(file_path, improved_file)

    backup_files = discover_files(".backup")
    for file_path in backup_files:
        org_file = file_path.replace(".backup", ".java")
        shutil.move(file_path, org_file)
    

def run_pipeline():
    print(f"Running test and benchmark for original code...")
    run_test_benchmarks("before")
    
    print(f"Improving Java files...")
    java_files = discover_files(".java")
    for file_path in java_files:
        improve_code(file_path)
    
    print(f"Running test and benchmark for improved code...")
    run_test_benchmarks("after")

    recover_files()

if __name__ == '__main__':
    run_pipeline()
