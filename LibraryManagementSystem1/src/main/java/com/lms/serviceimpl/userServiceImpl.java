package com.lms.serviceimpl;

import com.lms.daoimpl.UserDaoImpl;
import com.lms.pojo.user;
import com.lms.dao.userDao;
import com.lms.service.userService;

public class userServiceImpl implements userService {

	userDao ud=new UserDaoImpl();
	@Override
	public user checkLogin(String username, String password) {
	
		return ud.checkLogin( username,  password);
	}

	

}
