package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.User;
import mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public List<User> loginInUser() {
		return userMapper.loginInUser();
	}

	public boolean registered(User user) {
		return userMapper.registered(user);
	}
	public boolean deleteUser(String userName) {
		return userMapper.deleteUser(userName);
	}
	public User getUserByName(String userName) {
		return userMapper.getUserByName(userName);
	}
}
