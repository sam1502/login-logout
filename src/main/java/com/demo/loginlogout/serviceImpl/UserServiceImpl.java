package com.demo.loginlogout.serviceImpl;

import com.demo.loginlogout.data.User;
import com.demo.loginlogout.repository.UserRepository;
import com.demo.loginlogout.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean createUser(User user) {
        boolean created = false;
        try {
            userRepository.save(user);
            created = true;
        } catch (Exception e) {
            //log.error("Error while inserting user to database : {}", e);
        }
        return created;
    }

    @Override
    public User findById(int id) {
        List<User> users = userRepository.findAllById(Collections.singleton(id));
        return users.get(0);
    }

}
