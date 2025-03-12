// package jmh;

// import main.ChatServer;
// import org.openjdk.jmh.annotations.*;
// import org.openjdk.jmh.infra.Blackhole;

// import java.io.*;
// import java.net.Socket;
// import java.util.concurrent.*;

// @State(Scope.Benchmark)
// @BenchmarkMode(Mode.Throughput)
// @OutputTimeUnit(TimeUnit.SECONDS)
// @Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
// @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
// @Fork(1)
// @Threads(4)
// public class ChatServerBenchmark {

//     private static final int SERVER_PORT = 12345;
//     private static final String MESSAGE = "Hello from Client";
//     private static Thread serverThread;

//     @Setup(Level.Trial)
//     public void startServer() throws InterruptedException {
//         serverThread = new Thread(() -> ChatServer.main(new String[]{}));
//         serverThread.start();

//         boolean serverReady = false;
//         while (!serverReady) {
//             try (Socket socket = new Socket("localhost", SERVER_PORT)) {
//                 serverReady = true;
//             } catch (IOException e) {
//                 Thread.sleep(100);
//             }
//         }
//     }

//     @TearDown(Level.Trial)
//     public void stopServer() throws InterruptedException {
//         serverThread.interrupt();
//         serverThread.join(2000);
//     }

//     @Benchmark
//     public void testThroughput(Blackhole blackhole) throws IOException {
//         try (Socket client = new Socket("localhost", SERVER_PORT);
//              PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
//              BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

//             writer.println(MESSAGE);

//             String response = reader.readLine();
//             blackhole.consume(response);
//         }
//     }

//     public static void main(String[] args) throws Exception {
//         org.openjdk.jmh.Main.main(args);
//     }
// }
