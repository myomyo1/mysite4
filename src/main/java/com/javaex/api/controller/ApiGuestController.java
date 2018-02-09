package com.javaex.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestController {
	
	@Autowired
	private GuestService gService;
	
	@ResponseBody
	@RequestMapping(value="/gb/api/list", method = RequestMethod.POST)
	public List<GuestVo> apiNextList(@RequestParam("page") int page) {
		List<GuestVo> glist = gService.getNextGlistPage(page);
		return glist;
	}
	
	@ResponseBody
	@RequestMapping(value="/gb/api/write", method = RequestMethod.POST)
	//public 다음타입 : 뒤에 넘겨줄 변수타입 , 함수()괄호안 타입=받아올 타입
	//jsp에서 <form>안에서 넘겨주는 것들(=헤더부분)은 @requestparam 으로받음.
	//ajax통해서 넘겨주는 것들(=바디)은 @requestbody로 받음.
	public GuestVo writeajax(@RequestBody GuestVo gvo) {
		System.out.println(gvo.toString());
		return gService.writeajax(gvo);
	}
	
	@ResponseBody
	@RequestMapping(value="/gb/api/delete", method = RequestMethod.POST)
	public int deleteajax(@RequestParam Map<String, String> map) {
		return gService.deleteajax(map);
	}
	
	

}
