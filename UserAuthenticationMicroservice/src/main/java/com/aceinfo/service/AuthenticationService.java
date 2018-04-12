package com.aceinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceinfo.dao.RoleRepository;
import com.aceinfo.dao.UserRepository;
import com.aceinfo.dto.AuthenticationResponse;
import com.aceinfo.model.Role;
import com.aceinfo.model.User;
import com.aceinfo.model.Userrole;

/*
 * Service to perform Authentication  . 
 * */

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private UserRepository userRepository;
	private User user;
	private Role role;

	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	/**
	 * Validate the user details and provide response accordingly
	 */
	@Override
	public AuthenticationResponse ValidateByUserLogin(String userLogin, String password) {

		user = userRepository.findByUserLogin(userLogin);

		if (user != null && user.getUserStatus() && user.getUserPassword().equals(password)) {
			List<String> roleNames = new ArrayList<>();
			authenticationResponse.setUserName(user.getUserFirstname() + " " + user.getUserLastname());
			authenticationResponse.setEmail(user.getUserEmail());

			List<Userrole> userroles = user.getUserroles();

			for (Userrole userrole : userroles) {

				role = userrole.getRole();

				roleNames.add(role.getRoleName());

			}

			authenticationResponse.setRoleNames(roleNames);
			return authenticationResponse;
		}

		else
			return null;
	}

}
