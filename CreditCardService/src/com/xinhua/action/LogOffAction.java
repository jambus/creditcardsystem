package com.xinhua.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.util.ProfileUtil;

public class LogOffAction extends ActionSupport {

	public String execute(){
		if(ProfileUtil.isCustomerLogin()){
			ProfileUtil.cleanProfile();
			ProfileUtil.getProfile().setCustomerType(Const.CUSTOMERTYPE_VISIT);
		}
		return "logoff";
	}
}
