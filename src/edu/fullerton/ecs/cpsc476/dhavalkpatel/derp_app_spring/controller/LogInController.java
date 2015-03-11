package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.dao.UserDao;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.daoimpl.UserDAOImpl;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;

@Controller
//@RequestMapping("/welcome")
public class LogInController{
 
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String helloWorld(){
		return "index";
	}
	@RequestMapping(value="/welcome",method = RequestMethod.POST)
	public String logincheck(@RequestParam("email") String email,@RequestParam("password") String password,@ModelAttribute User user,HttpSession session,HttpServletRequest request ,ModelMap model){
		session = request.getSession();
		UserDao udao=UserDAOImpl.getInstance();
		String status = udao.CheckUser(email, password, user);
		switch (status) {
		case "no_records":
			session.setAttribute("loginstatus", "noemail");
			//System.out.println("asd");
			break;
		case "success":
			session.setAttribute("loginstatus", "success");
			session.setAttribute("key",udao.getUser(email).getEmail());
			session.setAttribute("username",udao.getUser(email).getFirstName() + " " +udao.getUser(email).getLastname());
			session.setAttribute("UserList", udao.getUser(email).getUsers());
			break;		
		case "NotValid":
			session.setAttribute("loginstatus", "wrongpwd");
			//System.out.println("Its wrong");
			break;
		default:
		
			break;
		}
		request.setAttribute("loginstatus", "success");
		return "index";
	}
}

