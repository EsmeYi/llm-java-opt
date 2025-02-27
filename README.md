# Java Code Optimization Pipeline

## Overview
This project automates the process of testing, benchmarking, and optimizing Java code using an LLM model (DeepSeek R1/V3 or Llama 3.1-8B).

## Features
- Runs unit tests and JMH benchmarks on Java files.
- Calls an LLM (DeepSeek R1/V3 or Llama 3.1-8B) to optimize Java code.
- Saves and compares results before and after improvement.
- Retains the original file and renames the improved version.

## Project Structure
```
project_root/
│── src/main/java/main/     # Java source files (innefficient codes)
│── src/main/java/jmh/      # Benchmarks
│── src/test/java/test      # Unit Tests
│── target/                 # Compiled files and JMH benchmarks
│── run.py                  # Main script to run the pipeline
│── test_result_before.txt  # Test results before optimization
│── test_result_after.txt   # Test results after optimization
│── benchmark_result_before.txt # Benchmark results before optimization
│── benchmark_result_after.txt  # Benchmark results after optimization
```

## Prerequisites
...

## Installation
...

## Usage
...

## Author
Lirong Yi
