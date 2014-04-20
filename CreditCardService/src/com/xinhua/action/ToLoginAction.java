package com.xinhua.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.constant.Const;
import com.xinhua.pojo.SysProfile;
import com.xinhua.util.ProfileUtil;

public class ToLoginAction extends ActionSupport {

	public String execute(){
		if(ProfileUtil.isCustomerLogin()){
			return "home";
		}
		return "login";
	}
}
