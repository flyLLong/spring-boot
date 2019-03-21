package springboot.com.alibab.demo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import springboot.com.alibab.config.AppServiceProcess;
import springboot.com.alibab.demo.entity.User;
import springboot.com.alibab.demo.service.UserService;
import springboot.com.alibab.demo.us.BaseDomainProcess;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public String getAllUser(@RequestParam Long domainId){
		log.info("domain ID is {}", domainId);
		Map<Long, BaseDomainProcess> domainProcessMap = AppServiceProcess.getDomainProcessMap();
		BaseDomainProcess domainProcess = domainProcessMap.get(domainId);
		if(domainProcess != null){
			log.info("domain name is {}", domainProcess.getDomainName());
		}
		List<User> allUser = userService.getAllUser();
		return JSON.toJSONString(allUser);
	}
}
