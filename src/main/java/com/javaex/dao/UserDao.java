package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlsession;
	
	public UserVo getUser(Map<String, String> map) {
		return sqlsession.selectOne("user.selectUserByEmailandPw",map); //no, name, email 가져옴
		
	}
	
	public int modifyUser(UserVo uservo) {
		return sqlsession.update("user.updateUserNameandPw", uservo);
	}

	public int join(Map<String, String> map) {
		return sqlsession.insert("user.insertUser", map);
	}
	
	//이메일 중복체크하기위함
	public UserVo getUser(String email) {
		UserVo uservo = sqlsession.selectOne("user.selectUserByEmail",email);
		return uservo;
		
	}

	
	
	



}
