package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;



public class AdminDao {
	
	//ע�� 
	public static boolean regist(String account,String password) {  //�����˺ź�����
		Connection conn = DBUtil.getConnectDb();   //ͨ��ʵ�����ݿ⹤����DBUtil���������ݿ�
		String sql = "insert into ausers (account,password) values(?,?)";
		int a=0;


		PreparedStatement stm=null;
		boolean sta=false;     //����ֵ
		try {
			stm= conn.prepareStatement(sql);  //Ԥ����
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
	
	
	//��¼
		public static boolean login(String account,String password) {//�����˺ź�����
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
