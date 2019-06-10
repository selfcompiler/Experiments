# Experiments

Date : 7/June/2019 Reentrant Lock Tested Source Link : 

https://dzone.com/articles/java-concurrency-reentrant-lock-1

References : http://tutorials.jenkov.com/java-concurrency/threadlocal.html


ThreadLocal

The ThreadLocal class in Java enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables.

Creating a ThreadLocal
Here is a code example that shows how to create a ThreadLocal variable:

private ThreadLocal myThreadLocal = new ThreadLocal();
As you can see, you instantiate a new ThreadLocal object. This only needs to be done once per thread. Even if different threads execute the same code which accesses a ThreadLococal, each thread will see only its own ThreadLocal instance. Even if two different threads set different values on the same ThreadLocal object, they cannot see each other's values.



Accessing a ThreadLocal
Once a ThreadLocal has been created you can set the value to be stored in it like this:

myThreadLocal.set("A thread local value");
You read the value stored in a ThreadLocal like this:

String threadLocalValue = (String) myThreadLocal.get();
The get() method returns an Object and the set() method takes an Object as parameter.


Generic ThreadLocal
You can create a generic ThreadLocal so that you do not have to typecast the value returned by get(). Here is a generic ThreadLocal example:

private ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();
Now you can only store strings in the ThreadLocal instance. Additionally, you do not need to typecast the value obtained from the ThreadLocal:

myThreadLocal.set("Hello ThreadLocal");

String threadLocalValue = myThreadLocal.get();
Initial ThreadLocal Value
Since values set on a ThreadLocal object only are visible to the thread who set the value, no thread can set an initial value on a ThreadLocal using set() which is visible to all threads.

Instead you can specify an initial value for a ThreadLocal object by subclassing ThreadLocal and overriding the initialValue() method. Here is how that looks:

private ThreadLocal myThreadLocal = new ThreadLocal<String>() {
    @Override protected String initialValue() {
        return "This is the initial value";
    }
};    
Now all threads will see the same initial value when calling get() before having called set() .

#COUNTDOWNLATCH 



What is CountDownLatch in Java ?\n
CountDownLatch in Java is a kind of synchronizer which allows one Thread  to wait for one or more Threads before starts processing. This is very crucial requirement and often needed in server side core Java application and having this functionality built-in as CountDownLatch greatly simplifies the development. CountDownLatch in Java is introduced on Java 5 along with other concurrent utilities like CyclicBarrier, Semaphore, ConcurrentHashMap and BlockingQueue in java.util.concurrent package. In this Java concurrency tutorial we will  what is CountDownLatch in Java, How CountDownLatch works in Java, an example of CountDownLatch in Java and finally some worth noting points about this concurrent utility. You can also implement same functionality using  wait and notify mechanism in Java but it requires lot of code and getting it write in first attempt is tricky,  With CountDownLatch it can  be done in just few lines. CountDownLatch also allows flexibility on number of thread for which main thread should wait, It can wait for one thread or n number of thread, there is not much change on code.  Key point is that you need to figure out where to use CountDownLatch in Java application which is not difficult if you understand What is CountDownLatch in Java, What does CountDownLatch do and How CountDownLatch works in Java. 


How CountDownLatch works in Java ?\n
CountDownLatch Example in Java 5 6 7Now we know What is CountDownLatch in Java, its time to find out How CountDownLatch works in Java. CountDownLatch works in latch principle,  main thread will wait until Gate is open. One thread waits for n number of threads specified while creating CountDownLatch in Java. Any thread, usually main thread of application,  which calls CountDownLatch.await() will wait until count reaches zero or its interrupted by another Thread. All other thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. as soon as count reaches zero, Thread awaiting starts running. One of the disadvantage of CountDownLatch is that its not reusable once count reaches to zero you can not use CountDownLatch any more, but don't worry Java concurrency API has another concurrent utility called CyclicBarrier for such requirements.




