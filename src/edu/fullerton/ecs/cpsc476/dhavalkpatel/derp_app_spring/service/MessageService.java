package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.service;

import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;

public interface MessageService {
	String sendMessage(String from,String to,User user,String subject,String msg);
}
