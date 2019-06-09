package BlockingQueueExample;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while (true){

            try {
                Integer elem=new Integer((int)((Math.random())*1000+34));
                blockingQueue.put(elem);
                System.out.println("Queue Size= "+blockingQueue.size()+"::Inserted Element is "+elem);


            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
