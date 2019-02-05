package com.jsf.services;

import com.jsf.repositories.CommentRepo;
import com.jsf.repositories.PostRepo;
import com.jsf.repositories.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    private final CommentRepo commentRepo ;

    private final PostRepo postRepo ;

    private final UserRepo userRepo ;

    @Autowired
    public UserService(CommentRepo cm, PostRepo pr, UserRepo ur){

        commentRepo = cm ;
        postRepo = pr ;
        userRepo = ur ;
    }
}
