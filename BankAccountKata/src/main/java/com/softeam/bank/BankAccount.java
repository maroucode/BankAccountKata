package com.softeam.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	private String clientName;
	private String accountNumber;
	private BigDecimal balance;
	private List<Operation> operations;

	private static final String THE_AMOUNT_OF_DEPOSIT_MUST_BE_POSITIVE = "The amount of deposit must be positive";

	public BankAccount() {
		this.operations = new ArrayList<Operation>();
		this.balance = new BigDecimal(0);
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String name) {
		this.clientName = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNum) {
		this.accountNumber = accountNum;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void deposit(BigDecimal amount) {
		// if amount is positive we update the balance and add operation to history
		if (amount.compareTo(BigDecimal.ZERO) >= 0) {
			balance = balance.add(amount);
			this.operations.add(new Operation(OperationType.DEPOSIT, LocalDateTime.now(), amount, balance));
		} else {
			throw new IllegalArgumentException(THE_AMOUNT_OF_DEPOSIT_MUST_BE_POSITIVE);
		}
	}

}
