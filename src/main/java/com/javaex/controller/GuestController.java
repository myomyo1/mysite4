package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("/gb")
public class GuestController {
	
	@Autowired
	GuestService gbService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<GuestVo> glist = gbService.showListAll();
		model.addAttribute("glist", glist);
		return "guestbook/list";
	}
	@RequestMapping("/write")
	public String write(@ModelAttribute GuestVo guestvo) {
		gbService.insertGuestbook(guestvo);
		return "redirect:/gb/list";
	}
	
	@RequestMapping("/deleteform")
	public String deleteform() {
		return "guestbook/deleteform";
	}
		
	@RequestMapping("/delete")
	public String delete(@RequestParam Map<String, String> map) {
		gbService.deleteGuestbook(map);
		return "redirect:/gb/list";
	}
	
	@RequestMapping(value = "/listajax", method=RequestMethod.GET)
	public String listajax() {
		return "guestbook/listajax"; 
	}
	
}
