package com.xinhua.pojo;

import java.util.HashMap;
import java.util.Map;

import com.xinhua.constant.Const;

public class SysProfile {
	
	private String customerType = Const.CUSTOMERTYPE_VISIT;
	private String userName;
	private long customerNumber;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
}
