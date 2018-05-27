package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=bookManager"; 
	String userName="sa"; 
	String userPwd="qwerty"; 
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	
	public Connection getCon() throws Exception {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(dbURL,userName,userPwd);
		return conn;		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if ( con!=null) {
			con.close();
		}
	}
	
	/**
	 * �������ݿ�����
	 */
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
