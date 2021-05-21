package edu.umb.cs681.hw08;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable {
    private ConcurrentSingleton(){};
    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    public static ConcurrentSingleton getInstance(){
        lock.lock();
        try{
            if(instance == null){
                instance = new ConcurrentSingleton();
            }
        }finally {
            lock.unlock();
        }
        return instance;
    }

    public static void main(String args[]){

        ConcurrentSingleton concurrent1 = new ConcurrentSingleton();
        ConcurrentSingleton concurrent2 = new ConcurrentSingleton();
        ConcurrentSingleton concurrent3 = new ConcurrentSingleton();
        ConcurrentSingleton concurrent4 = new ConcurrentSingleton();
        Thread thread1 = new Thread(concurrent1);
        Thread thread2 = new Thread(concurrent2);
        Thread thread3 = new Thread(concurrent3);
        Thread thread4 = new Thread(concurrent4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        System.out.println(ConcurrentSingleton.getInstance());
    }
}