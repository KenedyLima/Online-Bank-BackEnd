package com.digitalbank.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Operation {

	private OperationType operationType;
	private BigDecimal value;
	private Date date;
	private IAccount sender = null;
	private IAccount receiver = null;
	
	
	private Operation(OperationType operationType, BigDecimal value) {
		date = new Date();	
		this.operationType = operationType;
		this.value = value;
	}
	
	
	private Operation(OperationType operationType, BigDecimal value, IAccount sender, IAccount receiver) {
		this(operationType, value);
		this.sender = sender;
		this.receiver = receiver;
	}
	
	protected static Operation generate(OperationType operationType, BigDecimal value) {
		return new Operation(operationType, value);
	}
	
	protected static Operation generate(OperationType operationType, BigDecimal value, IAccount sender, IAccount receiver) {
		return new Operation(operationType, value, sender, receiver);
	}

	@Override
	public String toString() {
		return "Operation [operationType=" + operationType + ", value=" + value + ", date=" + date + ", sender="
				+ sender + ", receiver=" + receiver + "]";
	}
	
	
	 
}
