package com.xinhua.action;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.CardInfoDao;
import com.xinhua.dao.UserDao;
import com.xinhua.dao.UserInfoDao;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.dao.impl.UserDaoImpl;
import com.xinhua.dao.impl.UserInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.GetCardInfo;
import com.xinhua.util.ProfileUtil;

public class CreditCardDetailsAction extends ActionSupport{

	private static Log log = LogFactory.getLog(CreditCardDetailsAction.class);
	
	private int cardIndex = 0;
	private List<CardInfo> cardlist = null;
	
	public int getCardIndex() {
		return cardIndex;
	}

	public void setCardIndex(int cardIndex) {
		this.cardIndex = cardIndex;
	}
	
	public CardInfo getCardDetails(){
		if(cardlist ==null){
			cardlist = ProfileUtil.getProfile().getCardList();
		}
		
		if(cardlist!=null && cardlist.size() > cardIndex){
			return cardlist.get(cardIndex);
		}
		return null;
	}
	
	public String getCardAmountOwe(){
		CardInfo card;
		if(getCardDetails()!=null){
			card = getCardDetails();
			return ""+card.getCreditLimit().subtract(card.getAvailableAmount()).doubleValue();
		}
		return "";
	}

	public String execute(){
		
		if(ProfileUtil.isCustomerLogin()){
			
		}
		
		
		return "success";
	}
}
