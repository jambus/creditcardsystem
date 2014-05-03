package com.xinhua.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.CardInfoDao;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.util.ProfileUtil;

public class ActiveCardConfirmAction extends ActionSupport {

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
	
	public String getCardStatus(){
		 if(getCardDetails()!=null){
			 String status =  getCardDetails().getCardActiveCode();
			 if(Const.CARD_ACTIVE.equals(status)){
				 return "Active";
			 }else{
				 return "Not Active";
			 }
		 }
		 return "Unknown status";
	}
	
	private CardInfoDao cardInfoDao = new CardInfoDaoImpl();
		

	public String execute(){
		
		if(ProfileUtil.isCustomerLogin()){
			cardInfoDao.activeCard(getCardDetails());
			
			String accountNumber = ProfileUtil.getProfile().getAccountNumber();
			List<CardInfo> cardList = cardInfoDao.getCardListByAccountNumber(accountNumber);
			this.cardlist = cardList;
			ProfileUtil.getProfile().setCardList(cardList);
		}
		
		return SUCCESS;
	}
}
