package com.spring.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.service.userService;
import com.spring.user.vo.UserVo;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	UserDao userDao;

	@Override
	public int userInsert(UserVo userVo) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userInsert(userVo);
	}
	
	@Override
	public int userIdChk(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.userIdChk(userId);
	}

}
