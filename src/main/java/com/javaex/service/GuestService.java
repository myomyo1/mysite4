package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	@Autowired
	GuestDao gbDao;

	public List<GuestVo> showListAll() {
		List<GuestVo> glist = gbDao.showListALL(); 
		return glist;
	}
	
	public int insertGuestbook(GuestVo guestvo) {
		return gbDao.insertGuestbook(guestvo);
		
	}

	public int deleteGuestbook(Map<String, String> map) {
		return gbDao.deleteGuestbook(map);
		
	}

}
