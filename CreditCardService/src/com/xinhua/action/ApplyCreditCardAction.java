package com.xinhua.action;

import java.math.BigDecimal;

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

public class ApplyCreditCardAction extends ActionSupport{

	private static Log log = LogFactory.getLog(ApplyCreditCardAction.class);
	
	private UserInfo userInfo;
	private String customType;
	private String customerAccountNumber;
	
	UserDao userImpl = new UserDaoImpl();
	UserInfoDao userInfoImpl = new UserInfoDaoImpl();
	CardInfo cardInfo = new CardInfo();
	CardInfoDao cardInfoImpl = new CardInfoDaoImpl();

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}
	
	public String getCustomType() {
		return customType;
	}

	public void setCustomType(String customType) {
		this.customType = customType;
	}
	
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}

	public String execute(){
		
		if(Const.CUSTOMERTYPE_EXISTING.equals(getCustomType())){
			userInfo = userInfoImpl.getUserInfoById(userInfo.getIdNumber());
		}
		
		if(Const.CUSTOMERTYPE_NEW.equals(getCustomType())){
			int lines = userInfoImpl.addNewUserInfoWithAccountNumber(userInfo);
			if(lines<0){
				return "error";
			}
		}
		userInfo = userInfoImpl.getUserInfoById(userInfo.getIdNumber());
		setCustomerAccountNumber(userInfoImpl.getAccountNumberForUser(userInfo));
		
		return "applyDone";
	}
	
	@Override
	public void validate() {
		if(getCustomType() == null || "".equals(getCustomType().trim())){
			this.addFieldError("customType", "请选择用户类型！");
		}else if(Const.CUSTOMERTYPE_NEW.equals(getCustomType()) && userInfoImpl.getUserInfoById(userInfo.getIdNumber())!=null){
			this.addFieldError("customType", "请选择现有用户类型！");
		}else if(Const.CUSTOMERTYPE_EXISTING.equals(getCustomType()) && userInfoImpl.getUserInfoById(userInfo.getIdNumber())==null){
			this.addFieldError("customType", "请选择新用户类型！");
		}else if(!getCustomType().equals(Const.CUSTOMERTYPE_EXISTING) && !getCustomType().equals(Const.CUSTOMERTYPE_NEW)){
			this.addFieldError("customType", "未知用户类型！");
		}
	}
}
