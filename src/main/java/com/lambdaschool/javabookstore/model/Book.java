package com.lambdaschool.javabookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;
    private String booktitle;
    private String ISBN;
    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private Set<Author> authors;

    public Book() {

    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
