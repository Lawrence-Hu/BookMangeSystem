package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lms.model.User;
import com.lms.util.StringUtil;

public class UserDao {
	
	/**
	 * 获取所有读者信息
	 * @param con
	 * @param user
	 * @return ResultSet
	 * @throws Exception
	 */
	public ResultSet getUsersInfo(Connection con, User user) throws Exception{
		User resultUser = null;
		StringBuffer sb = new StringBuffer("select * from b_user");
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" where u_name  like '%"+user.getName()+"%'");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		return rs;
	}
}
