package springboot.com.alibab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import springboot.com.alibab.entity.User;
import springboot.com.alibab.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public String getAllUser(){
		List<User> allUser = userService.getAllUser();
		return JSON.toJSONString(allUser);
	}
}
