package com.digitalbank.entities;

import java.math.BigDecimal;
import java.util.List;

public interface IAccount {

	void deposit(BigDecimal value);
	
	void withdraw(BigDecimal value);
	
	void transfer(BigDecimal value, IAccount account) throws Exception;
	
	void extract();
	
	List<Operation> getOperations();
	
	BigDecimal getBalance();
}
