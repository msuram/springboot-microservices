/**
 * 
 */
package com.example.demo.service;



import org.springframework.stereotype.Service;

import com.example.demo.dto.SecurityResponse;
import com.example.demo.models.User;

/**
 * @author msuram
 *
 */


@Service
public interface ISecurityService {

	public SecurityResponse findUser(String userName, String password) ;
	
	public String sendEmail();
	
	public User findUserExistance(String userLogin);
}
