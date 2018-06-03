package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.model.Book;
import com.lms.model.User;
import com.lms.util.StringUtil;

public class InquriyDao {
	public ResultSet InquityA(Connection conn, String rdate) throws SQLException {
		String sql = "select book.bno, book.bname, book.publish,book.author,book.price,datediff(day,br.bdate,?)'day' from br,book where book.bno = br.bno and datediff(day,br.bdate,?) > 30";
		PreparedStatement prmt = conn.prepareStatement(sql);	
		prmt.setString(1, rdate);
		prmt.setString(2, rdate);
		ResultSet rs = prmt.executeQuery();
		return rs;
	}
	public ResultSet InquityB(Connection conn) throws SQLException {
		String sql = "select book.bno, book.bname, book.publish,book.author,book.price ,book.ishere from br,book where book.bno = br.bno";
		PreparedStatement prmt = conn.prepareStatement(sql);	
		ResultSet rs = prmt.executeQuery();
		return rs;
	}
	public ResultSet InquityC(Connection conn,Book book) throws SQLException {
		StringBuffer sb = new StringBuffer("select bno, bname, publish,author,price from book");
		if(StringUtil.isNotEmpty(book.getPublish())){
			sb.append(" where publish  like '%"+book.getPublish()+"%'");
		}
		PreparedStatement prmt = conn.prepareStatement(sb.toString());	
		ResultSet rs = prmt.executeQuery();
		return rs;
	}
	
	public ResultSet InquityD(Connection conn,User user) throws SQLException {
		String sql = "select book.bno, book.bname, book.publish,book.author,book.price from br,book,i_user where br.bno = book.bno and i_user.id = br.id and i_user.name =?";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setString(1, user.getName());
		ResultSet rs = prmt.executeQuery();
		return rs;
	}
	public boolean isExisUser(Connection conn, User user) throws SQLException {
		boolean flag =false;
		String sql = "select* from i_user where name=?";
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setString(1, user.getName());
		ResultSet rs = prmt.executeQuery();
		if(rs.next()) {
			flag = true;
		}
		return flag;
		}
}
