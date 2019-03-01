package com.lambdaschool.javabookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;
    private String lname;
    private String fname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "wrote",
        joinColumns = {@JoinColumn(name = "authorid")},
        inverseJoinColumns = {@JoinColumn(name ="bookid")})
    @JsonIgnoreProperties("author")
    private Set<Book> books;

    public Author() {
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lname;
    }

    public void setLastname(String lastname) {
        this.lname = lastname;
    }

    public String getFirstname() {
        return fname;
    }

    public void setFirstname(String firstname) {
        this.fname = firstname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
