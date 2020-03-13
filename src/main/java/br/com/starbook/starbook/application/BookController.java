package br.com.starbook.starbook.application;

import br.com.starbook.starbook.domain.Book;
import br.com.starbook.starbook.domain.BookRepository;
import br.com.starbook.starbook.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Calendar;
import java.util.Date;
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
    public void booking(@PathVariable int idBook, @PathVariable int idUser) {

        /*Calendar reservationDay =  Calendar.getInstance();
        Calendar calendar =  Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 20);
        Date finalDayForDevolution = calendar.getTime();*/

    }

    @PostMapping("/books")
    public Book registerBooks(@RequestBody Book book) {
        Book bookToSave = new Book(book.getTitle(), book.getCode(), book.getAuthor());
        return bookRepository.save(bookToSave);
    }

    @PutMapping("/books/{id}")
    public Book editBook(@PathVariable int id, @RequestBody Book book) {

        Optional<Book> editBookOptional = bookRepository.findById(id);
        if (editBookOptional.isPresent()){

            Book editBook = editBookOptional.get();
            editBook.setTitle(book.getTitle());
            editBook.setCode(book.getCode());
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
