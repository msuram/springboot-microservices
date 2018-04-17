/**
 * Authentication Controller to authenticate user based on login name and password
 */
package com.aceinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.dto.UserLoginDetails;
import com.aceinfo.service.IAuthenticationService;

/**
 * @author msuram
 *
 */
@RestController
@ComponentScan(basePackages = "com.aceinfo.*")
@RequestMapping(path = "/api/")
public class AuthenticationController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAuthenticationService authenticationService;
	
    /*
     * /api/authenticate
     *  ResponseBody: 
     *  {
         "userLoginName":"",
          "userPassword":""
        }
     * */
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST) 
	public ResponseEntity<?> authenticate(@RequestBody UserLoginDetails input) {
		
		AuthenticationResponse authenticationResponse = authenticationService.ValidateByUserLogin(input.getUserLoginName(), input.getUserPassword());
		if (authenticationResponse != null) {
			log.debug("authentication response", authenticationResponse.getUserName());
			return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User Name or Password is Incorrect", HttpStatus.UNAUTHORIZED);
		}
	}
	
}
