package com.xinhua.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xinhua.constant.Const;
import com.xinhua.util.ProfileUtil;

public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		if(ProfileUtil.isCustomerLogin()){
			return ai.invoke();
		}
		return Const.FORWARD_LOGIN;
	}

}
