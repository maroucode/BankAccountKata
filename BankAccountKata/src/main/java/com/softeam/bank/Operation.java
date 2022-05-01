package com.softeam.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
	private OperationType operationType;
	private LocalDateTime operationDate;
	private BigDecimal amount;

	public Operation() {
	}

	public Operation(OperationType type, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
		this.operationType = type;
		this.operationDate = date;
		this.amount = amount;
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

}
