package edu.umb.cs681.hw15;


import java.util.concurrent.locks.ReentrantLock;

public class EntranceHandler implements Runnable{
	
	
	private boolean done= false;
	private ReentrantLock lock = new ReentrantLock();
	private AdmissionMonitor monitor ;
	
	
	public EntranceHandler(AdmissionMonitor monitor) {
		this.monitor= monitor;
	}
	
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			try {
				if(done) {
					System.out.println("Entrance Handler setDone.");
					break;
				}
			}finally {
				lock.unlock();
				
			}
			monitor.entrance();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e);
				continue;
			}
		}
	}
	

}
