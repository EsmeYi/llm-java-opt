package jmh;

import main.Water;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
public class WaterBenchmark {

    private Water water = new Water();

    // Benchmark the maxArea method for an array of size 1000
    @Benchmark
    public int benchmarkMaxArea() {
        int[] heights = new int[1000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = i % 50 + 1;  // Simulate some varied height values
        }
        return water.maxArea(heights);
    }
}
