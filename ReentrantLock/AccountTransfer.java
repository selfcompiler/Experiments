package ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTransfer {

    private ReentrantLock lock=new ReentrantLock();

    public void transfer(Account from,Account to,Integer amount){

        boolean transfer=false;

        try{
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+"::"+" says lock accquired");
                    boolean flag=from.debit(amount);
                    if(flag){
                        to.credit(amount);
                    }
                    System.out.println(Thread.currentThread().getName()+"::"+" "+from.getName()+" says::now balance is"+from.getBalance());
                    System.out.println(Thread.currentThread().getName()+"::"+" "+to.getName()+" says::now balance is"+from.getBalance());
                    transfer=true;
                }else{
                    System.out.println(Thread.currentThread().getName()+"::"+" says fail to accquire lock");
                    transfer(from,to,amount);
                }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        finally {
            if(transfer){
                lock.unlock();
            }
        }
    }
}
