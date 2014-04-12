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
import com.xinhua.util.FormatHelper;
import com.xinhua.util.GetCardInfo;

public class RegisterAction extends ActionSupport{

	private static Log log = LogFactory.getLog(RegisterAction.class);
	
	private User user;
	private UserInfo userInfo;
	
	UserDao userImpl = new UserDaoImpl();
	UserInfoDao userInfoImpl = new UserInfoDaoImpl();
	CardInfo cardInfo = new CardInfo();
	CardInfoDao cardInfoImpl = new CardInfoDaoImpl();
	private String accountNumber;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String execute(){
		log.info("userName:" + user.getUserName() + " ==> password:" + user.getPassword());
		
		UserInfo systemUserInfo = userInfoImpl.getUserInfoById(userInfo.getIdNumber());
		
		user.setCustomerNumber(systemUserInfo.getCustomerNumber());
		int lines = userImpl.addUser(user);
		if(lines<0){
			return "error";
		}
		
		return "regsuccess";
	}
	
	@Override
	public void validate() {
		if(userInfoImpl.getUserInfoById(userInfo.getIdNumber())==null){
			this.addFieldError("user.userName", "用户信息不存在！");
		}else{
			UserInfo systemUserInfo = userInfoImpl.getUserInfoById(userInfo.getIdNumber());
			
			if(!userInfo.getFirstName().equals(systemUserInfo.getFirstName())
					|| !userInfo.getLastName().equals(systemUserInfo.getLastName())
					|| !FormatHelper.getBirthday(userInfo.getBirthday()).equals(FormatHelper.getBirthday(systemUserInfo.getBirthday()))
					|| !userInfo.getIdNumber().equals(systemUserInfo.getIdNumber())
					|| !userInfo.getTel().equals(systemUserInfo.getTel())
					){
				this.addFieldError("user.userName", "用户信息有误，请核实信息！");
			}else{
				String systemAccountNumber = userInfoImpl.getAccountNumberForUser(systemUserInfo);
				if(!accountNumber.equals(systemAccountNumber)){
					this.addFieldError("user.userName", "用户信息有误，请核实信息！");
				}
			}
		}
	}
}
