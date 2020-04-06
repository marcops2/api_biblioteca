package br.com.starbook.starbook.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idBook;

    @NotEmpty
    @Column(nullable = false)
    private String title;

    @NotEmpty
    @Column(nullable = false)
    private String bookCode;

    @NotEmpty
    @Column(nullable = false)
    private String author;

    public Book(String title, String bookCode, String author) {
        this.title = title;
        this.bookCode = bookCode;
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

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
