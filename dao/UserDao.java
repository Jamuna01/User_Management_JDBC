package dao;

import java.util.List;

import model.User;

public interface UserDao 
{
	int saveUser(User user) throws Exception;
	int updateUser(User user);
	int deleteUser(int  id);
	
	User getUserById(int id);
	
	List<User> getAllUser();
}
