package com.jsf.controller;

import com.jsf.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class WebController {

    @Autowired
    private WebService webService ;

    @RequestMapping("/")
    public String getHomepage(){

        return webService.getHomepage() ;
    }
}
