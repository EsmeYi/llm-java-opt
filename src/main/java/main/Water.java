package main;

public class Water {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]); // Find the shorter line
                int width = j - i; // Distance between the lines
                int area = minHeight * width; // Calculate area
                maxArea = Math.max(maxArea, area); // Update max area if needed
            }
        }

        return maxArea;
    }
}