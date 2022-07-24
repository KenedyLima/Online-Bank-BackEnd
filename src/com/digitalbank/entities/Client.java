package com.digitalbank.entities;

public class Client {

	private String name;
	private int phone;
	private Address address;
	private Account account;
	
	public Client(String name, int phone, Address address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		if(this.account != null) this.account = account; 
	}
	
	
	
}
