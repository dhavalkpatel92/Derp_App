package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.dao.UserDao;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;

public class UserDAOImpl implements UserDao {

	private static UserDao userdao = null;
	private Map<String, User> userMap;
	   public UserDAOImpl() {
		   userMap = new HashMap<>();
		   // userMap.put("dk@patel.com", new User("dk","patel", "dk@patel.com", "password",null));
	   }
	   
	  public static UserDao getInstance() {
		      if(userdao == null) {
		    	  userdao = new UserDAOImpl();
		      }
		      return userdao;
		   }
	   
	@Override
	public boolean CreateUser(User user) {
		// TODO Auto-generated method stub
		if(!(userMap.containsKey(user.getEmail())))
		{
			userMap.put(user.getEmail(),user);
			System.out.println(userMap);
			return true;
		}
		return false;
	}

	@Override
	public String CheckUser(String email,String password,User user) {
		// TODO Auto-generated method stub
		
		if(!(userMap.containsKey(email)))
		{
			return "no_records";
		}
		else
		{
			if(email.equals(userMap.get(email).getEmail()) && password.equals(userMap.get(email).getPassword()))
			{
				//System.out.println("kkdasdjij");
				return "success";
			}
			else
			{
				return "NotValid";
			}
		}
		
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		//User
		User user=userMap.get(email);
		return user;
	}

	@Override
	public String AddFriend(String key, String add_email, List<User> users) {
		// TODO Auto-generated method stub
		User user=getUser(add_email);
		users=(users==null)?new ArrayList<User>():users;
		//System.out.println(users);
		
		if(user==null)
		{
			return "not_found";
		}
		else
		{
			if(getUser(key).getUsers() != null)
			{
				if(getUser(key).getUsers().contains(add_email))
				{
					return "already_added";
				}
			}
			
			if(getUser(add_email).equals(getUser(key)))
			{
				return "Invalid";
			}
			
			else
			{
				users.add(user);
				getUser(key).setUsers(users);
				return "success";
			}
		}
	}

	@Override
	public boolean DeleteFriend(String key, String email1) {
		// TODO Auto-generated method stub
		User del_user=getUser(email1);
		User cu_user=getUser(key);
		cu_user.getUsers().remove(del_user);
		return true;
	}
}
