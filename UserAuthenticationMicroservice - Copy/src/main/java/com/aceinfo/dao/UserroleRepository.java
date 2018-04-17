package com.aceinfo.dao;

import org.springframework.data.repository.CrudRepository;

import com.aceinfo.model.Userrole;

/*
 * Userrole data access object to perform CRUD operations. 
 * */

public interface UserroleRepository extends CrudRepository<Userrole, Integer> {

}
