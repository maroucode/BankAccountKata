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

	}

}
