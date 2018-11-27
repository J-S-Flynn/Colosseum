package com.jsf.repositories;

import com.jsf.domain.userDomain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
