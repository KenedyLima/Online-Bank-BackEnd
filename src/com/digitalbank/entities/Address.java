package com.digitalbank.entities;

public class Address {

	private String country;
	private String state;
	private String city;
	private String postalCode;
	
	public Address(String country, String state, String city, String postalCode) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
	
}
