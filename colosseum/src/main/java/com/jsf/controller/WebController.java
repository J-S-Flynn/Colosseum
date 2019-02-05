package com.jsf.controller;

import com.jsf.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    private final WebService webService ;

    @Autowired
    public WebController(WebService ws){
        webService = ws;
    }

    @RequestMapping("colosseum/")
    public String getHomepage(){

        return webService.getHomepage() ;
    }

    @RequestMapping("colosseum/userpage/{userName}")
    public String getUserPage(@PathVariable String userName, Model model){

        model.addAttribute("user", webService.getUser(userName)) ;

        return "userPage" ;
    }
}
