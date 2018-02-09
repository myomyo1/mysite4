package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileuploadDao {
	
	@Autowired
	private SqlSession session;

	public void restore(FileVo fvo) {
		session.insert("f.insertfile", fvo);
		
	}

	public List<FileVo> showFormAndList() {
		return session.selectList("f.showPicListBySaveName");
	}

	public int deletepic(int no) {
		return session.delete("f.deletePicByNo", no);
	}
	
	

}
