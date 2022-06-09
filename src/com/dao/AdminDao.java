package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;



public class AdminDao {
	
	//注册 
	public static boolean regist(String account,String password) {  //传入账号和密码
		Connection conn = DBUtil.getConnectDb();   //通过实现数据库工具类DBUtil来连接数据库
		String sql = "insert into ausers (account,password) values(?,?)";
		int a=0;


		PreparedStatement stm=null;
		boolean sta=false;     //返回值
		try {
			stm= conn.prepareStatement(sql);  //预编译
			stm.setString(1, account);
			stm.setString(2, password);
			a = stm.executeUpdate();
			if(a==0) {
				sta=false;
			}else {
				sta=true;
			}
			
			return sta;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	//登录
		public static boolean login(String account,String password) {//传入账号和密码
			Connection conn = DBUtil.getConnectDb();
			String sql = "select * from ausers where account=? and password=?";
			ResultSet rs;

			PreparedStatement stm=null;
			boolean sta=false;
			try {
				stm= conn.prepareStatement(sql);
				stm.setString(1, account);
				stm.setString(2, password);
				rs = stm.executeQuery();
				if(rs.next()) {
					sta=true;
				}else {
					sta=false;
				}
				
				return sta;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
			
			
			
		}
	
	
	
	

}
