import BlockingQueueExample.Consumer;
import BlockingQueueExample.Producer;
import CountDownLatchExample.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

       final CountDownLatch latch=new CountDownLatch(3);

       Thread cache=new Thread(new Service("Cache",100,latch));

       Thread alert=new Thread(new Service("Alert",100,latch));

       Thread valid=new Thread(new Service("Valid",100,latch));

       cache.start();
       alert.start();
       valid.start();

       try{
           latch.await();
           System.out.println("All services are up Application Starting Now");
       }catch (InterruptedException ex){
           ex.printStackTrace();
       }

    }
}
