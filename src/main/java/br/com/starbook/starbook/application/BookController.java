package br.com.starbook.starbook.application;

import br.com.starbook.starbook.domain.Book;
import br.com.starbook.starbook.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/books/{id}")
    public Optional<Book> getBooks(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return userRepository.findAll();
    }

    @PostMapping("/books")
    public Book registerBooks(@RequestBody Book book) {
        Book bookToSave = new Book(book.getTitle(), book.getCode(), book.getAuthor());

        return userRepository.save(bookToSave);
    }

    @PutMapping("/books/{id}")
    public Book editBook(@PathVariable int id, @RequestBody Book book) {
        //Tentar outras opções LEMBRETE
        Optional<Book> editBookOptional = userRepository.findById(id);
        if (editBookOptional.isPresent()){

            Book editBook = editBookOptional.get();
            editBook.setTitle(book.getTitle());
            editBook.setCode(book.getCode());
            editBook.setAuthor(book.getAuthor());
            return userRepository.save(editBook);

        } throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Não foi encontrado o livro com esse ID"
        );

    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {

        userRepository.deleteById(id);

    }

}
