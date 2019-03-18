package springboot.com.alibab.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import springboot.com.alibab.demo.entity.User;
import springboot.com.alibab.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public String getAllUser(){
		
		
		List<User> allUser = userService.getAllUser();
		return JSON.toJSONString(allUser);
	}
}
