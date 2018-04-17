/**
 * 
 */
package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import com.example.demo.models.Role;

import lombok.Data;

/**
 * @author msuram
 *
 */

//@Data
public class SecurityResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	 private String userName;
	 
	 private String email;
	 
	 private Boolean userStatus;
	 
	 private List<String> userRoles;
	 
	 

	public SecurityResponse() {
		super();
	}

	public SecurityResponse(String userName, String email, Boolean userStatus, List<String> userRoles) {
		super();
		this.userName = userName;
		this.email = email;
		this.userStatus = userStatus;
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SecurityResponse [userName=").append(userName).append(", email=").append(email)
				.append(", userStatus=").append(userStatus).append(", userRoles=").append(userRoles).append("]");
		return builder.toString();
	}

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

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
	 
	 
	 
}
