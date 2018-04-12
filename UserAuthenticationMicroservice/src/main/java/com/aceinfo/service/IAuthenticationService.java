package com.aceinfo.service;

import org.springframework.stereotype.Service;

import com.aceinfo.dto.AuthenticationResponse;

@Service
public interface IAuthenticationService {
	
	public AuthenticationResponse ValidateByUserLogin(String userLogin,String Password); 

}
