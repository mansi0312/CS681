package edu.umb.cs681.hw12;

import java.util.concurrent.atomic.AtomicReference;

public class Customer {
			private AtomicReference<Address> address;
			
			public Customer(Address add){ 
			address = new AtomicReference<>(add); 
		}
		
		public void setAddress(Address addr){
			address.set( addr);
		}	
		
		public Address getAddress(){ 
			return this.address.get();
		}
		

	
}
