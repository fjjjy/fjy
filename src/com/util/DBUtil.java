package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * ����mysql���ݿ�Ĳ������û��������룬ʹ��jdbc����
	 */
	public static String username = "root";//�˺�
	public static String password = "123456";//����
	private static String url1 = "jdbc:mysql://localhost:3306/fjy?serverTimezone=UTC";

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//��ȡ���ݿ������
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
