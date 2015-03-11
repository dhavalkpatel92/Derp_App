package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		
		return "redirect:/welcome.htm";
	}
}
