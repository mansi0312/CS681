package edu.umb.cs681.hw15;

public class AdmissionMonitorRunnable {
	
	
	public static void main(String[] args) {
		AdmissionMonitor m = new AdmissionMonitor();
		EntranceHandler entrance = new EntranceHandler(m);
		ExitHandler exit = new ExitHandler(m);
		
		Thread t1 = new Thread(entrance);
		Thread t2 = new Thread(exit);
		
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		entrance.setDone();
		exit.setDone();
		
		t1.interrupt();
		t2.interrupt();
		
		
		try {
			t1.join();
			t2.join();
			
		}catch(InterruptedException e) {
			
			System.out.println(e);
		}
		
	}

}
