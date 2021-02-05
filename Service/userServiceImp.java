package Service;

import java.util.List;

import model.User;

public class userServiceImp implements userService
{
	userService userService;

	public userServiceImp()
	{
		userService = new userServiceImp();
	}
	public int saveUser(User user)
	{
		
		return userService.saveUser(user);
	}

	public int updateUser(User user)
	{
		
		 return userService.updateUser(user);
	}

	public int deleteUser(int id) 
	{
		
		return userService.deleteUser(id);
	}

	public User getUserById(int id)
	{
		
		return userService.getUserById(id);
	}

	public List<User> getAllUser()
	{
		
		return userService.getAllUser();
	}
	
}
