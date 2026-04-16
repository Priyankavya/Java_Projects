package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.dao.userDao;
import com.lms.pojo.user;
import com.lms.util.Dbutil;

public class UserDaoImpl  implements userDao{

	@Override
	public user checkLogin(String username, String password) {
		Connection conn=null;
		
		try {
			String query="select * from users where email=? and password=?";
			
			 conn=Dbutil.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				user u=new user();
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				u.setPhoneNo(rs.getString("phone_no"));
				
				return u;
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return null;
	}

	

}
