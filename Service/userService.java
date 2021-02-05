package Service;

import java.util.List;

import model.User;

public interface userService 
{
	int saveUser(User user);
	int updateUser(User user);
	int deleteUser(int  id);
	
	User getUserById(int id);
	
	List<User> getAllUser();
}
