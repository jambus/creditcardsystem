package com.xinhua.pojo;

import java.util.HashMap;
import java.util.Map;

import com.xinhua.constant.Const;

public class SysProfile {
	private String customerType = Const.CUSTOMERTYPE_VISIT;

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
