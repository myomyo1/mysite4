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
	//ajax : 페이지 이동 하지 않기 위해서 사용하는것. 따라서 이메일 중복체크시에만 사용하고 나머지 그대로 이용.
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
