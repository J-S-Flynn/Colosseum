package com.jsf.services;

import com.jsf.domain.userDomain.Comment;
import com.jsf.repositories.CommentRepo;
import com.jsf.repositories.PostRepo;
import com.jsf.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private CommentRepo commentRepo ;

    @Autowired
    private PostRepo postRepo ;

    @Autowired
    private UserRepo userRepo ;

}
