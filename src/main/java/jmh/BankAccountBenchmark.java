package jmh;

import main.BankAccount;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)
public class BankAccountBenchmark {

    private static final int ACCOUNT_COUNT = 10;
    private static final BankAccount.Account[] accounts = new BankAccount.Account[ACCOUNT_COUNT];
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    static {
        for (int i = 0; i < ACCOUNT_COUNT; i++) {
            accounts[i] = new BankAccount.Account(1000);
        }
    }

    @Benchmark
    @Threads(1)
    public void testSingleThreadTransfer() {
        executeRandomTransfer();
    }

    @Benchmark
    @Threads(4)
    public void testMultiThreadTransfer() {
        executeRandomTransfer();
    }

    @Benchmark
    @Threads(8)
    public void testHighConcurrencyTransfer() {
        executeRandomTransfer();
    }

    private void executeRandomTransfer() {
        int from = ThreadLocalRandom.current().nextInt(ACCOUNT_COUNT);
        int to = ThreadLocalRandom.current().nextInt(ACCOUNT_COUNT);
        int amount = ThreadLocalRandom.current().nextInt(100);

        if (from != to) {
            accounts[from].transfer(accounts[to], amount);
        }
    }
}
