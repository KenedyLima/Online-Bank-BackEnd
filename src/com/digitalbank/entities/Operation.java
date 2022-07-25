package com.digitalbank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation {

	private OperationType operationType;
	private BigDecimal value;
	private LocalDateTime date;
	private IAccount sender = null;
	private IAccount receiver = null;
	
	
	private Operation(OperationType operationType, BigDecimal value) {
		date = LocalDateTime.now();	
		this.operationType = operationType;
		this.value = value;
	}
	
	private Operation(OperationType operationType, BigDecimal value, IAccount sender) {
		this(operationType, value);
		this.sender = sender;
	}
	
	private Operation(OperationType operationType, BigDecimal value, IAccount sender, IAccount receiver) {
		this(operationType, value, sender);
		this.receiver = receiver;
	}
	
	public OperationType getOperationType() {
		return operationType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public IAccount getSender() {
		return sender;
	}

	public IAccount getReceiver() {
		return receiver;
	}

	protected static Operation generate(OperationType operationType, BigDecimal value) {
		return new Operation(operationType, value);
	}
	
	protected static Operation generate(OperationType operationType, BigDecimal value, IAccount sender) {
		return new Operation(operationType, value, sender);
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
