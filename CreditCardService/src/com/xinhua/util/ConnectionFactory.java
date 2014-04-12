package com.xinhua.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory factory = null;
	private ConnectionFactory(){}
	
	public static synchronized ConnectionFactory newInstance(){
		if(factory == null){
			factory = new ConnectionFactory();
		}
		return factory;
	}
	
	public Connection getConn(){
		Connection conn = null;
		
		String driver = null;
		String url = null;
		String user = null;
		String psd = null;
		
		Properties property = new Properties();
		//Class
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties");
		try {
			property.load(is);
			int sqltype = Integer.parseInt(property.getProperty("sqltype"));
			switch (sqltype) {
			case 1:
				driver = property.getProperty("sqlserver.driver");
				url = property.getProperty("sqlserver.url");
				user = property.getProperty("sqlserver.user");
				psd = property.getProperty("sqlserver.psd");
				break;
			case 2:
				driver = property.getProperty("oracle.driver");
				url = property.getProperty("oracle.url");
				user = property.getProperty("oracle.user");
				psd = property.getProperty("oracle.psd");
				break;
			case 3:
				driver = property.getProperty("mysql.driver");
				url = property.getProperty("mysql.url");
				user = property.getProperty("mysql.user");
				psd = property.getProperty("mysql.psd");
				break;

			default:
				break;
			}
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,psd);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
