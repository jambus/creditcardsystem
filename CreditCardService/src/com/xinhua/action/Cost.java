package com.xinhua.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xinhua.pojo.Business;

public class Cost extends ActionSupport {

	private Business biz;
	
	public Business getBiz() {
		return biz;
	}
	public void setBiz(Business biz) {
		this.biz = biz;
	}

	public String execute(){
		
		return "";
	}
}
