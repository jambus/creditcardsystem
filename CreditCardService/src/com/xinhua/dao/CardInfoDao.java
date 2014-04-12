package com.xinhua.dao;

import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.User;

public interface CardInfoDao {

	int addCardInfo(CardInfo cardInfo);
	int activeCard(CardInfo cardInfo);
	CardInfo getCardInfoByUserName(String userName);
}
