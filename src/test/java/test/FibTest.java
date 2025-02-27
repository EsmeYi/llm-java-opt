package test;

import main.Fib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibTest {

    @Test
    public void testFibonacci() {
        assertEquals(0, Fib.fibonacci(0));
        assertEquals(1, Fib.fibonacci(1));
        assertEquals(1, Fib.fibonacci(2));
        assertEquals(2, Fib.fibonacci(3));
        assertEquals(3, Fib.fibonacci(4));
        assertEquals(5, Fib.fibonacci(5));
    }
}

