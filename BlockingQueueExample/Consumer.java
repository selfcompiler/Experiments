package BlockingQueueExample;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    protected BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    @Override
    public void run() {
        while (true){
        try{
            System.out.println("Blocking Queue Size = "+blockingQueue.size()+"::Consumed Element from Queue : "+blockingQueue.take());
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    }
}
