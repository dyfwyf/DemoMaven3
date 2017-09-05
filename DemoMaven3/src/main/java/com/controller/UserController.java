package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.User;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/save")
	@ResponseBody
	public boolean save(User user,HttpServletResponse response){
		boolean flag=true;
		response.setHeader("Access-Control-Allow-Origin", "*");
		try{
		   this.userService.save(user);
		}catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping("/listAll")
	@ResponseBody
	public List<User> listAll(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<User> list=this.userService.listAll();
		return list;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(User user,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		this.userService.delete(user);
		try {
			this.userService.delete(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@RequestMapping("/update")
	@ResponseBody
	public String update(User user,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		this.userService.update(user);
		return "redirect:user/listAll";
	}
}
