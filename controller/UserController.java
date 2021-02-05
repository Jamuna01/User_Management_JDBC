package controller;

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
				
				userList.forEach(user-> {
					System.out.println("User id is: "+ user.getId());
					System.out.println("User name is: "+ user.getUserName());
					System.out.println("User password is: "+ user.getPassword());
					System.out.println("User mobile number is: "+ user.getMobileNo());
					System.out.println("User salary is: "+ user.getSalary());
					System.out.println("User DOB is: "+ user.getDob());
					System.out.println("Is user enabled? "+ user.isEnable());
				});
				break;
				
				
			}
		}
		while(true);
	}
}
