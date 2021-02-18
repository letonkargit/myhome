package com.myhome.services;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public boolean isValidUser(String userLoggedIn) {
        if(userLoggedIn != null && !userLoggedIn.isEmpty()) {
            return true;
        }
        return false;
    }
}
