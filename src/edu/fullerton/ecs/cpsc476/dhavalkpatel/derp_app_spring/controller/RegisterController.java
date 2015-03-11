package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.dao.UserDao;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.daoimpl.UserDAOImpl;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.service.MessageService;

@Controller
@RequestMapping("/register")
public class RegisterController{
 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get_Reg_Form(ModelMap model){
		return new ModelAndView("register", "command", new User());
		//return "register";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register_user(@ModelAttribute User user,ModelMap model,HttpServletRequest request){
		user.setUser(user.getFirstName(), user.getLastname(), user.getEmail(), user.getPassword(),null);
		UserDao udao=UserDAOImpl.getInstance();
		boolean status = udao.CreateUser(user);
		if(status)
		{
			request.setAttribute("reg_status", "success");
		}
		else
		{
			request.setAttribute("reg_status", "invalid");
		}
		return new ModelAndView("register", "command", new User());
	}
}
