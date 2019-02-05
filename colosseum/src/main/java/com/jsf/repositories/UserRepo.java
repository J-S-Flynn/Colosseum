package com.jsf.repositories;

import com.jsf.domain.userDomain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional <User> findByUserName(String userName) ;
}
