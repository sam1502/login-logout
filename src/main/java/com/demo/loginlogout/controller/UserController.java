package com.demo.loginlogout.controller;

import com.demo.loginlogout.data.User;
import com.demo.loginlogout.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@Slf4j
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    Jedis jedis = new Jedis("localhost");

    @PostMapping("/create")
    public boolean createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/login/{id}/{pass}")
    public ResponseEntity<String> loginUser(@PathVariable int id, @PathVariable String pass) {
        User user = userService.findById(id);

        if (user != null && user.getPassword().equals(pass)) {
            jedis.set(String.valueOf(user.getUserId()), "logged-in");
        }

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/logout/{id}")
    public String logoutUser(@PathVariable int id) {
        String response = "";
        if (jedis.get(String.valueOf(id)) != null) {
            jedis.expire(String.valueOf(id), 1);
            response = "logged-out";
        } else {
            response = "already logged out";
        }
        return response;
    }

    @GetMapping("/is-loggedin/{id}")
    public boolean isUSerLoggedIn(@PathVariable int id) {
        if (jedis.get(String.valueOf(id)).equals("logged-in")) {
            return true;
        }
        return false;
    }

}
