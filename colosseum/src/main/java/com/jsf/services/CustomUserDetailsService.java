package com.jsf.services;

import com.jsf.config.UserDetailsConfiguration;
import com.jsf.domain.userDomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserService userService ;

    @Autowired
    public CustomUserDetailsService(UserService us){
        userService = us ;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

         Optional<User> user = userService.getUserRepo().findByUserName(userName) ;

         user.orElseThrow(() -> new UsernameNotFoundException("User Name not found!")) ;

         return user.map(UserDetailsConfiguration::new).get();

    }
}
