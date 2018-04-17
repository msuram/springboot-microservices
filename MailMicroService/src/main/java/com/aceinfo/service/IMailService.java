package com.aceinfo.service;

import org.springframework.stereotype.Service;

@Service
public interface IMailService {
	
	  public void sendMail(String[] toEmail, String subject, String message);

}
