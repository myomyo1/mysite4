package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileuploadService;
import com.javaex.vo.FileVo;


@Controller
@RequestMapping("/fileupload")
public class FileuploadController {
	
	@Autowired
	private FileuploadService fservice;
	
	@RequestMapping("/formAndList")
	public String formAndList(Model model){ 
		List<FileVo> flist = fservice.showFormAndList();
		model.addAttribute("flist", flist);
		return  "fileupload/form";
	}

	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) { //파일을 담을 수 있는 객체 이름 : multipart
		String saveName = fservice.upload(file);
		
		String url = "upload/"+ saveName; //jsp에게 보낼때 dispatcherServlet필요 (모델에담아보내면됨)
		model.addAttribute("url", url); //DS가 result.jsp로 보내줌
		return "fileupload/result";
	}
	
	@RequestMapping("/delete")
	public String deletepic(@RequestParam("no") int no){
		fservice.deletepic(no);
		return "redirect:/fileupload/formAndList";
	}
}

