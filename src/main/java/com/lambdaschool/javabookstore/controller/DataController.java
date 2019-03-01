package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Book;
import com.lambdaschool.javabookstore.repository.Authorrepository;
import com.lambdaschool.javabookstore.repository.Bookrepository;
import com.lambdaschool.javabookstore.repository.Sectionrepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@Api(value = "Todo Application", description = "Lambda School JX: Sprint Challenge 3")
@RestController
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    @Autowired
    Bookrepository bookrepos;

    @Autowired
    Authorrepository authorrepos;

    @Autowired
    Sectionrepository sectionrepos;

    @ApiOperation(value = "Edits a book based on its ID, requires a request body matching the schema", response = Book.class)
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

    @ApiOperation(value = "Connect a book from the request body to the authorid in our joined wrote table. Request body must be a book object with a bookid", response = Book.class)
    @PostMapping("/books/authors/authorid}")
    public String assignBooktoAuthor(@RequestBody Book book, @PathVariable long authorid){
        return bookrepos.addBooktoAuthor(book.getBookid(),authorid);
    }

    @ApiOperation(value = "Deletes a book based on the ID provided", response = Book.class)
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
