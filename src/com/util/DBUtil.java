package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * 连接mysql数据库的操作，用户名，密码，使用jdbc连接
	 */
	public static String username = "root";//账号
	public static String password = "123456";//密码
	private static String url1 = "jdbc:mysql://localhost:3306/fjy?serverTimezone=UTC";

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//获取数据库的连接
	public static Connection getConnectDb(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url1,username,password);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
}
