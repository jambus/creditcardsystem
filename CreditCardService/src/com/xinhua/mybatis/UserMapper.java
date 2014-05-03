package com.xinhua.mybatis;

import java.util.List;

import com.xinhua.pojo.AccountInfo;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.Transaction;
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;

public interface UserMapper {
	public int addCardInfo(CardInfo cardInfo);

	public CardInfo getCardInfoByUserName(String userName);
	
	public int addUser(User user);
	public User getUserByName(String userName);
	
	public int generateAccountNumber(AccountInfo accountInfo);
	
	public String getAccountNumberByCustomerID(long customerID);
	
	public int addUserInfo(UserInfo userInfo);
	public UserInfo getUserInfoById(String idNumber);
	
	public String getAccountNumberForUser(UserInfo userInfo);
	
	public List<CardInfo> getCardListByAccountNumber(String accountNumber);
	
	public List<Transaction> getTransactionsByCardNumber(String cardNumber);
	public int addTransaction(Transaction txn);
	
	public int activeCard(String cardNumber);
}
