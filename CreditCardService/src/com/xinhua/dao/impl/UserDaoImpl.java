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
		String sql = "select * from userpass where userName = '" + userName + "'";
		log.info("getUserByName"+sql);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DBHelper.getConnection();

		User user = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				user.setFailloginCount(rs.getInt("failloginCount"));
			}
		} catch (SQLException e) {
			log.error("Error during SQL:"+ e.getMessage());
		}
		DBHelper.free(conn, stmt);
		return user;
	}

}
