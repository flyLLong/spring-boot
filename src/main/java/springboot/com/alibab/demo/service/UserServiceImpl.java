package springboot.com.alibab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.com.alibab.entity.User;
import springboot.com.alibab.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		return userMapper.findAllUser();
	}

}
