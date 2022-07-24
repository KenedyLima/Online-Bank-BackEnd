package com.digitalbank.entities;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void testDepositOperationShouldDeposit100() throws Exception {
		Account account = new SavingAccount(new Client("", 0, null));
		account.deposit(new BigDecimal(100));
		assertEquals(new BigDecimal(100), account.getBalance());
	}

	@Test
	void testWithdrawlOperationShouldWithdrawl100() throws Exception {
		Account account = new SavingAccount(new Client("", 0, null));
		account.deposit(new BigDecimal(100));
		account.withdraw(new BigDecimal(100));
		assertEquals(new BigDecimal(0), account.getBalance());
	}
	
	@Test
	void testTransferOperationShouldTransfer100() throws Exception {
		Account account = new SavingAccount(new Client("", 0, null));
		Account account2 = new SavingAccount(new Client("", 0, null));
		
		account.deposit(new BigDecimal(100));
		account.transfer(new BigDecimal(100), account2);
		
		assertEquals(new BigDecimal(100), account2.getBalance());
	}
	


}
