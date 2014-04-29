package com.xinhua.pojo;

import java.util.List;

import com.xinhua.constant.Const;

public class SysProfile {
	
	private String customerType = Const.CUSTOMERTYPE_VISIT;
	private String userName;
	private long customerNumber;
	private String accountNumber;
	private List<CardInfo> cardList = null;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<CardInfo> getCardList() {
		return cardList;
	}

	public void setCardList(List<CardInfo> cardList) {
		this.cardList = cardList;
	}
}
