package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lms.model.Book;

public class BookManageDao {

	public ResultSet Search(Connection conn, Book book) throws SQLException {
		String sql = "select* from book where bno ="+book.getBno();
		PreparedStatement prmt = conn.prepareStatement(sql);	
		ResultSet rs = prmt.executeQuery();
		return rs;
	}
	public int Add(Connection conn, Book book)throws SQLException{
		
		String sql = "insert into book (bname,publish,author,price,ishere) values (?,?,?,?,?)";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setString(1, book.getBname());
		prmt.setString(2,book.getPublish());
		prmt.setString(3, book.getAuthor());
		prmt.setFloat(4, book.getPrice());
		prmt.setString(5, book.getYesorNot());
		return prmt.executeUpdate();
	}
	public int Delete(Connection conn, int bno)throws SQLException{
		String sql = "delete from book where bno = ?";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setInt(1, bno);
		return prmt.executeUpdate();
	}
	public int Update(Connection conn, Book book) throws SQLException {
		String sql = "update book set bname  = ?, publish = ?, author = ?, price = ?,ishere=? where bno = ?";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setString(1, book.getBname());
		prmt.setString(2,book.getPublish());
		prmt.setString(3, book.getAuthor());
		prmt.setFloat(4, book.getPrice());
		prmt.setString(5, book.getYesorNot());
		prmt.setInt(6, book.getBno());
		return prmt.executeUpdate();
	}
	
	public ResultSet SearchAll(Connection conn) throws SQLException {
		String sql = "select* from book";
		PreparedStatement prmt = conn.prepareStatement(sql);	
		ResultSet rs = prmt.executeQuery();
		return rs;	
	}
	public boolean isNotBack(Connection conn, int bno) throws SQLException {
		boolean result =false;
		String flag;
		String sql = "select*  from book where bno="+bno;
		PreparedStatement prmt = conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		while(rs.next()){
			flag = rs.getString("ishere");
			if(flag.equals("ÊÇ"))
			result=true;
		}
		return result;
	}
	public boolean islive(Connection conn, int bno) throws SQLException {
		boolean result =false;
		String flag;
		String sql = "select*  from book where bno="+bno;
		PreparedStatement prmt = conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		while(rs.next()){
			result=true;
		}
		return result;
	}
}
