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

	@Test
	public void deposit_PositiveValue_BalanceIncreased() {
		
		BankAccount account = new BankAccount();
		BigDecimal depositAmount = new BigDecimal(1500);
		account.deposit(depositAmount);
		assertEquals(1500, account.getBalance().longValue());
	}

}
