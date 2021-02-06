package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import Service.userService;
import Service.userServiceImp;
import model.User;

public class UserController 
{
	public static void main(String[] args)
	{
		userService userService = new userServiceImp();
		String decision = "";
		
		do
		{
			String choice = JOptionPane.showInputDialog("Which operation you want to perform:");
			
			switch(choice)
			{
			case "save":
				User user = new  User();
				int saved = userService.saveUser(user);
				if(saved >=1)
				{
					JOptionPane.showMessageDialog(null, "User info is saved successfully in db.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops!!! error in db.");
				}
				break;
				
			case "update":
				User updateUser = new  User();
				int updated = userService.updateUser(updateUser);
				
				if(updated >=1)
				{
					JOptionPane.showMessageDialog(null, "User info is updated successfully in db.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops!!! error in db.");
				}
				break;
				
			case "delete":
				int id  = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete"));
				int deleted = userService.deleteUser(id);
				
				if(deleted >=1)
				{
					JOptionPane.showMessageDialog(null, "User info is deleted successfully in db.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Oops!!! error in db.");
				}
				
				break;
			case "list":
				List<User> userList = userService.getAllUser();
				
				userList.forEach(user1 -> {
					System.out.println("User id is: "+ user1.getId());
					System.out.println("User name is: "+ user1.getUserName());
					System.out.println("User password is: "+ user1.getPassword());
					System.out.println("User mobile number is: "+ user1.getMobileNo());
					System.out.println("User salary is: "+ user1.getSalary());
					System.out.println("User DOB is: "+ user1.getDob());
					System.out.println("Is user enabled? "+ user1.isEnable());
					System.out.println("=================================");
				});
				break;
			case "get":
				int id1 = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				User user2 = userService.getUserById(id1);
				System.out.println("User id is: "+ user2.getId());
				System.out.println("User name is: "+ user2.getUserName());
				System.out.println("User password is: "+ user2.getPassword());
				System.out.println("User mobile number is: "+ user2.getMobileNo());
				System.out.println("User salary is: "+ user2.getSalary());
				System.out.println("User DOB is: "+ user2.getDob());
				System.out.println("Is user enabled? "+ user2.isEnable());
			
			break;
				
				
			}
			decision = JOptionPane.showInputDialog("do you want to continue? Enter yes| no: ");
		}
		while(decision.equalsIgnoreCase("yes"));
	}
	public static User getUser(String type)
	{
		User user = new User();
		
		if(type.equalsIgnoreCase("update"))
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
			user.setId(id);
		}
		String username = JOptionPane.showInputDialog("Enter username: ");
		String password = JOptionPane.showInputDialog("Enter password: ");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile number: "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
		String dob = JOptionPane.showInputDialog("Enter dob: ");
		LocalDate d = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		boolean enable = Boolean.parseBoolean(JOptionPane.showInputDialog("is user enabled?"));
		user.setUserName(username);
		user.setPassword(password);
		user.setMobile_no(mobileNo);
		user.setEnable(enable);
		user.setSalary(salary);
		user.setDob(d);
		
		return user;
	}
}

