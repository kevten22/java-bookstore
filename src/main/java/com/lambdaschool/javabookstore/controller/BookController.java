package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Book;
import com.lambdaschool.javabookstore.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @Autowired
    Bookrepository bookrepos;

    @GetMapping("/")
    public List<Book> listAllBooks(){
        return bookrepos.findAll();
    }

}
