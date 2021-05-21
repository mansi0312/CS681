package edu.umb.cs681.hw17;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	private int id;
	
	public RequestHandler(int id) {
		this.id = id;
	}
	
	public void setDone()
	{
		lock.lock();
		try {
			done = true;
			
		} finally {
			lock.unlock();
		}
		
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		int randomHtml = random.nextInt(5);
		while(true) {
			lock.lock();
			try {
				if(done) {
					System.out.println(Thread.currentThread().getName() + " Done.");
					break;
				}
			} finally {
				lock.unlock();
			}
			java.nio.file.Path path = null;
			switch(randomHtml){
			case 0:
				path = java.nio.file.Paths.get("One.html");
				break;
			case 1:
				path = java.nio.file.Paths.get("Two.html");
				break;
			case 2:
				path = java.nio.file.Paths.get("three.html");
				break;
			case 3:
				path = java.nio.file.Paths.get("four.html");
				break;
			case 4:
				path = java.nio.file.Paths.get("five.html");
				break;
			default:
			}
			
			AccessCounter.getInstance().increment(path);
			AccessCounter.getInstance().getCount(path);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " " + e);
				continue;
			}
		}

	}
}
