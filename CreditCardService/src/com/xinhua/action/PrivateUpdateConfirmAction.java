package com.xinhua.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.CardInfoDao;
import com.xinhua.dao.UserInfoDao;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.dao.impl.UserInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.GetCardInfo;
import com.xinhua.util.ProfileUtil;

public class PrivateUpdateConfirmAction extends ActionSupport {

	UserInfoDao userInfoDao = new UserInfoDaoImpl();
	private UserInfo userinfo;

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public String execute(){
		
		if(ProfileUtil.isCustomerLogin()){
			long customerNumber = ProfileUtil.getProfile().getCustomerNumber();
			UserInfo userinfotemp = userInfoDao.getUserInfoByCustomerNumber(customerNumber);
			userinfotemp.setAddress(userinfo.getAddress());
			userinfotemp.setMail(userinfo.getMail());
			userinfotemp.setTel(userinfo.getTel());
			
			userInfoDao.modifyUserInfo(userinfotemp);
			
			userinfo = userInfoDao.getUserInfoByCustomerNumber(customerNumber);
		}
		return SUCCESS;
		
	}
	
	@Override
	public void validate() {
	}
}
