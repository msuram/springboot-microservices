package com.aceinfo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;

import com.aceinfo.dao.*;
import com.aceinfo.model.*;



public class UserRepositoryTest extends UserAuthenticationMicroserviceApplicationTest {

	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void whenFindByUserLogin_thenReturnUser() {

		// given
		User mounika = new User();
		mounika.setUserLogin("msuram");
		
		// when
		User found = userRepository.findByUserLogin(mounika.getUserLogin());

		// then
		assertThat(found.getUserLogin()).isEqualTo(mounika.getUserLogin());

	}

}
