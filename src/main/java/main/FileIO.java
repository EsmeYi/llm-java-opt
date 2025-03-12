package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
    public static void processFile(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            int data;
            int lineNumber = 1;
            StringBuilder lineBuffer = new StringBuilder();

            while ((data = fis.read()) != -1) {
                lineBuffer.append((char) data);

                if (data == '\n') {
                    writeLineToFile(outputFile, lineBuffer.toString(), lineNumber++);
                    lineBuffer.setLength(0);
                }
            }

            if (lineBuffer.length() > 0) {
                writeLineToFile(outputFile, lineBuffer.toString(), lineNumber);
            }
        } catch (IOException e) {
            throw new RuntimeException("File processing failed", e);
        }
    }

    private static void writeLineToFile(String outputFile, String line, int lineNumber) {
        try (FileOutputStream fos = new FileOutputStream(outputFile, true)) {
            fos.write((line.trim() + " [" + lineNumber + "]\n").getBytes());
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + outputFile, e);
        }
    }
}
