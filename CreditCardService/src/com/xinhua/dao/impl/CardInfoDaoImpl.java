package com.xinhua.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xinhua.dao.CardInfoDao;
import com.xinhua.mybatis.MyBatisUtil;
import com.xinhua.pojo.CardInfo;
import com.xinhua.pojo.Transaction;
import com.xinhua.pojo.User;
import com.xinhua.util.DBHelper;
import com.xinhua.util.GetCardInfo;
import com.xinhua.mybatis.UserMapper;

public class CardInfoDaoImpl implements CardInfoDao {
	private static Log log = LogFactory.getLog(CardInfoDaoImpl.class);
	
	@Override
	public int addCardInfo(CardInfo cardInfo) {
		int lines = 0;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addCardInfo(cardInfo);
            sqlSession.commit();
        } catch(Exception e){
        	log.error("addCardInfo:"+e.getMessage());
        	sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
        return lines;
	}

	@Override
	public int activeCard(CardInfo cardInfo) {
		String sql = "update cardinfo set status = 'ACTIVE' where accountNumber = '"+cardInfo.getAccountNumber()+"'";
		System.out.println(sql);
		int lines = 0;
		Connection conn = null;
		Statement stmt = null;
		conn = DBHelper.getConnection();
		try {
			stmt = conn.createStatement();
			lines = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.free(conn, stmt);
		return lines;
	}

	@Override
	public CardInfo getCardInfoByUserName(String userName) {

		CardInfo cardInfo = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	cardInfo = userMapper.getCardInfoByUserName(userName);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
		
		return cardInfo;
	}

	@Override
	public List<CardInfo> getCardListByAccountNumber(String accountNumber) {


		List<CardInfo> cardList = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	cardList =  userMapper.getCardListByAccountNumber(accountNumber);
            sqlSession.commit();
        } 
        finally {
            sqlSession.close();
        }
		return cardList;
	}

	@Override
	public String getAccountNumberByCustomerID(long customerID) {
		String accountNumber = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	accountNumber =  userMapper.getAccountNumberByCustomerID(customerID);
            sqlSession.commit();
        } 
        finally {
            sqlSession.close();
        }
		return accountNumber;
	}

	@Override
	public List<Transaction> getTransactionsByCardNumber(String cardNumber) {
		
		List<Transaction> txnList = null;
		SqlSession sqlSession =  MyBatisUtil.getSqlSessionFactory().openSession();
        try {
        	UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        	txnList =  userMapper.getTransactionsByCardNumber(cardNumber);
        	if(txnList == null || txnList.size()==0){
        		List<Transaction> tmpTxnList = GetCardInfo.generationTransactions(cardNumber);
        		for(Transaction txn:tmpTxnList){
        			userMapper.addTransaction(txn);
        		}
        		txnList =  userMapper.getTransactionsByCardNumber(cardNumber);
        	}
            sqlSession.commit();
        }catch(Exception e){
        	log.error("getTransactionsByCardNumber:"+e.getMessage());
        	sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }

		return txnList;
	}

}
