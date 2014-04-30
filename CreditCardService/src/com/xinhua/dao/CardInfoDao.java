package com.xinhua.dao;

import java.util.List;

import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.Transaction;

public interface CardInfoDao {

	int addCardInfo(CardInfo cardInfo);
	List<CardInfo> getCardListByAccountNumber(String accountNumber);
	String getAccountNumberByCustomerID(long customerID);
	
	int activeCard(CardInfo cardInfo);
	CardInfo getCardInfoByUserName(String userName);
	
	List<Transaction> getTransactionsByCardNumber(CardInfo card);
}
