package com.digitalbank.entities;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Bank bank = new Bank();
		
		Client client = new Client("Kenedy", 0, null);
		Client client2 = new Client("Kenedy", 0, null);
		
		Account checkingAccount = new CheckingAccount(client);
		Account savingAccount = new SavingAccount(client2);
		Account savingAccount2 = new SavingAccount(client2);
		
		checkingAccount.deposit(new BigDecimal(100));
		checkingAccount.extract();
		savingAccount.extract();
		checkingAccount.transfer(new BigDecimal(45), savingAccount);
		checkingAccount.extract();
		savingAccount.extract();
		savingAccount.transfer(new BigDecimal(20), savingAccount2);;
		savingAccount.extract();
		savingAccount2.extract();
		
		System.out.println(savingAccount2.getOperations().toString());
	}

}
