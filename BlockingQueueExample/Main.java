import BlockingQueueExample.Consumer;
import BlockingQueueExample.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(10);

        Producer producer=new Producer(blockingQueue);
        Consumer consumer=new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
