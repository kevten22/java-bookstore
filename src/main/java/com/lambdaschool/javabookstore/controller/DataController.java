package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Book;
import com.lambdaschool.javabookstore.repository.Authorrepository;
import com.lambdaschool.javabookstore.repository.Bookrepository;
import com.lambdaschool.javabookstore.repository.Sectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    @Autowired
    Bookrepository bookrepos;

    @Autowired
    Authorrepository authorrepos;

    @Autowired
    Sectionrepository sectionrepos;

    @PutMapping("/books/{id}")
    public Book changeBookById(@RequestBody Book newbook, @PathVariable long bookid) throws URISyntaxException{
        Optional<Book> updateBook = bookrepos.findById(bookid);
        if(updateBook.isPresent()){
            if(newbook.getAuthors() == null){
                newbook.setAuthors(updateBook.get().getAuthors());
            }

            if (newbook.getSection() == null){
                newbook.setSection(updateBook.get().getSection());
            }
            newbook.setBookid(bookid);
            bookrepos.save(newbook);
            return newbook;
        }
        else
            return null;
    }

    //@PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid
    @PostMapping("/books/authors/authorid}")
    public String assignBooktoAuthor(@RequestBody Book book, @PathVariable long authorid){
        return bookrepos.addBooktoAuthor(book.getBookid(),authorid);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable long bookid){
        var foundBook = bookrepos.findById(bookid);
        if(foundBook.isPresent()){
            bookrepos.deleteBookFromWrote(bookid);
            bookrepos.deleteById(bookid);

            return foundBook.get().getBooktitle() + "deleted.";
        }

        else
            return null;
    }
}
