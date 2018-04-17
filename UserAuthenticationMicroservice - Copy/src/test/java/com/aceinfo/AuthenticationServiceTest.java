package com.aceinfo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.service.AuthenticationService;
import com.aceinfo.service.IAuthenticationService;


public class AuthenticationServiceTest extends UserAuthenticationMicroserviceApplicationTest {

	@TestConfiguration
	static class AuthenticationServiceTestContextConfiguration {

		@Bean
		public IAuthenticationService authenticationService() {
			return new AuthenticationService();
		}
	}

	@Autowired
	private IAuthenticationService authenticationService;

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {

		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setUserName("mounika surram");
		authenticationResponse.setEmail("msuram@aceinfosolutions.com");
		String userLogin = "msuram";
		String password = "AceInfo123";
		AuthenticationResponse found = authenticationService.ValidateByUserLogin(userLogin, password);
		assertThat(found.getUserName()).isEqualTo(authenticationResponse.getUserName());
		assertThat(found.getEmail()).isEqualTo(authenticationResponse.getEmail());
	}

}
