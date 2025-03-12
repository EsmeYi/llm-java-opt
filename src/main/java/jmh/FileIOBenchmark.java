// package jmh;

// import main.FileIO;
// import org.openjdk.jmh.annotations.*;

// import java.io.*;
// import java.nio.file.*;
// import java.util.concurrent.TimeUnit;

// @BenchmarkMode(Mode.AverageTime)
// @OutputTimeUnit(TimeUnit.MILLISECONDS)
// @State(Scope.Thread)
// public class FileIOBenchmark {
//     private static final String INPUT_FILE = "benchmark_input.txt";
//     private static final String OUTPUT_FILE = "benchmark_output.txt";

//     @Setup(Level.Iteration)
//     public void setUp() throws IOException {
//         Files.deleteIfExists(Paths.get(INPUT_FILE));
//         Files.deleteIfExists(Paths.get(OUTPUT_FILE));

//         try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(INPUT_FILE))) {
//             for (int i = 1; i <= 100000; i++) {
//                 writer.write("Hello World\n");
//             }
//         }
//     }

//     @Benchmark
//     public void testLowEfficiencyFileIO() {
//         FileIO.processFile(INPUT_FILE, OUTPUT_FILE);
//     }

//     @TearDown(Level.Iteration)
//     public void tearDown() throws IOException {
//         Files.deleteIfExists(Paths.get(INPUT_FILE));
//         Files.deleteIfExists(Paths.get(OUTPUT_FILE));
//     }
// }
