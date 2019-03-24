package springboot.com.alibab.demo.mapper;

import java.util.List;

import springboot.com.alibab.demo.entity.User;

public interface UserMapper {
	
	int deleteByPrimaryKey(Integer userId);
	
	int createUser(User user);
	
	int insertSelective(User user);
	
	User findUserByUserId(Integer userId);
	
	int updateByUserIdSelective(Integer UserId);

    int updateByUserId(Integer userId);
	
	List<User> findAllUser();
	
}
