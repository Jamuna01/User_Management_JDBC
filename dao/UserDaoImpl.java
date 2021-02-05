package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
import DbUtil.Dbutil;
import DbUtil.QueryUtil;
import model.User;

public class UserDaoImpl implements UserDao
{
	
	public int saveUser(User user) throws Exception 
	{
		int saved = 0;
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(QueryUtil.SAVE_SQL);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setDouble(4, user.getSalary());
			ps.setDate(5, Date.valueOf(user.getDob()));
			ps.setBoolean(6, user.isEnable());
			saved = ps.executeUpdate();
		
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		return saved;
	}

	public int updateUser(User user)
	{
		int updated = 0;
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(QueryUtil.UPDATE_SQL);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setDouble(4, user.getSalary());
			ps.setDate(5, Date.valueOf(user.getDob()));
			ps.setBoolean(6, user.isEnable());
			ps.setInt(7, user.getId());
			updated = ps.executeUpdate();
		
		}
	
		 catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return updated;
		
	}

	public int deleteUser(int id) 
	{
		
		int deleted = 0;
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(QueryUtil.DELETE_SQL);
			ps.setInt(1, id);
			deleted = ps.executeUpdate();
		}
	
		 catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return deleted;
	}

	public User getUserById(int id) 
	{
		User user = new User();
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(QueryUtil.GET_BY_ID_SQL);
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getDate("dob").toLocalDate());
				user.setSalary(rs.getDouble("salary"));
				user.setMobile_no(rs.getLong("mobile_no"));
				user.setEnable(rs.getBoolean("enable"));
				
			}
		}
	
		 catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<User> getAllUser()
	{
		List<User> userList = new ArrayList<User>();
		try
		{
			PreparedStatement ps = Dbutil.getConnection().prepareStatement(QueryUtil.LIST_SQL);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getDate("dob").toLocalDate());
				user.setSalary(rs.getDouble("salary"));
				user.setMobile_no(rs.getLong("mobile_no"));
				user.setEnable(rs.getBoolean("enable"));
				userList.add(user);
			}
		}
	
		 catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return userList;
	}
	
}
