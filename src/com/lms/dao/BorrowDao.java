package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import com.lms.model.Book;

public class BorrowDao {

public int Borrow(Connection conn, int bno,int id, String bdate)throws SQLException{
		
		String sql = "insert into Br (bno,id,bdate) values (?,?,?)";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setInt(1, bno);
		prmt.setInt(2,id);
		prmt.setString(3,bdate);
		return prmt.executeUpdate();
	}
public boolean isExisUser(Connection conn, int id) throws SQLException {
	boolean flag =false;
	String sql = "select* from i_user where id=?";
	PreparedStatement prmt = conn.prepareStatement(sql);
	prmt.setInt(1, id);
	ResultSet rs = prmt.executeQuery();
	if(rs.next()) {
		flag = true;
	}
	return flag;
	}
public boolean isOut(Connection conn, int bno) throws SQLException {
	boolean flag =false;
	String sql = "select* from book where bno=?";
	PreparedStatement prmt = conn.prepareStatement(sql);
	prmt.setInt(1, bno);
	ResultSet rs = prmt.executeQuery();
	if(rs.next()) {
		if(rs.getString("ishere").equals("ÊÇ"))
		flag = true;
	}
	return flag;
	}
public int Update(Connection conn, int bno)throws SQLException{
	
	String sql = "update book set ishere = ?";
	PreparedStatement prmt = conn.prepareStatement(sql);
	prmt.setString(1, "ÊÇ");
	return prmt.executeUpdate();
}
public boolean OverLimit(Connection conn, int id) throws SQLException {
	boolean flag = false;
	String sql = "select count(id)'number' from br  where id =?";
	PreparedStatement prmt = conn.prepareStatement(sql);
	prmt.setInt(1, id);
	ResultSet rs = prmt.executeQuery();
	while (rs.next()) {
		if(rs.getInt("number")>5) {
			flag = true;
		}	
	}
	return flag;
}
}
