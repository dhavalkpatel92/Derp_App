package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RequestParam;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.dao.UserDao;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.daoimpl.UserDAOImpl;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.service.MessageService;


@Controller
//@RequestMapping("/welcome")
public class FriendController{

	@RequestMapping(value="/addfriend",method = RequestMethod.POST)
	public String addfriend(HttpSession session,HttpServletRequest request,User user,@RequestParam("email") String add_email){
		
		session=request.getSession();
		String key=(String) session.getAttribute("key");
		UserDao udao=UserDAOImpl.getInstance();
		user=udao.getUser(key);
		
		List<User> users =udao.getUser(key).getUsers();
		String status=udao.AddFriend(key, add_email, users);
		switch (status) {
		case "success":
			request.setAttribute("add_friend_status", "success");
			break;
		case "Invalid":
			request.setAttribute("add_friend_status", "Invalid");
			break;
		default:
			request.setAttribute("add_friend_status", "not_found");
			break;
		}
		if(udao.getUser(key).getUsers() !=null)
		{
			session.setAttribute("UserList", udao.getUser(key).getUsers());
		}
		else
		{
			session.setAttribute("UserList",new ArrayList<User>());
		} 
		
		return "index";
	}
	
	@RequestMapping(value="/deletefriend",method = RequestMethod.POST)
	public String deletefriend(HttpSession session,HttpServletRequest request,User user,@RequestParam("email") String email){
		 session=request.getSession();
		String key=(String) session.getAttribute("key");
		UserDao udao=UserDAOImpl.getInstance();
		boolean result=udao.DeleteFriend(key, email);
		if(result==true)
		{
			request.setAttribute("delete_friend_status", "success");
		}
		
		return "index";
		
	}
	@RequestMapping(value="/sendDerp",method = RequestMethod.POST)
	public String sendDerp(HttpSession session,HttpServletRequest request,User user,@RequestParam("email") String email){
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("../derp_app-servlet.xml");
		MessageService msg=(MessageService) context.getBean("emailservice");
		String status=msg.sendMessage((String) session.getAttribute("key"), request.getParameter("email"),user, "Derp From  "+session.getAttribute("username"), "Derp");
		switch (status) {
		case "success":
			request.setAttribute("send_derp_status", "success");
			break;
		case "Invalid":
			request.setAttribute("send_derp_status", "Invalid");
			break;
		default:
			//request.setAttribute("send_derp_status", "not_found");
			break;
		}
		
		return "index";
		
	}
}
