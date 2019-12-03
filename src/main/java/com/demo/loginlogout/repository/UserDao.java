package com.demo.loginlogout.repository;

import com.demo.loginlogout.data.JWTDAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<JWTDAOUser, Integer> {

    JWTDAOUser findByUsername(String username);

}