package ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private String name;
    private Integer balance=10000;

    private ReentrantLock implicitLock=new ReentrantLock();

    public Account(){

    }

    public ReentrantLock getImplicitLock(){
        return implicitLock;
    }

    public String getName(){
        return name;
    }

    public Integer getBalance(){
        return balance;
    }

    public void setBalance(Integer balance){
        this.balance=balance;
    }
    public void setName(String name){
        this.name=name;
    }

    public boolean debit(Integer amount){
        if(amount>balance){
            System.out.println(Thread.currentThread().getName()+"::"+name+" says::"+amount+" greater than current balance");
            return false;
        }
        balance=balance-amount;
        System.out.println(Thread.currentThread().getName()+"::"+name+" says::"+amount+" Amount Debited Successfully");
        return true;
    }

    public void credit(Integer amount){
        balance=balance+amount;
        System.out.println(Thread.currentThread().getName()+"::"+name+" says::"+amount+" Amount Credited Successfully");
    }
}
