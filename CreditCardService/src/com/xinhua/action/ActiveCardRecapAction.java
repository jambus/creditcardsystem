package com.xinhua.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.util.PageComponentBuildUtil;
import com.xinhua.util.ProfileUtil;

public class ActiveCardRecapAction extends ActionSupport{

	private int cardIndex = 0;
	private List<CardInfo> cardlist = null;
	
	private String cardExpireDate;
	private String cardEmbossName;
	
	public Map<String,String> getCardNumberDropDownMap(){
		return PageComponentBuildUtil.buildCardSelectDropdown();
	}
	
	public String getCardExpireDate() {
		return cardExpireDate;
	}

	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}

	public String getCardEmbossName() {
		return cardEmbossName;
	}

	public void setCardEmbossName(String cardEmbossName) {
		this.cardEmbossName = cardEmbossName;
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
	
	@Override
	public void validate() {
		CardInfo card = getCardDetails();
		
		if(card == null){
			this.addFieldError("cardEmbossName", "Unknown Error!");
		}else{
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
			
			if("".equals(getCardEmbossName())){
				this.addFieldError("cardEmbossName", "卡片用户名不能为空！");
			}else if(!card.getCardEmbossName().equals(getCardEmbossName())){
				this.addFieldError("cardEmbossName", "卡片用户名验证失败！");
			}
			
			if("".equals(getCardExpireDate())){
				this.addFieldError("cardExpireDate", "卡号过期时间不能为空！");
			}else if(!(sdf.format(card.getCardExpireDate()).equals(getCardExpireDate()))){
				this.addFieldError("cardExpireDate", "卡片过期时间验证失败！");
			}
		}
	}
}
