package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lms.model.User;
import com.lms.util.StringUtil;

public class UserDao {
	
	/**
	 * 获取所有读者信息和通过姓名搜索
	 * @param con
	 * @param User
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet getUsersInfo(Connection con, User user) throws Exception{
		User resultUser = null;
		StringBuffer sb = new StringBuffer("select * from i_user");
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" where name  like '%"+user.getName()+"%'");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs;
	}
	
	/**
	 * 删除读者信息
	 * @param con
	 * @param User
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteUserInfo(Connection con,User user) throws Exception{
		String sql = "delete from i_user where id = ? and num_of_book = 0";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		return pstmt.execute();
	}
	
	/**
	 * 更新读者信息
	 * @param con
	 * @param User
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean updateUserInfo(Connection con,User user) throws Exception{
		String sql = "update i_user set name = ?, sex = ?, age = ?, professional = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getsex());
		pstmt.setInt(3, user.getAge());
		pstmt.setString(4, user.getprofessional());
		pstmt.setInt(5,user.getId());
		return pstmt.execute();
	}
	
	/**
	 * 添加读者信息
	 * @param con
	 * @param User
	 * @return
	 * @throws Exception
	 */
	public Boolean insertUserInfo(Connection con,User user) throws Exception{
		String sql = "insert into i_user(name,sex,age,professional) values(?,?,?,?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getsex());
		pstmt.setInt(3, user.getAge());
		pstmt.setString(4, user.getprofessional());
		return pstmt.execute();
	}
}
