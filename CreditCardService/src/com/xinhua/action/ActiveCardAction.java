package com.xinhua.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.util.PageComponentBuildUtil;
import com.xinhua.util.ProfileUtil;

public class ActiveCardAction extends ActionSupport{

	private int cardIndex = 0;
	private List<CardInfo> cardlist = null;
	
	public Map<String,String> getCardNumberDropDownMap(){
		return PageComponentBuildUtil.buildCardSelectDropdown();
	}
	
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

	public String execute(){
		return SUCCESS;
	}
}
