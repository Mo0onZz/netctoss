package com.tarena.netctoss.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	static{
		Properties props = new Properties();
		try {
			props.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("name");
			pwd = props.getProperty("pwd");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url,user,pwd);
		return conn;
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
