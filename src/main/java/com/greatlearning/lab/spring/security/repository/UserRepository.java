package com.greatlearning.lab.spring.security.repository;

import com.greatlearning.lab.spring.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
}