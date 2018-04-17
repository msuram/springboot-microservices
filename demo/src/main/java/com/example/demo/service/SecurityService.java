package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.util.AppEncDecode;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserroleRepository;
import com.example.demo.dto.SecurityResponse;
import com.example.demo.models.User;

@Service
public class SecurityService implements ISecurityService {

	@Autowired
	private  UserRepository userRepository;	
	@Autowired
	private  RoleRepository roleRepository;
	@Autowired
	private  UserroleRepository userroleRepository;
	
	
	/*public SecurityService(UserRepository userRepository, RoleRepository roleRepository,
			UserroleRepository userroleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userroleRepository = userroleRepository;
	}*/

	@Override
	public User findUserExistance(String userLogin) {
		
		User user = userRepository.findByUserLogin(userLogin);
		
		return user;
		
	}
	
	@Override
	public SecurityResponse findUser(String userName, String encodedPassword) {
		//do input validations
		if( 1 == 2) {
			return null;
		}
		
		//get decoded password
		String decodedPassword = AppEncDecode.decode(encodedPassword);
		
		String storedPassword = "";
		
		SecurityResponse securityResponse = new SecurityResponse();
		
		//Get User
		User user = userRepository.findByUserLogin(userName);
		
		if( user != null && user.getUserStatus() && user.getUserPassword() != null) {
			//check decoded passwords
			storedPassword = AppEncDecode.decode(user.getUserPassword());
			
			if ( decodedPassword.equals(storedPassword)) {
				securityResponse.setUserName(user.getUserLogin());
				securityResponse.setEmail(user.getUserEmail());
				securityResponse.setUserStatus(user.getUserStatus());
			}
		}
		
		return securityResponse;
	}

	@Override
	public String sendEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
