package edu.umb.cs681.hw12;

public final class Address {
	
	private final String street;
	private final String city;
	private final String state;
	private final int zipcode;
	
	public Address(String street, String city, String state, int zipcode) {
		this.street = street;
		this.state=state;
		this.city = city;
		this.zipcode = zipcode;
		
	}
	
	public final String getStreet() {
	    return street;
	}
	public final String getCity() {
	    return city;
	}
	public final String getState() {
	    return state;
	}
	
	public final int getZip() {
	    return zipcode;
	}
	
	
	public boolean equals(Address address) {
		if(address == this) {
			return true;
		}
		if(!(address instanceof Address)) {
			return false;
		}
		Address tmp = (Address) address;
		return this.city.equals(tmp.getCity()) 
				&& this.street.equals(tmp.getStreet()) 
				&& this.state.equals(tmp.getState()) 
				&& Integer.compare(this.zipcode, tmp.getZip()) == 0;
	}
	
	
	public String toString(){
		return street+"," +city+"," +state+","+ Integer.toString(zipcode);
	}
	
	public Address change(String street, String city,String state, int zipcode){
			return new Address(street, city, state, zipcode);  
		}

	

}
