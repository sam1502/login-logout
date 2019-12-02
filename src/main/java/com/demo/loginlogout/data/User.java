package com.demo.loginlogout.data;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String email;

    @Column(name = "pass")
    private String password;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


