package com.javaex.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user") //찾아들어올때만 /user로 인식하게만든것
public class UserController {
	
	@Autowired
	UserService userService;
	
	//http://localhost:8088/mysite4/user/loginform 
	@RequestMapping("/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
//	@RequestMapping("/login")
//	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
//		Map<String, String> map =new HashMap<String, String>();
//		map.put("email", email);
//		map.put("password",	password);
//		
//		UserVo authUser = userService.login(map);
//		System.out.println(authUser);
//		if(authUser!=null) {
//			session.setAttribute("authUser", authUser);
//			return "main/index";
//		}else {
//			return "redirect:/user/loginform?result=fail";	
//		}
//	}
	
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) { //email password 가 map에 담겨옴
		UserVo authUser = userService.login(map);
		System.out.println(authUser);
		if(authUser!=null) {
			session.setAttribute("authUser", authUser);
			return "main/index";
		}else {
			return "redirect:/user/loginform?result=fail";	
		}
	}
		
	@RequestMapping("/modifyform")
	public String modifyform(){
		return "user/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo uservo, HttpSession session){
		int result = userService.modify(uservo);
		System.out.println("처리결과 : " + result);
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		authUser.setName(uservo.getName());
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "main/index";
	}
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "user/joinform";
	}
	
	@RequestMapping("/join")
	public String join(@RequestParam Map<String, String> map ) {
		int result = userService.join(map);
		System.out.println(result);
		return "user/joinsuccess";
	}
}
