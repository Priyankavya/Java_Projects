package com.lms.dao;

import com.lms.pojo.user;

public interface userDao {
	public user checkLogin(String username,String password);

}
