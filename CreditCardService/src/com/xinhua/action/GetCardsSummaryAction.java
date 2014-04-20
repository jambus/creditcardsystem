package com.xinhua.action;

import java.math.BigDecimal;
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
				
				//TODO getAccount number
				
				cardList = cardInfoDao.getCardListByAccountNumber(String.valueOf(customerNumber));
				
				for(CardInfo card : cardList){
					Map<String,String> cardMap = new HashMap<String,String>();
					int productType = Integer.valueOf(card.getProductType());
					String cardName = "Credit　Card";
					if(Const.IIN.MASTERCARD.getProductType() == productType){
						cardName = "Master Card";
					}else if(Const.IIN.VISA.getProductType() == productType){
						cardName = "Visa";
					}else if(Const.IIN.UNIONPAY.getProductType() == productType){
						cardName = "Union Pay";
					}
					
					String logo = card.getCardLogo();
					if(Const.CARDLOGO_NORMAL == logo){
						cardName += "";
					}else if(Const.CARDLOGO_SILVER == logo){
						cardName += "Silver";
					}else if(Const.CARDLOGO_GOLD == logo){
						cardName += "Gold";
					}
					
					cardMap.put("cardName", cardName);
					cardMap.put("cardNumber", card.getCardNumber());
					cardMap.put("currentAmount", card.getCurrentAmount().toPlainString());
					
					dataMap.put(card.getCardNumber(), cardMap);
					
				}
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
