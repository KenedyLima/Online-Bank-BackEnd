package com.digitalbank.entities;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Bank bank = new Bank();
		
		Client client = new Client("Kenedy", 0, null);
		Client client2 = new Client("Jhon", 0, null);
		
		Account checkingAccount = new CheckingAccount(client);
		Account savingAccount = new SavingAccount(client2);

		checkingAccount.deposit(new BigDecimal(1000));
		checkingAccount.transfer(new BigDecimal(500), savingAccount);
		savingAccount.withdraw(new BigDecimal(500));
		savingAccount.deposit(new BigDecimal(100));
		System.out.println(checkingAccount.getOperations().toString());		
		System.out.println(savingAccount.getOperations().toString());
		checkingAccount.extract();
		savingAccount.extract();
		
	}

}
