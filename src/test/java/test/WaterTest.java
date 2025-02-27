package test;

import main.Water;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTest {

    @Test
    public void testMaxArea() {
        Water water = new Water();

        // Test case 1: Normal case with an array of heights
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1 = water.maxArea(heights1);
        assertEquals(49, result1);

        // Test case 2: Edge case with only one line (should return 0)
        int[] heights2 = {1};
        int result2 = water.maxArea(heights2);
        assertEquals(0, result2);

        // Test case 3: Edge case with two lines
        int[] heights3 = {1, 2};
        int result3 = water.maxArea(heights3);
        assertEquals(1, result3);

        // Test case 4: All elements are the same height
        int[] heights4 = {5, 5, 5, 5, 5};
        int result4 = water.maxArea(heights4);
        assertEquals(20, result4);

        // Test case 5: Decreasing heights
        int[] heights5 = {8, 7, 6, 5, 4};
        int result5 = water.maxArea(heights5);
        assertEquals(16, result5);

        // Test case 6: Increasing heights
        int[] heights6 = {1, 2, 3, 4, 5};
        int result6 = water.maxArea(heights6);
        assertEquals(6, result6);
    }
}
