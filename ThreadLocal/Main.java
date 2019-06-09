import ReentrantLockExample.Account;
import ReentrantLockExample.AccountTransfer;
import ThreadLocalExample.ThreadLocalExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
         ThreadLocalExample threadLocalExample=new ThreadLocalExample();

         Thread thread1=new Thread(threadLocalExample);
         Thread thread2=new Thread(threadLocalExample);
         thread1.start();
         thread2.start();
         thread1.join();
         thread2.join();
    }
}
