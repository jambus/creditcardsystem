package com.xinhua.mybatis;

import com.xinhua.pojo.AccountInfo;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;

public interface UserMapper {
	public int addCardInfo(CardInfo cardInfo);
	public int activeCard(CardInfo cardInfo);
	public CardInfo getCardInfoByUserName(String userName);
	
	public int addUser(User user);
	
	public int generateAccountNumber(AccountInfo accountInfo);
	
	public int addUserInfo(UserInfo userInfo);
	public UserInfo getUserInfoById(String idNumber);
	
	public String getAccountNumberForUser(UserInfo userInfo);
}
