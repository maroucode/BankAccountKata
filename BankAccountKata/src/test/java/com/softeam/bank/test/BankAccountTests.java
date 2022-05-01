package com.softeam.bank.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.softeam.bank.BankAccount;

public class BankAccountTests {

	/*
	 * 
	 * US 1 : As a bank client, I want to make a deposit in my account
	 * 
	 */
	@Test
	public void deposit_PositiveValue_BalanceIncreased() {
		// the balance must increase by the amount
		BankAccount account = new BankAccount();
		BigDecimal depositAmount = new BigDecimal(1500);
		account.deposit(depositAmount);
		assertEquals(1500, account.getBalance().longValue());
	}

	@Test
	public void deposit_NegativeValue_ErrorThrown() {
		// An exception must be thrown when making a deposit with a negative value
		try {
			BankAccount account = new BankAccount();
			BigDecimal depositAmount = new BigDecimal(-250);
			account.deposit(depositAmount);
			fail("Exception should be thrown for a deposit of a negative number");
		} catch (IllegalArgumentException aExp) {
			assert (aExp.getMessage().contains("The amount of deposit must be positive"));
		}
	}

}
