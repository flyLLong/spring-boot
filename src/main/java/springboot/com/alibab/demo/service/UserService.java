package springboot.com.alibab.demo.service;

import java.util.List;

import springboot.com.alibab.demo.entity.User;

public interface UserService {
	
	List<User> getAllUser();
	
	User findByUserId(Integer userId);
	
}
