package br.com.starbook.starbook.application;

import br.com.starbook.starbook.domain.Author;
import br.com.starbook.starbook.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/list_books")
    public Book getBooks() {
        Author author = new Author();
        return new Book("Java", "a", author);
    }

    @PostMapping("/register_books")
    public Book registerBooks(@RequestBody Book book) {

        return book;

    }



}
