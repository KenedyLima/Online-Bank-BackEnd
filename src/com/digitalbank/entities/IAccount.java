package com.digitalbank.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IAccount {

	void deposit(BigDecimal amount);
	
	void withdraw(BigDecimal amount);
	
	void transfer(BigDecimal amount, IAccount account) throws Exception;
	
	void extract();
	
	HashMap<String, List<Operation>> getOperations();
	
	BigDecimal getBalance();
	
	Client getClient();
}
