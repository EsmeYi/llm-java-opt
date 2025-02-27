package jmh;

import main.Fib;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class FibBenchmark {
    @Benchmark
    public int testFib() {
        return Fib.fibonacci(10);
    }
}
