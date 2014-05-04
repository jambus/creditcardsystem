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
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.GetCardInfo;
import com.xinhua.util.ProfileUtil;

public class GetCardsSummaryAction extends ActionSupport{

	private static Log log = LogFactory.getLog(GetCardsSummaryAction.class);
	
	private CardInfoDao cardInfoDao = new CardInfoDaoImpl();
	private UserInfoDao userInfoDao = new UserInfoDaoImpl();
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public String getCardList(){
		
		try{
			dataMap.clear();
			List<CardInfo> cardList = null;
			if(ProfileUtil.isCustomerLogin()){
				
				long customerNumber = ProfileUtil.getProfile().getCustomerNumber();
				log.debug("CustomerNumber:"+ customerNumber);
				
				String accountNumber = ProfileUtil.getProfile().getAccountNumber();
				
				if(accountNumber ==null || "".equals(accountNumber)){
					accountNumber = cardInfoDao.getAccountNumberByCustomerID(customerNumber);
					ProfileUtil.getProfile().setAccountNumber(accountNumber);
				}
				
				cardList = ProfileUtil.getProfile().getCardList();
				if(cardList == null){
					cardList = cardInfoDao.getCardListByAccountNumber(String.valueOf(accountNumber));
					ProfileUtil.getProfile().setCardList(cardList);
				}
				cardList = GetCardInfo.getCreditCardAdditionalData(cardList);
				
				List<Map<String,String>> cardDetailsList = new ArrayList<Map<String,String>>();
				for(int index=0;index<cardList.size();index++){
					CardInfo card = cardList.get(index);
					Map<String,String> cardMap = new HashMap<String,String>();
					
					cardMap.put("cardName", card.getCardName());
					cardMap.put("cardNumber", card.getCardNumber());
					cardMap.put("currentAmount", card.getCurrentAmount().toPlainString());
					cardMap.put("cardIndex", ""+index);
					cardMap.put("cardActive", card.getCardActiveCode());
					cardMap.put("cardBlock", card.getCardBlockCode());
					
					cardDetailsList.add(cardMap);
				}
				dataMap.put("cardList", cardDetailsList);
				dataMap.put("status", "ok");
		    }
		}catch (Exception e){
			log.error("Error in getCardList "+ e.getMessage());
			dataMap.put("status", "error");
		}
		
		return SUCCESS;
	}
	
	@Override
	public void validate() {
	}
}
