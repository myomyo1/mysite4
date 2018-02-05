package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public UserVo login(Map<String, String> map) {
		return userDao.getUser(map);
	}
	
	public int modify(UserVo uservo) {
		return userDao.modifyUser(uservo);
	}

	public int join(Map<String, String> map) {
		return userDao.join(map);
	}

 
}
