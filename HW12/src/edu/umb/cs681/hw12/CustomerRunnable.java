package edu.umb.cs681.hw12;

public class CustomerRunnable implements Runnable{
	
	Address addr1 = new Address("Landmore","Los Angeles","California",040404);
	Address addr2 = new Address("South Point","Boston","Massachusetts",12345);
	
	public void run() {
		Customer c = new Customer(addr1) ;
		System.out.println("Current address:"+c.getAddress());
		c.setAddress(addr2);
		System.out.println("Chnaged address:"+c.getAddress());
		c.setAddress(c.getAddress().change("25th Rushmore St","Dallas", "Texas", 67890));
		
	}
	
	public static void main(String args[]) {
		Thread t1 = new Thread(new CustomerRunnable());
		Thread t2 = new Thread(new CustomerRunnable());
		
		
		t1.start();
		t2.start();
		
		try {
			
			t1.join();
			t2.join();
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
	}
	 

}
