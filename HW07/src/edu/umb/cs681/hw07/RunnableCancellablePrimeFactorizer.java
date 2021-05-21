package edu.umb.cs681.hw07;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {

    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        }finally {
            lock.unlock();
        }
    }


    public void generatePrimeFactors() {
        long divisor = 2;
        while( dividend != 1 && divisor <= to ){
            lock.lock();
            try {
                if(done) {
                    System.out.println("Stopped generating prime factors.");
                    break;
                }
                if(dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                }else {
                    if(divisor==2) {
                        divisor++;
                    }
                    else {
                        divisor += 2;
                    }

                }
            }finally {
                lock.unlock();
            }

        }
    }
    public void run() {
        generatePrimeFactors();
         }

    public static void main(String[] args) {
        RunnableCancellablePrimeFactorizer gen1 = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread1 = new Thread(gen1);
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Result: " + gen1.getPrimeFactors() + "\n");



        RunnableCancellablePrimeFactorizer gen2 = new RunnableCancellablePrimeFactorizer(2489, 2, (long)Math.sqrt(2489));
        Thread thread2 = new Thread(gen2);

        thread2.start();
        gen2.setDone();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Result: " + gen2.getPrimeFactors() + "\n");
    }
}