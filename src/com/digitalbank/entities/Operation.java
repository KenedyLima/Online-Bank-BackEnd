package com.digitalbank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Operation {

	private OperationType operationType;
	private BigDecimal amount;
	private LocalDateTime date;
	private IAccount sender = null;
	private IAccount receiver = null;
	
	
	private Operation(OperationType operationType, BigDecimal amount) {
		date = LocalDateTime.now();	
		this.operationType = operationType;
		this.amount = amount;
	}
	
	private Operation(OperationType operationType, BigDecimal amount, IAccount sender) {
		this(operationType, amount);
		this.sender = sender;
	}
	
	private Operation(OperationType operationType, BigDecimal amount, IAccount sender, IAccount receiver) {
		this(operationType, amount, sender);
		this.receiver = receiver;
	}
	
	public OperationType getOperationType() {
		return operationType;
	}

	public BigDecimal getamount() {
		return amount;
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

	protected static Operation generate(OperationType operationType, BigDecimal amount) {
		return new Operation(operationType, amount);
	}
	
	protected static Operation generate(OperationType operationType, BigDecimal amount, IAccount sender) {
		return new Operation(operationType, amount, sender);
	}
	
	protected static Operation generate(OperationType operationType, BigDecimal amount, IAccount sender, IAccount receiver) {
		return new Operation(operationType, amount, sender, receiver);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))).append("\n").append(operationType).append("\tamount: ").append(amount);;
		if(operationType == OperationType.TRANSFERENCE) {
			builder.append("\nFrom: ").append(sender.getClient().getName());
			builder.append("\nTo: ").append(receiver.getClient().getName());
		}
		return builder.toString();	
		}
	
	 
}
