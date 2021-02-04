package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DbUtil.Dbutil;
import model.User;

public class UserDaoImpl implements UserDao
{

	public static final String SAVE_SQL = "insert into user_tbl(user_name, password, mobile_no, salary, dob, enable)values(?,?,?,?,?,?)";
	
	public int saveUser(User user) throws Exception 
	{
		int saved = 0;
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(SAVE_SQL);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setDouble(4, user.getSalary());
			//user.setDob(5, null);
			ps.setBoolean(6, user.isEnable());
			saved = ps.executeUpdate();
		
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		return saved;
	}

	public int updateUser(User user) {
		
		return 0;
	}

	public int deleteUser(int id) {
		
		return 0;
	}

	public User getUserById(int id) {
		
		return null;
	}
	
	public List<User> getAllUser() {
		
		return null;
	}
	
}
