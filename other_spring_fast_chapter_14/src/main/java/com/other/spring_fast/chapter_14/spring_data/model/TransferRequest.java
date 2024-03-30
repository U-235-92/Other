package com.other.spring_fast.chapter_14.spring_data.model;

import java.math.BigDecimal;

public class TransferRequest {

	private long senderAccountId;
	private long receiverAccountId;
	private BigDecimal amount;

	public long getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public long getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(long receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
