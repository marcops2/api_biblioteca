package br.com.starbook.starbook.application;

import br.com.starbook.starbook.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/{id}")
    public Optional<Book> getIndividualBook(@PathVariable Integer id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book registerBooks(@RequestBody Book book) {
        Book bookToSave = new Book(book.getTitle(), book.getBookCode(), book.getAuthor());
        return bookRepository.save(bookToSave);
    }

    @PutMapping("/books/{id}")
    public Book editBook(@PathVariable int id, @RequestBody Book book) {

        Optional<Book> editBookOptional = bookRepository.findById(id);
        if (editBookOptional.isPresent()){

            Book editBook = editBookOptional.get();
            editBook.setTitle(book.getTitle());
            editBook.setBookCode(book.getBookCode());
            editBook.setAuthor(book.getAuthor());
            return bookRepository.save(editBook);

        } throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "The book with this ID was not found"
        );

    }


    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {

        bookRepository.deleteById(id);

    }

}
