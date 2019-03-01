package com.lambdaschool.javabookstore.repository;

import com.lambdaschool.javabookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface Bookrepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM wrote WHERE bookid = :bookid", nativeQuery = true)
    void deleteBookFromWrote(long bookid);

    @Modifying
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid", nativeQuery = true)
    String addBooktoAuthor(long bookid, long authorid);
}
