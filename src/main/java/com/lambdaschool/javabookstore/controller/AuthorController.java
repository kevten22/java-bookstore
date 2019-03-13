package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Author;
import com.lambdaschool.javabookstore.repository.Authorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
    @Autowired
    Authorrepository authorrepos;

    @GetMapping("/")
    public List<Author> listAllAuthors(){
        return authorrepos.findAll();
    }
}
