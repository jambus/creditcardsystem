package com.xinhua.dao;

import java.util.List;

import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;

public interface UserInfoDao {

	int addNewUserInfoWithAccountNumber(UserInfo userInfo);
	UserInfo getUserInfoById(String idNumber);
	String getAccountNumberForUser(UserInfo userInfo);
	
	int modifyUserInfo(UserInfo userInfo);
	List<UserInfo> getAllUserInfo();
}
