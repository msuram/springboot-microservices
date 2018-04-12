/**
 * Authentication Controller to authenticate user based on login name and password
 */
package com.aceinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.service.IAuthenticationService;

/**
 * @author msuram
 *
 */
@RestController
@ComponentScan(basePackages = "com.example.demo.*")
@RequestMapping(path = "/api/")
public class AuthenticationController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAuthenticationService authenticationService;

	/**
	 * ... /authenticate/user?login=""&&password=""
	 * 
	 * @param userLogin
	 * @param password
	 * @return authentication response
	 */
	@RequestMapping(value = "/authenticate/user", params = { "login", "password" }, method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<?> authenticate(@RequestParam("login") String userLogin,
			@RequestParam("password") String password) {
		// input validations

		// authenticationService= new AuthenticationService();

		AuthenticationResponse authenticationResponse = authenticationService.ValidateByUserLogin(userLogin, password);
		if (authenticationResponse != null)
			return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>("User Name or Password is Incorrect", HttpStatus.UNAUTHORIZED);
	}

}
