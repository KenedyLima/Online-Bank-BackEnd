package com.digitalbank.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {

	protected static long accountsCounter = 1;
	protected final int agency = 0001; 
	protected long number;
	protected BigDecimal balance;
	protected List<Operation> operations = new ArrayList<>();
	protected Client client = null;
		
	public Account(Client client) {
		balance = new BigDecimal(0);
		this.number = accountsCounter++;
		client.setAccount(this);
	}

	@Override
	public void deposit(BigDecimal value){
		balance = balance.add(value);
		Operation operation = Operation.generate(OperationType.DEPOSIT, value);
		operations.add(operation);
	}

	@Override
	public void withdraw(BigDecimal value) {
		balance = balance.subtract(value);
		Operation operation = Operation.generate(OperationType.WITHDRAWAL, value);
		operations.add(operation);
	}

	@Override
	public void transfer(BigDecimal value, IAccount account) throws Exception{
		if(this == account) throw new Exception("Invalid Operation");
		this.withdraw(value);
		account.deposit(value);
		Operation operation = Operation.generate(OperationType.TRANSFERENCE, value, this, account);
		this.operations.add(operation);
		account.getOperations().add(operation);
	}
	
	public BigDecimal getBalance() {
		return balance;
	};
	
	public List<Operation> getOperations() {
		return operations;
	}

	
}
