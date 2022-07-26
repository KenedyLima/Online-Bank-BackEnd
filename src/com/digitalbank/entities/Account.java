package com.digitalbank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Account implements IAccount {

	protected static long accountsCounter = 1;
	protected final int agency = 0001; 
	protected long number;
	protected BigDecimal balance;
	protected HashMap<String, List<Operation>> operations = new HashMap<>();
	protected Client client = null;
	protected LocalDateTime timeCreated;	
	
	public Account(Client client) {
		timeCreated = LocalDateTime.now();
		balance = new BigDecimal(0);
		this.number = accountsCounter++;
		this.client = client;
		client.setAccount(this);
	}

	@Override
	public void deposit(BigDecimal amount){
		balance = balance.add(amount);
		Operation operation = Operation.generate(OperationType.DEPOSIT, amount);
		performOperationCheckingsAndInsertion(operation);
	}

	@Override
	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
		Operation operation = Operation.generate(OperationType.WITHDRAWAL, amount);
		performOperationCheckingsAndInsertion(operation);
	}
	
	
	@Override
	public void transfer(BigDecimal amount, IAccount account) throws Exception{
		if(this == account) throw new Exception("Can not transfer to the same account");
		balance = balance.subtract(amount);
		Operation operation = Operation.generate(OperationType.TRANSFERENCE, amount, this, account);
		((Account) account).depositFromTransference(amount, operation);

		performOperationCheckingsAndInsertion(operation);
	}
	
	public BigDecimal getBalance() {
		return balance;
	};
	
	public HashMap<String, List<Operation>> getOperations() {
		return operations;
	}
	
	public Client getClient() {
		return client;
	}
	
	private void depositFromTransference(BigDecimal amount, Operation operation) {
		balance = balance.add(amount);				
		performOperationCheckingsAndInsertion(operation);
	}

	private void performOperationCheckingsAndInsertion(Operation operation) {
		LocalDateTime date = operation.getDate();
		String key = OperationUtil.getYearMonthKey(date);
		List<Operation> operationsCollec = null;
		
		boolean isPresent = OperationUtil.isKeyYearMonthPresent(operations, date);
		
		if(isPresent) operationsCollec = operations.get(key);	
		else operationsCollec = new ArrayList<>();
		
		operationsCollec.add(operation);
		operations.put(key, operationsCollec);
	}

	
}
