package com.jason.mail.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringEmail {
	
	@Value("${spring.mail.username}")
	private String sender;
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping("/springemail")
	public String springemail(String toEmail, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender);
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(content);
		try {
			javaMailSender.send(message);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
}
