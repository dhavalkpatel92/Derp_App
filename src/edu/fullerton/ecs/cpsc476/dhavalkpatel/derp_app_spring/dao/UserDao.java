package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.dao;

import java.util.List;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;

public interface UserDao {
	boolean CreateUser(User user);
	User getUser(String email);  
//	String CheckUser(String email,User user);
	String CheckUser(String email, String password, User user);
	String AddFriend(String key,String add_email,List<User> users);
	boolean DeleteFriend(String key,String email1);
}
