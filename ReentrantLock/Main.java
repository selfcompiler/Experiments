import ReentrantLockExample.Account;
import ReentrantLockExample.AccountTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Account from=new Account();
        Account to=new Account();
        from.setBalance(2000);
        from.setName("Rahul");
        to.setBalance(1000);
        to.setName("Preeti");
        AccountTransfer accountTransfer=new AccountTransfer();
        Runnable a=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                accountTransfer.transfer(from,to,200);
                System.out.println(Thread.currentThread().getName()+":: says Transfer successfull");
            }
        };


        Runnable b=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                accountTransfer.transfer(from,to,100);
                System.out.println(Thread.currentThread().getName()+":: says Transfer successfull");
            }
        };

        for(int i=0;i<8;i++){
            executorService.submit(a);
            executorService.submit(b);
        }
    }
}
