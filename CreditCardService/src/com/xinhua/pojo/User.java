package com.xinhua.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private String userName;
	private String password;
	private String status;
	private int failloginCount;
	private long customerNumber;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFailloginCount() {
		return failloginCount;
	}
	public void setFailloginCount(int failloginCount) {
		this.failloginCount = failloginCount;
	}
	public long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
}
