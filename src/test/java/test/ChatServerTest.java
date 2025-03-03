package test;

import main.ChatServer;
import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChatServerTest {
    private static Thread serverThread;

    @BeforeAll
    static void startServer() {
        serverThread = new Thread(() -> ChatServer.main(new String[]{}));
        serverThread.setDaemon(true);
        serverThread.start();

        boolean serverReady = false;
        while (!serverReady) {
            try (Socket socket = new Socket("localhost", 12345)) {
                serverReady = true;
            } catch (IOException e) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted while waiting for server to start", ex);
                }
            }
        }
    }

    @AfterAll
    static void stopServer() {
        serverThread.interrupt();
    }

    @Test
    @Order(1)
    void testServerStartup() {
        assertDoesNotThrow(() -> new Socket("localhost", 12345));
    }

    @Test
    @Order(2)
    void testClientCommunication() throws Exception {
        try (Socket client1 = new Socket("localhost", 12345);
             PrintWriter writer1 = new PrintWriter(client1.getOutputStream(), true);
             BufferedReader reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));

             Socket client2 = new Socket("localhost", 12345);
             PrintWriter writer2 = new PrintWriter(client2.getOutputStream(), true);
             BufferedReader reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()))) {

            writer1.println("Hello from Client1");

            String receivedMessage = reader2.readLine();
            assertEquals("Hello from Client1", receivedMessage);
        }
    }
}
