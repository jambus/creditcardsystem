package com.xinhua.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.xinhua.pojo.Transaction;
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.GetCardInfo;
import com.xinhua.util.ProfileUtil;

public class CreditCardDetailsAction extends ActionSupport{

	private static Log log = LogFactory.getLog(CreditCardDetailsAction.class);
	
	private int cardIndex = 0;
	private List<CardInfo> cardlist = null;
	private CardInfoDao cardInfoDao = new CardInfoDaoImpl();
	
	private List<Transaction> transactionList;
	private Map<String,String> cardNumberDropDownMap = new HashMap<String,String>();
	
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
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
	
	public Map<String,String> getCardNumberDropDownMap(){
		return cardNumberDropDownMap;
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
			CardInfo cardInfo = getCardDetails();
			if(cardInfo!=null){
				
				List<CardInfo> list = ProfileUtil.getProfile().getCardList();
				if(list !=null){
					cardNumberDropDownMap.clear();
					
					for(int i=0;i<list.size();i++){
						cardNumberDropDownMap.put(""+i, list.get(i).getCardName() + " "+ list.get(i).getCardNumber());
					}
				}
				
				transactionList = cardInfoDao.getTransactionsByCardNumber(cardInfo);
				
			}
		}
		
		return "success";
	}
}
