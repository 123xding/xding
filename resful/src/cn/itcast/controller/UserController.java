package cn.itcast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	//去登陆页面的请求
	@RequestMapping(value="/toLogin",method=RequestMethod.GET)
    public String toLogin(){
    	return "login";
    }
	//登陆页面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String username,String password,HttpSession session){
		System.out.println("用户名"+username);
		System.out.println("密码:"+password);
		if(username!=null&&!"".equals(username)){
			session.setAttribute(session.getId(), username);
		}
		return "redirect:/items/list";
	}
}
