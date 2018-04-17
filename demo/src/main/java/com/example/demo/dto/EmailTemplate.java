package com.example.demo.dto;

import java.io.Serializable;

public class EmailTemplate implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private String toList;
	
	private String ccList;
	
	private String subject;
	
	private String mailBody;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailTemplate [toList=").append(toList).append(", ccList=").append(ccList).append(", subject=")
				.append(subject).append(", mailBody=").append(mailBody).append("]");
		return builder.toString();
	}

	public EmailTemplate(String toList, String ccList, String subject, String mailBody) {
		super();
		this.toList = toList;
		this.ccList = ccList;
		this.subject = subject;
		this.mailBody = mailBody;
	}
	
	
}
