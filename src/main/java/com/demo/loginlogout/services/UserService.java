package com.demo.loginlogout.services;

import com.demo.loginlogout.data.User;

public interface UserService {

    boolean createUser(User user);
    User findById(int id);
}
