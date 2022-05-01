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

	private final ByteArrayOutputStream outputRedirected = new ByteArrayOutputStream();

	@Before
	public void redirectOutput() {
		System.setOut(new PrintStream(outputRedirected));
	}

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
			assert (aExp.getMessage().contains("The amount must be positive"));
		}
	}
	/*
	 * US 2: As a bank client I want to make a withdrawal from my account
	 * 
	 */

	@Test
	public void withdraw_PositiveValue_BalanceDecreased() {
		// the balance decreases by the value of amount
		BankAccount account = new BankAccount();
		BigDecimal deposit = new BigDecimal(250);
		account.deposit(deposit);
		BigDecimal withdrawal = new BigDecimal(100);
		account.withdraw(withdrawal);
		assertEquals(150, account.getBalance().longValue());
	}

	@Test
	public void withdraw_AmountGreaterThanBalance_MessageShown() {
		// Display error message in the output when balance not enough
		BankAccount account = new BankAccount();
		BigDecimal deposit = new BigDecimal(200);
		account.deposit(deposit);
		BigDecimal withdrawal = new BigDecimal(300);
		account.withdraw(withdrawal);
		assertEquals("You do not have balance for this withdrawal", outputRedirected.toString());
	}

	@Test
	public void withdraw_NegativeValue_ErrorThrown() {
		// throw an exception when a withdrawal has a negative value
		try {
			BankAccount account = new BankAccount();
			BigDecimal deposit = new BigDecimal(250);
			account.deposit(deposit);
			BigDecimal withdrawal = new BigDecimal(-85);
			account.withdraw(withdrawal);
			fail("Throw an exception when making a withdrawal of a negative number");
		} catch (IllegalArgumentException aExp) {
			assert (aExp.getMessage().contains("The amount must be positive"));
		}
	}

	/*
	 * US 3: As a bank client I want to see the history of my operations
	 *
	 */
	@Test
	public void displayHistory_MessageShown() {
		// create an account and perform some operations and check history
		BankAccount account = new BankAccount();
		account.setAccountNumber("001200651");
		account.setClientName("Sébastien Petit");
		BigDecimal firstdeposit = new BigDecimal(250);
		account.deposit(firstdeposit);
		BigDecimal firstWithdrawal = new BigDecimal(50);
		account.withdraw(firstWithdrawal);
		BigDecimal secondDeposit = new BigDecimal(500);
		account.deposit(secondDeposit);
		BigDecimal secondWithdrawal = new BigDecimal(240);
		account.withdraw(secondWithdrawal);
		StringBuilder out = new StringBuilder();
		out.append("History of operations for Account  " + account.getAccountNumber() + ":  \n");
		account.getOperations().forEach(op -> out.append(op.toString()));
		account.displayHistory();
		assertEquals(out.toString(), outputRedirected.toString());
	}

	@After
	public void restoreOutput() {
		System.setOut(System.out);
	}
}
