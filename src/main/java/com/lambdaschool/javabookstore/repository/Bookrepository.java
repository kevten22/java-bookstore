package com.lambdaschool.javabookstore.repository;

import com.lambdaschool.javabookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book, Long> {
}
