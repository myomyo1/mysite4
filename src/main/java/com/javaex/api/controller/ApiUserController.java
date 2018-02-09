package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class ApiUserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/user/api/emailcheck", method = RequestMethod.POST)
	//public boolean emailCheck(@RequestParam("email") String email) {
	public boolean emailCheck(@RequestBody UserVo uservo) { //ajax에서 보낸 데이터 받은 것.
		boolean result = userService.emailCheck(uservo.getEmail());
		System.out.println(result);
		return result;

		
		}
	

}
