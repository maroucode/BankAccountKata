package com.softeam.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
	private OperationType operationType;
	private LocalDateTime operationDate;
	private BigDecimal amount;
	private BigDecimal balance;

	public Operation() {
	}

	public Operation(OperationType type, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
		this.operationType = type;
		this.operationDate = date;
		this.amount = amount;
		this.balance = balance;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType type) {
		this.operationType = type;
	}

	public LocalDateTime getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(LocalDateTime date) {
		this.operationDate = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return " Type : " + getOperationType().toString() + " Date : " + getOperationDate().format(formatter)
				+ " Amount: " + getAmount() + ",  Balance : " + getBalance() + "\n";
	}
}
