
package com.aceinfo.dao;

import org.springframework.data.repository.CrudRepository;

import com.aceinfo.model.Role;

/*
 * Role data access object to perform CRUD operations. 
 * */

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
