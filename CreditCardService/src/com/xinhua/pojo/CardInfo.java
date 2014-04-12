package com.xinhua.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CardInfo {
	
	private BigDecimal availableAmount;
	private BigDecimal currentAmount;
	private BigDecimal creditLimit;
	private String accountNumber;
	private String cardNumber;
	private String productType;
	private String cardLogo;
	private String cardIndicator;
	private String cardEmbossName;
	private Date cardExpireDate;
	private String cardBlockCode;
	private String cardActiveCode;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getCardLogo() {
		return cardLogo;
	}
	public void setCardLogo(String cardLogo) {
		this.cardLogo = cardLogo;
	}
	public String getCardIndicator() {
		return cardIndicator;
	}
	public void setCardIndicator(String cardIndicator) {
		this.cardIndicator = cardIndicator;
	}
	public String getCardEmbossName() {
		return cardEmbossName;
	}
	public void setCardEmbossName(String cardEmbossName) {
		this.cardEmbossName = cardEmbossName;
	}
	public Date getCardExpireDate() {
		return cardExpireDate;
	}
	public void setCardExpireDate(Date cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}
	public String getCardBlockCode() {
		return cardBlockCode;
	}
	public void setCardBlockCode(String cardBlockCode) {
		this.cardBlockCode = cardBlockCode;
	}
	public String getCardActiveCode() {
		return cardActiveCode;
	}
	public void setCardActiveCode(String cardActiveCode) {
		this.cardActiveCode = cardActiveCode;
	}
}
