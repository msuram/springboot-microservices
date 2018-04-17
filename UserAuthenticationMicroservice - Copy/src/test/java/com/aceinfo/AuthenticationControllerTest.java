/*package com.aceinfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.SerializationUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import com.aceinfo.controller.AuthenticationController;
import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.dto.UserLoginDetails;
import com.aceinfo.model.User;
import com.aceinfo.service.IAuthenticationService;

import net.minidev.json.JSONObject;


//@SpringBootTest(classes = AuthenticationController.class)
@WebAppConfiguration
public class AuthenticationControllerTest extends UserAuthenticationMicroserviceApplicationTest{

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private UserLoginDetails input;

	private AuthenticationResponse authenticationResponse;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		input= new UserLoginDetails("msuram","AceInfo123");
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		//input.setUserLoginName("msuram");
		//input.setUserPassword("AceInfo123");
	}

	@Test 
	public void validateUser() throws Exception

	{
		//Map<String, ?> input= "{\"userLoginName\":\"msuram\",\"userPassword\":\"AceInfo123\"}"; 
		//JSONObject jsonObject = new JSONObject(input);
		mockMvc.perform(post("/api/authenticate/")
	                .content(SerializationUtils.serialize("{\"userLoginName\":\"msuram\",\"userPassword\":\"AceInfo123\"}"))
	                .contentType(contentType))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(contentType));	                
	                
	    }
  
	   protected String json(Object o) throws IOException {
	        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
	        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
	        return mockHttpOutputMessage.getBodyAsString();
	    }
}
*/