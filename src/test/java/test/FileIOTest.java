package test;

import main.FileIO;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {
    private static final String INPUT_FILE = "test_input.txt";
    private static final String OUTPUT_FILE = "test_output.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(INPUT_FILE));
        Files.deleteIfExists(Paths.get(OUTPUT_FILE));

        Files.write(Paths.get(INPUT_FILE), "Hello\nWorld\nTest\n".getBytes());
    }

    @Test
    void testProcessFile() throws IOException {
        FileIO.processFile(INPUT_FILE, OUTPUT_FILE);

        assertTrue(Files.exists(Paths.get(OUTPUT_FILE)), "Output file should exist");

        String output = Files.readString(Paths.get(OUTPUT_FILE));
        String expected = "Hello [1]\nWorld [2]\nTest [3]\n";
        assertEquals(expected, output, "File content should match expected format");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(INPUT_FILE));
        Files.deleteIfExists(Paths.get(OUTPUT_FILE));
    }
}
