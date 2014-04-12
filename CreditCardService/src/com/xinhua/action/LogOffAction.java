package com.xinhua.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.util.ProfileValidateUtil;

public class LogOffAction extends ActionSupport {
	
	public String execute(){
		if(ProfileValidateUtil.isCustomerLogin()){
			ProfileValidateUtil.getProfile().setCustomerType(Const.CUSTOMERTYPE_VISIT);
		}
		
		return "logoff";
	}
}
