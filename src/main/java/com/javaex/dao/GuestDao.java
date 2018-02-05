package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	@Autowired
	SqlSession sqlSession;

	public List<GuestVo> showListALL() {
		return sqlSession.selectList("gb.showListAll");
	}

	public int insertGuestbook(GuestVo guestvo) {
		return sqlSession.insert("gb.insertGuestbook", guestvo);
	}

	public int deleteGuestbook(Map<String, String> map) {
		return sqlSession.delete("gb.deleteGuestbook", map);
	}
	


}
