package com.xinhua.dao;

import com.xinhua.pojo.User;

public interface UserDao {

	int addUser(User user);
	int modifyUser(User user);
	User getUserByName(String userName);
}
