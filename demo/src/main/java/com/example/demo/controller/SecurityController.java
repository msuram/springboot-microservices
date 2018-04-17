/**
 * 
 */
package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmailTemplate;
import com.example.demo.dto.SecurityResponse;
import com.example.demo.models.User;
import com.example.demo.service.ISecurityService;

/**
 * @author msuram
 *
 */
@RestController
@ComponentScan( basePackages = "com.example.demo.*")
//@RequestMapping(path = "/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

	// Define the logger object for this class
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	  
	@Autowired
	private ISecurityService securityService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBazz(@PathVariable String id){
	    return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
	@GetMapping("/check/{userLogin}")
	public ResponseEntity<?> checkUsre(@PathVariable String userLogin){
		
		log.debug("Entred");
		User user = securityService.findUserExistance(userLogin);
		
		SecurityResponse securityResponse = new SecurityResponse();
		
		if ( user != null) {
			securityResponse.setUserName(user.getUserFirstname() + "-" + user.getUserLastname());
			securityResponse.setEmail(user.getUserEmail());
			securityResponse.setUserStatus(user.getUserStatus());
			
			//get role names for ( )
			
			return new ResponseEntity<>( securityResponse , HttpStatus.OK);
		}
	    return new ResponseEntity<>( "Error", HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping(path = "/members", consumes = "application/json")
	String sendEmail(@RequestBody EmailTemplate emailTemplate) {
		
		return "Success";
	}
	
	/*@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }*/
	
	
	//http://www.baeldung.com/spring-requestmapping
	/*@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
	    return "Get some Foos";
	}
	
	@RequestMapping(value = "/ex/foos/{id}", method = GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariable(@PathVariable("id") long id) {
	    return "Get a specific Foo with id=" + id;
	}*/
	
	
}
