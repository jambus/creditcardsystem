package com.xinhua.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.dao.UserInfoDao;
import com.xinhua.dao.impl.CardInfoDaoImpl;
import com.xinhua.dao.impl.UserInfoDaoImpl;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.PageComponentBuildUtil;
import com.xinhua.util.ProfileUtil;

public class PrivateUpdateAction extends ActionSupport{
	
	UserInfoDao userInfoDao = new UserInfoDaoImpl();
	private UserInfo userinfo;

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public String execute(){
		
		long customerNumber = ProfileUtil.getProfile().getCustomerNumber();
		userinfo = userInfoDao.getUserInfoByCustomerNumber(customerNumber);
		
		return SUCCESS;
	}
}
