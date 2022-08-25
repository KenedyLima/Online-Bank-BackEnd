package com.digitalbank.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Month;

import com.digitalbank.entities.Account;
import com.digitalbank.entities.Bank;
import com.digitalbank.entities.CheckingAccount;
import com.digitalbank.entities.Client;
import com.digitalbank.entities.SavingAccount;

public class Main {

	public static void main(String[] args) throws Exception {
		
		PrintService service = PrintService.getInstance();
		
	Bank bank = new Bank();
		
		Client client2 = new Client("Jhon", 0, null);
		
		Account savingAccount = new SavingAccount(client2);

		Client client = new Client("Kenedy", 0, null);
		Account checkingAccount = new CheckingAccount(client);
		checkingAccount.deposit(new BigDecimal(1000));
		checkingAccount.transfer(new BigDecimal(500), savingAccount);
		savingAccount.withdraw(new BigDecimal(500));
		savingAccount.deposit(new BigDecimal(100));
		System.out.println(savingAccount.getOperations().toString());
		service.print(savingAccount.getOperations(), Month.NOVEMBER);
	}
}
