package com.lambdaschool.javabookstore.repository;

import com.lambdaschool.javabookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Authorrepository extends JpaRepository<Author, Long> {
}
