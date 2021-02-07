package Service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class userServiceImp implements userService
{
	UserDao userDao;

	public userServiceImp()
	{
		userDao = new UserDaoImpl();
	}
	public int saveUser(User user)
	{
		
		return userDao.saveUser(user);
	}

	public int updateUser(User user)
	{
		
		 return userDao.updateUser(user);
	}

	public int deleteUser(int id) 
	{
		
		return userDao.deleteUser(id);
	}

	public User getUserById(int id)
	{
		
		return userDao.getUserById(id);
	}

	public List<User> getAllUser()
	{
		
		return userDao.getAllUser();
	}
	
}
