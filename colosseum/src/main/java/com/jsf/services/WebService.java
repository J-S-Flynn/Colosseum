package com.jsf.services;

import com.jsf.domain.userDomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebService {

    private final UserService userService ;

    @Autowired
    public WebService(UserService us){
        userService = us;
    }

    public String getHomepage(){

        return "index" ;
    }


    public User getUser(String userName){

        return userService.getUserRepo().findByUserName(userName).get() ;
    }
}
