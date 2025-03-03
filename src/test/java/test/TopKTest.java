package test;

import main.TopK;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TopKTest {

    @Test
    public void testCalculateTopK() {
        long[] A = {1, 2, 3};
        long[] B = {4, 5, 6};
        long[] C = {7, 8, 9};
        int k = 3;

        List<Long> result = TopK.calculateTopK(k, A, B, C);

        assertEquals(k, result.size(), "The result list should have k elements.");

        assertTrue(result.get(0) >= result.get(1), "The result should be sorted in descending order.");
        assertTrue(result.get(1) >= result.get(2), "The result should be sorted in descending order.");

        assertEquals(result.get(0), 18);
        assertEquals(result.get(1), 17);
        assertEquals(result.get(2), 17);
    }

    @Test
    public void testEmptyInput() {
        long[] A = {};
        long[] B = {};
        long[] C = {};
        int k = 3;

        List<Long> result = TopK.calculateTopK(k, A, B, C);

        assertTrue(result.isEmpty(), "The result list should be empty when inputs are empty.");
    }

    @Test
    public void testSingleElement() {
        long[] A = {1};
        long[] B = {2};
        long[] C = {3};
        int k = 1;

        List<Long> result = TopK.calculateTopK(k, A, B, C);

        assertEquals(1, result.size(), "The result list should have one element.");
        assertEquals(6, result.get(0), "The result should be 6.");
    }
}
