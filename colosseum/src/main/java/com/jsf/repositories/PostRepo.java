package com.jsf.repositories;

import com.jsf.domain.userDomain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
