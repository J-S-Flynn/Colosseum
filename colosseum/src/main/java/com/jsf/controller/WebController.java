package com.jsf.controller;

import com.jsf.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    private WebService webService ;

    @RequestMapping("/")
    public String getHomepage(){

        return webService.getHomepage() ;
    }
}
