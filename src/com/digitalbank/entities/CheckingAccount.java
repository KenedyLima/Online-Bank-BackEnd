package com.digitalbank.entities;

public class CheckingAccount extends Account {

	public CheckingAccount(Client client) {
		super(client);
	}

	@Override
	public void extract() {
		StringBuilder builder = new StringBuilder();
		builder.append("============ CheckingAccount Extract ============\n").append("Account: ").append(this.number).append("\n").append("Balance: ").append(this.balance).append("\n").append("============ CheckingAccount Extract ============");
		System.out.println(builder.toString());
	}

}
