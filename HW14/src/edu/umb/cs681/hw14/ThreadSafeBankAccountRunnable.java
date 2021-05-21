package edu.umb.cs681.hw14;

public class ThreadSafeBankAccountRunnable {

	public static void main(String[] args) {
		
		ThreadSafeBankAccount account = new ThreadSafeBankAccount();
		DepositRunnable deposit= new DepositRunnable(account);
		WithdrawRunnable withdraw = new WithdrawRunnable(account);
		
		//Threads for Deposit
		Thread d1  = new Thread(deposit);	
		Thread d2  = new Thread(deposit);	
		Thread d3  = new Thread(deposit);	
		Thread d4  = new Thread(deposit);	
		Thread d5  = new Thread(deposit);	
		Thread d6  = new Thread(deposit);	
		Thread d7  = new Thread(deposit);	
		Thread d8  = new Thread(deposit);	
		Thread d9  = new Thread(deposit);	
		Thread d10 = new Thread(deposit);			
		Thread d11 = new Thread(deposit);	
		Thread d12 = new Thread(deposit);	
		
		//Threads for withdrawl
		Thread w1  = new Thread(withdraw);
		Thread w2  = new Thread(withdraw);
		Thread w3  = new Thread(withdraw);
		Thread w4  = new Thread(withdraw);
		Thread w5  = new Thread(withdraw);
		Thread w6  = new Thread(withdraw);
		Thread w7  = new Thread(withdraw);
		Thread w8  = new Thread(withdraw);
		Thread w9  = new Thread(withdraw);
		Thread w10  = new Thread(withdraw);
		Thread w11 = new Thread(withdraw);
		Thread w12  = new Thread(withdraw);
		
		
		//---------------------------------------------
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		d6.start();
		d7.start();
		d8.start();
		d9.start();
		d10.start();
		d11.start();
		d12.start();
		
		//---------------------------------------------
		
		w1.start();
		w2.start();
		w3.start();
		w4.start();
		w5.start();
		w6.start();
		w7.start();
		w8.start();
		w9.start();
		w10.start();
		w11.start();
		w12.start();
		
		
		//---------------------------------------------
		
		deposit.setDone();
		withdraw.setDone();
		
		
		//---------------------------------------------
		
		d1.interrupt();
		d2.interrupt();
		d3.interrupt();
		d4.interrupt();
		d5.interrupt();
		d6.interrupt();
		d7.interrupt();
		d8.interrupt();
		d8.interrupt();
		d10.interrupt();
		d11.interrupt();
		d12.interrupt();
		
		//---------------------------------------------
		
		w1.interrupt();
		w2.interrupt();
		w3.interrupt();
		w4.interrupt();
		w5.interrupt();
		w6.interrupt();
		w7.interrupt();
		w8.interrupt();
		w9.interrupt();
		w10.interrupt();
		w11.interrupt();
		w12.interrupt();
		
		//---------------------------------------------
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			
			w1.join();
			w2.join();
			w3.join();
			w4.join();
			
		}catch(InterruptedException e) {
			System.out.println(e);
			
		}
		
		
		
		
		
		
		

	}

}
