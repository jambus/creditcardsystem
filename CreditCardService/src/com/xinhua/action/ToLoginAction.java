package com.xinhua.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.pojo.SysProfile;
import com.xinhua.util.ProfileValidateUtil;

public class ToLoginAction extends ActionSupport {

	public String execute(){
		if(ProfileValidateUtil.isCustomerLogin()){
			return "home";
		}
		return "login";
	}
}
