package com.aceinfo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.aceinfo.controller.AuthenticationController;
import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.model.User;
import com.aceinfo.service.IAuthenticationService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {
	@Autowired
    private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	@Autowired
	private IAuthenticationService authenticationservice;
 
    @Before
    public void setup() {
    	mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
	@Test
	public void givenUserLogin_whenGetAuthenticationResponse_thenReturnJsonArray()
			  throws Exception {
			    User mounika = new User();
			    mounika.setUserLogin("msuram");
			    mounika.setUserPassword("AceInfo123");
			    AuthenticationResponse authenticationResponse = new AuthenticationResponse();
			    authenticationResponse.setUserName("Mounika Suram");
				authenticationResponse.setEmail("msuram@aceinfosolutions.com");
				
			    //given(service.ValidateByUserLogin(mounika.getUserLogin(),mounika.getUserPassword()).willReturn(authenticationResponse.getUserName());
			 
			    mockmvc.perform(get("/api/authenticate/user?login=msuram&&password=AceInfo123"))
			      .andExpect(status().isOk())
			      .andExpect(content().contentType("application/json;charset=UTF-8"))
			      .andExpect(jsonPath("$.userName").value(authenticationResponse.getUserName()))
			      .andExpect(jsonPath("$.email").value(authenticationResponse.getEmail()))
			      .andExpect(jsonPath("$.roleNames").value(authenticationResponse.getUserName()));
			}

}
