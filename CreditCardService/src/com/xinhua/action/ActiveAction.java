package com.xinhua.action;

import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.pojo.CardInfo;

public class ActiveAction {

	private CardInfo cardInfo;
	
	CardInfoDaoImpl cardInfoImpl = new CardInfoDaoImpl();
		
	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String execute(){
		cardInfoImpl.activeCard(cardInfo);
		return "regsuccess";
	}
}
