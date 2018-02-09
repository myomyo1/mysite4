package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileuploadDao;
import com.javaex.vo.FileVo;

@Service
public class FileuploadService {
		
	@Autowired 
	private FileuploadDao fdao;
	
	public String upload(MultipartFile file) {
//카피하는일		
		String saveDir = "D:\\javaStudy\\upload";
		
		//파일정보 수집
				
		//원래파일이름
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);
		//저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
		System.out.println(saveName);
		//파일저장위치(path)
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
//vo만들어서 dao통해서 DB에 저장 
		FileVo fvo = new FileVo(orgName, exName, saveName, filePath, fileSize);
		fdao.restore(fvo);
		
				
		//파일카피
		try {
			byte[] fileData = file.getBytes(); //바이트단위로 파일을 읽어서 배열에 담아 둠.
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			if(bout != null) {
				bout.close();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return saveName;
	}

	public List<FileVo> showFormAndList() {
		List<FileVo> flist = fdao.showFormAndList(); 
		return flist;
	}

	public int deletepic(int no) {
		return fdao.deletepic(no);		
	}

}
 