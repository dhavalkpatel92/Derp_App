package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.service.MessageService;

@Controller
public class SendInvitationController {
	
	@RequestMapping(value="/sendInvite",method = RequestMethod.POST)
	public String helloWorld(HttpSession session,HttpServletRequest request,User user){
		
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("../derp_app-servlet.xml");
		MessageService msg=(MessageService) context.getBean("emailservice");
		String status=msg.sendMessage((String) session.getAttribute("key"), request.getParameter("email"),user, "Invitation", "http://localhost:8084/DerpDemo/register.jsp");
		
		request.setAttribute("emailstatus", status);
		return "index";
	}
}
