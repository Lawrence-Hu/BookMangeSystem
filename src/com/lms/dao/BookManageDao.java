package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
			if(flag.equals("是"))
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
	
	public String[] SearchOne(Connection con,Book book) throws Exception {
		String[] data = new String[7];
		ResultSet rs = null;
		String sql = "select br.bno,br.id,br.bdate,i_user.name,book.bname,book.publish,datediff(day,br.bdate,getdate())-30'fun' "
					 + "from br,i_user,book where br.bno = ? and book.bno = br.bno and br.id = i_user.id and br.rdate is null";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,book.getBno());
		rs = pstmt.executeQuery();
		if(rs.next()){
			data[0] = rs.getString("bno");//书编号
			data[1] = rs.getString("bname");//书名称
			data[2] = rs.getString("publish");//出版社
			data[3] = rs.getString("id");//读者编号
			data[4] = rs.getString("name");//读者名称
			data[5] = rs.getString("bdate");//借书时间
			data[6] = rs.getString("fun");//罚款
			
		}
		return data;
	}
	
	public Boolean backBook(Connection con,Book book) throws Exception{
		String sql = "update br set rdate = getdate(), fun = ? where bno = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,book.getFun());
		pstmt.setInt(2,book.getBno());
		return pstmt.execute();
		
	}
}
