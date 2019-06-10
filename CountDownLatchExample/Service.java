package CountDownLatchExample;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {


    private final String name;

    private final Integer timeToStart;

    private final CountDownLatch latch;


    public Service(String name,Integer timeToStart,CountDownLatch latch){
        this.name=name;
        this.timeToStart=timeToStart;
        this.latch=latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(timeToStart);
        }catch (InterruptedException ex){
            ex.printStackTrace();;
        }

        System.out.println(this.name+" System is UP");

        latch.countDown();
    }

}
