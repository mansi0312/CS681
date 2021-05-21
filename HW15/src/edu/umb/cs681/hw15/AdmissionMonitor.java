package edu.umb.cs681.hw15;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class AdmissionMonitor {
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientAdmissionCondition = lock.newCondition();
	private Condition minAdmissionCondition = lock.newCondition();
	private int visitors = 0;
	
	
	public void entrance() {
		lock.lock();
		try {
			
			System.out.println(Thread.currentThread().getName() + "Current visitor count:" + 
					visitors);

			while(visitors >= 7){
				System.out.println(Thread.currentThread().getName()
						+ " Max Admission limit reached.");
				sufficientAdmissionCondition.await();
			}
			visitors ++;
			System.out.println(Thread.currentThread().getName() + "Visitors count after admission: " + 
					visitors);
			minAdmissionCondition.signalAll();
			
			
		}catch(InterruptedException e) {
			System.out.println(e);
			
		}
		finally {
			lock.unlock();
			System.out.println("Entrance lock released");
		}
	}
	
	
	public void exit() {
		
		lock.lock();
		System.out.println("Exit lock obtained");
		try {
			
			System.out.println(Thread.currentThread().getName() + "Current visitor count:" + 
					visitors);
			while(visitors <= 0) {
				System.out.println(Thread.currentThread().getName()
						+ " Minimum admission limit reached");
				minAdmissionCondition.await();
			}
			
			if(!(visitors <= 0)) {
				visitors --;
			}
			System.out.println(Thread.currentThread().getId() + " VISITOR Exit: current Visitors count after exit = " + 
					visitors);
			sufficientAdmissionCondition.signalAll();
			
		}catch(InterruptedException e) {
			System.out.println(e);
			
		}finally {
			lock.unlock();
			System.out.println("Exit lock released");
		}
		
	}
	
	
	
	
	
	
	
	

}
