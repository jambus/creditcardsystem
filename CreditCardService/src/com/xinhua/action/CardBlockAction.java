package com.xinhua.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.util.PageComponentBuildUtil;
import com.xinhua.util.ProfileUtil;

public class CardBlockAction extends ActionSupport{

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
		cardlist = ProfileUtil.getProfile().getCardList();
		
		if(cardlist!=null && cardlist.size() > cardIndex){
			return cardlist.get(cardIndex);
		}
		return null;
	}
	
	public String getCardBlockCode(){
		 if(getCardDetails()!=null){
			 String status =  getCardDetails().getCardBlockCode();
			 if(Const.CARDBLOCKCODE_LOST.equals(status)){
				 return "Lost/Block";
			 }else{
				 return "OK";
			 }
		 }
		 return "Unknown status";
	}

	public String execute(){
		return SUCCESS;
	}
}
