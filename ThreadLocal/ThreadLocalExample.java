package ThreadLocalExample;

import java.util.Map;

public class ThreadLocalExample implements Runnable {

    private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();


    @Override
    public void run() {

        threadLocal.set((int) (Math.random()*100));

        try{
            Thread.sleep(2000);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Thread id="+Thread.currentThread().getName()+" Saved Value is "+threadLocal.get());
    }
}
