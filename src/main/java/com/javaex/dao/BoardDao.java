package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	SqlSession session;

	public List<BoardVo> showListAll() {
		return session.selectList("board.showListAll");
	}

	public int insertboard(Map<String, String> map) {
		return session.insert("board.insertboard", map);
	}

	public int deleteboard(int no) {
		return session.delete("board.deleteboard",no);
	}

	public BoardVo viewboard(int no) {
		return session.selectOne("board.viewboard", no);
	}

	public BoardVo moifyboard(int no) {
		return session.selectOne("board.viewboard", no);
	}

	public int updateboard(BoardVo vo) {
		return session.update("board.updateboard", vo);
	}

}
