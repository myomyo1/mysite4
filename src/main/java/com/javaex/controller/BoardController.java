package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService bservice;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardVo> blist = bservice.showListAll();
		model.addAttribute("blist", blist);
		return "/board/list";
	}
	@RequestMapping("/writeform")
	public String writeform() {
		return "/board/write";
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam Map<String, String> map, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		map.put("userNo", String.valueOf(authUser.getNo()));
		bservice.insertboard(map);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no) {
		bservice.deleteboard(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/view")
	public String view(@RequestParam("no") int no, Model model) {
		BoardVo bvo = bservice.viewboard(no);
		model.addAttribute("board", bvo);
		return "/board/view";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(@RequestParam("no") int no, Model model) {
		BoardVo bvo = bservice.modifyboard(no);
		model.addAttribute("vo", bvo);
		return "board/modify";
	}

	@RequestMapping("/modify")
	public String modify(@RequestParam("no")int no, @ModelAttribute BoardVo vo) {
		vo.setNo(no);
		bservice.updateboard(vo);
		System.out.println(vo.getNo());
		return "redirect:/board/list";
	}


}
