package mapper;

import java.util.List;

import entity.User;

public interface UserMapper {
	public List<User> loginInUser();
	public boolean registered(User user);
}
