package com.RecipeBook;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void send(String from, String to, String subject, String messege) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(messege , true);
		mimeMessageHelper.setSentDate(new Date());
		javaMailSender.send(mimeMessage);
		
		

	}

}
