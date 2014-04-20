package com.xinhua.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.xinhua.constant.Const;
import com.xinhua.dao.UserDao;
import com.xinhua.mybatis.MyBatisUtil;
import com.xinhua.mybatis.UserMapper;
import com.xinhua.pojo.User;
import com.xinhua.util.DBHelper;
import com.xinhua.util.EncryptUtil;

public class UserDaoImpl implements UserDao {

	private static Log log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public int addUser(User user) {
		
		int lines = 0;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	if(user !=null){
        		user.setPassword(EncryptUtil.getEncryptedBySha1(user.getPassword()));
        		user.setFailloginCount(0);
        		user.setStatus(Const.USERSTATUS_ACTIVE);
        	}
            userMapper.addUser(user);
            sqlSession.commit();
        } catch(Exception e){
        	log.error("addUser:"+e.getMessage());
        	lines = -1;
        	sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return lines;
	}


	@Override
	public int modifyUser(User user) {
		String sql = "update userpass set failloginCount='"+user.getFailloginCount()+"' , status='"+user.getStatus()+"' where userName='"+ user.getUserName()+"'";
		int lines = 0;
		Connection conn = null;
		Statement stmt = null;
		conn = DBHelper.getConnection();
		try {
			stmt = conn.createStatement();
			lines = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			log.error("Error during SQL:"+ e.getMessage());
		}
		DBHelper.free(conn, stmt);
		return lines;
	}


	@Override
	public User getUserByName(String userName) {

		User user = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getUserByName(userName);
            sqlSession.commit();
        } catch(Exception e){
        	log.error("getUserByName:"+e.getMessage());
        } finally {
            sqlSession.close();
        }
		return user;
	}

}
