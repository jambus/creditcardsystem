package com.xinhua.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xinhua.constant.Const;
import com.xinhua.pojo.SysProfile;

public class ProfileUtil {
	private static SysProfile profile;
	
	static{
		ActionContext actionContext = ActionContext.getContext();   
	    Map session = actionContext.getSession();   
	    
	    if(session.get(Const.SYSPROFILE) ==null){
	    	 session.put(Const.SYSPROFILE, new SysProfile());   
	    }
	    profile = (SysProfile)session.get(Const.SYSPROFILE);
	}
	
	public static boolean isCustomerLogin(){
	    if(Const.CUSTOMERTYPE_CUSTOMER.equals(profile.getCustomerType())){
	    	return true;
	    }
	    return false;
	}
	
	public static SysProfile getProfile(){
		return profile;
	}
}
