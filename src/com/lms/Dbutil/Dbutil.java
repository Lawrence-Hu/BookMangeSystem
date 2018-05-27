package com.lms.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Ims.db"; 
	String userName="sa"; 
	String userPwd="qwerty"; 
	
	public Connection getcon() throws Exception {
		Connection conn = DriverManager.getConnection(dbURL,userName,userPwd);
		return conn;
	}
	
	public void closecon(Connection conn) throws Exception {
		if(conn != null) {
			conn.close();
		}

	}
	public static void main(String[] args) {
		Dbutil dbutil = new Dbutil();
		try {
			dbutil.getcon();
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("链接数据库失败");
			e.printStackTrace();
		}
}
}