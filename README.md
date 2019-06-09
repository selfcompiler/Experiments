# Experiments

Date : 7/June/2019 Reentrant Lock Tested Source Link : 

https://dzone.com/articles/java-concurrency-reentrant-lock-1


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

