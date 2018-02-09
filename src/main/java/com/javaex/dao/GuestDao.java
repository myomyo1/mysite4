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
	
	///////////////////////////////////////////////////////
	
	public List<GuestVo> selectGuestListPage(int page){
		return sqlSession.selectList("gb.selectListByPage",page);
	}

	public GuestVo writeajax(GuestVo gvo) {
		System.out.println(gvo.getNo()); //0
		sqlSession.insert("gb.insertGuestbookajax",gvo);
		int resultNo = gvo.getNo(); //시퀀스의 다음값이 담겨있다
		System.out.println(resultNo);
		return gvo;
	}

	public String sysdate(int no) {
		return sqlSession.selectOne("gb.sysdate", no);
	}

	public int deleteajax(Map<String, String> map) {
		return sqlSession.delete("gb.deleteGuestbook", map);
	}

	
	


}
