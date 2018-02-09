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
	
	//이메일중복체크 uservo 객체가 null이 아니면 (이미가입되있는 이메일=중복이메일=가입할수x) false값 리턴.
	public boolean emailCheck(String email) {
		boolean result;
		UserVo uservo = userDao.getUser(email);
		
		if(uservo !=null) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
 
}
