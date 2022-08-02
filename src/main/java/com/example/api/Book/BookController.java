package com.example.api.Book;


import com.example.api.Book.Author.Author;
import com.example.api.Book.Author.AuthorRepository;
import com.example.api.Book.Publisher.Publisher;
import com.example.api.Book.Publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BookController(BookRepository bookRepository,
                             AuthorRepository authorRepository,
                             PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }



    @GetMapping(path = "booksList")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "authorsList")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping(path = "publishersList")
    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @PostMapping(path = "addBook")
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PostMapping(path = "delete/{bookid}")
    public void deleteBook(@PathVariable("bookid") Long bookid) {
        boolean exists = bookRepository.existsById(bookid);
        if (!exists) {
            throw new IllegalStateException("Book does not exists");
        }
        bookRepository.deleteById(bookid);
    }





}

