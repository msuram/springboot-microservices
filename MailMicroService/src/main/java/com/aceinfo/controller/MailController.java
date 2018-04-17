package com.aceinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aceinfo.service.IMailService;

@RestController
@ComponentScan(basePackages = "com.aceinfo.*")
@RequestMapping(path = "/api")
public class MailController {
	@Autowired
	public IMailService mailservice;

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	@ResponseBody
	public String sendMail(@RequestBody SimpleMailMessage mailMessage) {
		
		mailservice.sendMail(mailMessage.getTo(),mailMessage.getSubject(),mailMessage.getText());	
		return "Mail Sent"; 
		
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		//mailservice.sendMail(mailMessage.getTo(),mailMessage.getSubject(),mailMessage.getText());	
		return "Hello"; 
		
	}
}
