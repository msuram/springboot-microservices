package com.aceinfo.dao;

import org.springframework.data.repository.CrudRepository;

import com.aceinfo.model.User;

/*
 * User data access object to perform CRUD operations. 
 * */

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserLogin(String userLogin);

}
