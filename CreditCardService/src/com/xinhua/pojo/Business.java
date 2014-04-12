package com.xinhua.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Business {

	private BigDecimal earn;
	private BigDecimal pay;
	private String note;
	private CardInfo accountNumber;
	private Timestamp date;
	
	
	public CardInfo getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(CardInfo accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public BigDecimal getEarn() {
		return earn;
	}
	public void setEarn(BigDecimal earn) {
		this.earn = earn;
	}
	public BigDecimal getPay() {
		return pay;
	}
	public void setPay(BigDecimal pay) {
		this.pay = pay;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
