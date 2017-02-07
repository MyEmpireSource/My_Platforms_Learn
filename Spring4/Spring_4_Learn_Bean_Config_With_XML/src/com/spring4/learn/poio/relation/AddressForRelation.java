package com.spring4.learn.poio.relation;

public class AddressForRelation {
	

	private String city;
	private String street;
	
	public AddressForRelation() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "AddressForRelation [city=" + city + ", street=" + street + "]";
	}
	
	
}
