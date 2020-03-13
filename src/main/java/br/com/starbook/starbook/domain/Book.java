package br.com.starbook.starbook.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idBook;

    @ManyToMany
    Set<User> books;

    public Set<User> getBooks() {
        return books;
    }

    public void setBooks(Set<User> books) {
        this.books = books;
    }

    @NotEmpty
    @Column(nullable = false)
    private String title;

    @NotEmpty
    @Column(nullable = false)
    private String code;

    @NotEmpty
    @Column(nullable = false)
    private String author;

    public Book(String title, String code, String author) {
        this.title = title;
        this.code = code;
        this.author = author;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
