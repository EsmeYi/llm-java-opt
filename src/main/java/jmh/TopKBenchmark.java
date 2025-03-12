// package jmh;

// import main.TopK;

// import org.openjdk.jmh.annotations.*;
// import java.util.concurrent.TimeUnit;
// import java.util.*;


// public class TopKBenchmark {
//     @Benchmark
//     @BenchmarkMode(Mode.All)
//     @OutputTimeUnit(TimeUnit.MILLISECONDS)
//     public List<Long> benchmarkCalculateTopK() {
//         long[] A = generateArray(1000);
//         long[] B = generateArray(1000);
//         long[] C = generateArray(1000);
//         int k = 10;

//         return TopK.calculateTopK(k, A, B, C);
//     }

//     private long[] generateArray(int size) {
//         long[] array = new long[size];
//         Random random = new Random();
//         for (int i = 0; i < size; i++) {
//             array[i] = random.nextInt(1000);
//         }
//         return array;
//     }
// }
