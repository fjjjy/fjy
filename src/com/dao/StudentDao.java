package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.StudnetBean;

import com.util.DBUtil;



public class StudentDao {
	
	
	//写入学生数据
	//添加
		public static boolean addStudent(String A,String B,String C,String D,String E) {
			Connection conn = DBUtil.getConnectDb();
			String sql = "insert into stumes (sid,sname,scls,sold,sroom) VALUES(?,?,?,?,?)";
			int  rs;
			PreparedStatement stm = null;
			try {
				stm = conn.prepareStatement(sql);
				stm.setString(1, A);
				stm.setString(2, B);
				stm.setString(3, C);
				stm.setString(4, D);
				stm.setString(5, E);

				rs = stm.executeUpdate();
				if(rs==1) {
					return true;
				}else {
					return false;
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				return false;
			}
			
			
		}
		//更改信息
		public static boolean changeStudent(String A,String B,String C,String D,String E) {
			Connection conn = DBUtil.getConnectDb();
			String sql = "UPDATE stumes set sname=?,scls=?,sold=?,sroom=? where sid=?";
			int  rs;
			PreparedStatement stm = null;
			try {
				stm = conn.prepareStatement(sql);
				
				stm.setString(1, B);
				stm.setString(2, C);
				stm.setString(3, D);
				stm.setString(4, E);
				stm.setString(5, A);
				boolean a=false;
				rs = stm.executeUpdate();
				if(rs==1) {
					return true;
				}else {
					return false;
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				return false;
			}
			
			
		}
		//删除
		//更改信息
		public static boolean delStudent(String A) {
			Connection conn = DBUtil.getConnectDb();
			String sql = "delete from stumes where sid=?";
			int  rs;
			PreparedStatement stm = null;
			try {
				stm = conn.prepareStatement(sql);
				
	
				stm.setString(1, A);
				boolean a=false;
				rs = stm.executeUpdate();
				if(rs==1) {
					return true;
				}else {
					return false;
				}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				return false;
			}
			
			
		}
		//查询所有的集合
		public static ArrayList getLikeList() {
			
			ArrayList  tag_Array = new ArrayList ();//建立一个数组集合
			Connection conn = DBUtil.getConnectDb();
			String sql = "select * from stumes";
			PreparedStatement stm = null;
			ResultSet rs = null;
			
			
			try {
				
				stm = conn.prepareStatement(sql);
				
				rs = stm.executeQuery();
				
				while(rs.next()) {
					StudnetBean tag = new StudnetBean();
					tag.setScls(rs.getString("scls"));
					tag.setSid(rs.getString("sid"));
					tag.setSname(rs.getString("sname"));
					tag.setSold(rs.getString("sold"));
					tag.setSroom(rs.getString("sroom"));
					tag_Array.add(tag);
					
			
					
				}
				rs.close();
				stm.close();
				
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
			return tag_Array;
		}
		
		
		//查询个体的集合
				public static ArrayList getLikeList(String id) {
					
					ArrayList  tag_Array = new ArrayList ();//建立一个数组集合
					Connection conn = DBUtil.getConnectDb();
					String sql = "select * from stumes where sid=?";
					PreparedStatement stm = null;
					ResultSet rs = null;
					
					
					try {
						
						stm = conn.prepareStatement(sql);
						stm.setString(1, id);
						rs = stm.executeQuery();
						
						while(rs.next()) {
							StudnetBean tag = new StudnetBean();
							tag.setScls(rs.getString("scls"));
							tag.setSid(rs.getString("sid"));
							tag.setSname(rs.getString("sname"));
							tag.setSold(rs.getString("sold"));
							tag.setSroom(rs.getString("sroom"));
							tag_Array.add(tag);
							
					
							
						}
						rs.close();
						stm.close();
						
					}catch(SQLException e) {
						
						e.printStackTrace();
					}
					return tag_Array;
				}
				


		}
		
		


