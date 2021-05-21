package edu.umb.cs681.hw14;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount {
	
	
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition(); 
	
	
	
	public ThreadSafeBankAccount() {}
	
	
	
	public void deposit(double amount) {
		lock.lock();
		try {
			
			while(balance>=300) {
				try {
					System.out.println(Thread.currentThread().getName()+":Upper Balance limit reached.");
					belowUpperLimitFundsCondition.await();
					
				}catch(InterruptedException ie) {
					System.out.println(ie);
				}
			}
			balance += amount;
			System.out.println(Thread.currentThread().getName() + ":Balance after deposit:" + balance);
			sufficientFundsCondition.signalAll();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			lock.unlock();
			System.out.println("Deposit lock unlocked.");
		}
		
	}
	
	public void withdraw(double amount) {
		lock.lock();
		try {
			
			while(balance<=0) {
				try {
					
					System.out.println(Thread.currentThread().getName()+":Lower Balance limit deposit.");
					sufficientFundsCondition.await();
					
				}catch(InterruptedException ie){
					System.out.println(ie);
					
				}
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + ":Balance after withdrawl : " + balance); 
			belowUpperLimitFundsCondition.signalAll();
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			lock.unlock();
			System.out.println("Withdraw lock unlocked.");
		}
		
		
	}
	

}
