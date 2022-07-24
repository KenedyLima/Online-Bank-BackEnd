package com.digitalbank.entities;

public class SavingAccount extends Account {

	public SavingAccount(Client client) {
		super(client);
	}

	@Override
	public void extract() {
		StringBuilder builder = new StringBuilder();
		builder.append("============ SavingAccount Extract ============\n").append("Account: ").append(this.number).append("\n").append("Balance: ").append(this.balance).append("\n").append("============ CheckingAccount Extract ============");
		System.out.println(builder.toString());
	}
	
}
