package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao bdao;

	public List<BoardVo> showListAll(String kwd) {
		List<BoardVo> blist;
		
		if(kwd.equals("")) {
			blist = bdao.showListAll();
		}else{
			blist = bdao.searchingKwd("%"+kwd+"%");	
		}
		return blist;
	}

	public int insertboard(Map<String, String> map) {
		return bdao.insertboard(map); 
		
	}

	public int deleteboard(int no) {
		return bdao.deleteboard(no);
		
	}

	public BoardVo viewboard(int no) {
		bdao.counthit(no);
		return bdao.viewboard(no);
		
	}

	public BoardVo modifyboard(int no) {
		return bdao.moifyboard(no);
		
	}

	public int updateboard(BoardVo vo) {
		return bdao.updateboard(vo);
		
	}


}
