package com.aceinfo.dto;

import java.util.List;

public class MailTemplate {
	private List<String> toList;
	private List<String> cCList;
	private List<String> bCCList;
	private String subject;
	private String messageBody;
	public List<String> getToList() {
		return toList;
	}
	public void setToList(List<String> toList) {
		this.toList = toList;
	}
	public List<String> getcCList() {
		return cCList;
	}
	public void setcCList(List<String> cCList) {
		this.cCList = cCList;
	}
	public List<String> getbCCList() {
		return bCCList;
	}
	public void setbCCList(List<String> bCCList) {
		this.bCCList = bCCList;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
}
