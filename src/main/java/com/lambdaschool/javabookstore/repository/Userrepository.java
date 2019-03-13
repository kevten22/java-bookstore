package com.lambdaschool.javabookstore.repository;

import com.lambdaschool.javabookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
