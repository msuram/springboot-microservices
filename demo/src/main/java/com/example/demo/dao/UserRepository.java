/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;

/**
 * @author msuram
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserLogin(String userLogin);
}
