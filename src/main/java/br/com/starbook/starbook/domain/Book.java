package br.com.starbook.starbook.domain;

public class Book {

    private String title;
    private String code;
    private Author author;

    public Book(String title, String code, Author author) {
        this.title = title;
        this.code = code;
        this.author = author;
    }

    public String getTitle() {
        return title;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
