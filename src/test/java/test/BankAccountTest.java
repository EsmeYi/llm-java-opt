package test;

import main.BankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testAccountTransfer() {
        BankAccount.Account account1 = new BankAccount.Account(1000);
        BankAccount.Account account2 = new BankAccount.Account(1000);

        account1.transfer(account2, 200);

        assertEquals(800, account1.getBalance());
        assertEquals(1200, account2.getBalance());
    }

    @Test
    public void testInsufficientBalance() {
        BankAccount.Account account1 = new BankAccount.Account(100);
        BankAccount.Account account2 = new BankAccount.Account(1000);

        account1.transfer(account2, 200);

        assertEquals(100, account1.getBalance());
        assertEquals(1000, account2.getBalance());
    }

    @Test
    public void testConcurrentTransfers() throws InterruptedException {
        int numAccounts = 5;
        BankAccount.Account[] accounts = new BankAccount.Account[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            accounts[i] = new BankAccount.Account(1000);
        }

        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new BankAccount.TransferTask(accounts), "Thread-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalBalance = 0;
        for (BankAccount.Account account : accounts) {
            totalBalance += account.getBalance();
        }
        assertEquals(1000 * numAccounts, totalBalance);
    }
}