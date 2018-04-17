package com.aceinfo.dto;

import java.util.List;

/*
 * Data transmission object top be displayed as our response
 * */

public class AuthenticationResponse {
	
	private String userName;
	
	private String email;
	
	private List<String> roleNames;
    
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getRoleNames() {
		return roleNames;
	}
	
	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}
       
}
