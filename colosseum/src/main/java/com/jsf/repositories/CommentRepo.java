package com.jsf.repositories;

import com.jsf.domain.userDomain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
