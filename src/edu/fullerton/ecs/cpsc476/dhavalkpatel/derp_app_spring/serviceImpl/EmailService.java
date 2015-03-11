package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.serviceImpl;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model.User;
import edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.service.MessageService;

public class EmailService implements MessageService {

	@Override
	public String sendMessage(String from, String to, User user,String subject,String msg) {
		// TODO Auto-generated method stub
		Email email = new SimpleEmail();
		email.setHostName("localhost");
		email.setSmtpPort(2525);
		email.setSubject(subject);
		try {
			email.setMsg(msg);
			email.setFrom(from);
			email.addTo(to);
			email.send();
			return "success";
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notvalid";
		}
		
	}

}
