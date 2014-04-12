package com.xinhua.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.xinhua.action.ApplyCreditCardAction;
import com.xinhua.constant.Const;
import com.xinhua.dao.UserInfoDao;
import com.xinhua.mybatis.MyBatisUtil;
import com.xinhua.mybatis.UserMapper;
import com.xinhua.pojo.AccountInfo;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.User;
import com.xinhua.pojo.UserInfo;
import com.xinhua.util.DBHelper;
import com.xinhua.util.EncryptUtil;
import com.xinhua.util.GetCardInfo;

public class UserInfoDaoImpl implements UserInfoDao {
	private static Log log = LogFactory.getLog(UserInfoDaoImpl.class);

	@Override
	public int addNewUserInfoWithAccountNumber(UserInfo userInfo) {
		
		int lines = 0;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addUserInfo(userInfo);
            
            UserInfo newuserInfo = userMapper.getUserInfoById(userInfo.getIdNumber());
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountNumber(GetCardInfo.getAccountNumber());
            accountInfo.setCustomerNumber(newuserInfo.getCustomerNumber());
            userMapper.generateAccountNumber(accountInfo);
            sqlSession.commit();
        } catch(Exception e){
        	log.error("addNewUserInfoWithAccountNumber:"+e.getMessage());
        	lines = -1;
        	sqlSession.rollback();
        } 
        finally {
            sqlSession.close();
        }
        return lines;
	}
	
	@Override
	public String getAccountNumberForUser(UserInfo userInfo){
		String accountNumber = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	
        	accountNumber= userMapper.getAccountNumberForUser(userInfo);
            sqlSession.commit();
        }catch(Exception e){
        	log.error("getAccountNumberForUser:"+e.getMessage());
        } 
        finally {
            sqlSession.close();
        }
        return accountNumber;
	}
	

	@Override
	public List<UserInfo> getAllUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserInfoById(String idNumber) {

		UserInfo userInfo = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	userInfo = userMapper.getUserInfoById(idNumber);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
		
		return userInfo;
	}

	@Override
	public int modifyUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
