package com.example.api.Library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/libarary")
public class LibararyController {

    private final LibararySarvice libararySarvice;

    @Autowired
    public LibararyController(LibararySarvice libararySarvice) {
        this.libararySarvice = libararySarvice;
    }

    @GetMapping
    public List<Libarary> getbook(){

        return libararySarvice.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Libarary book) {

        libararySarvice.addBooks(book);
    }

    @DeleteMapping(path = "{bookid}")
    public void deleteBook(@PathVariable("bookid") Long bookid) {

        libararySarvice.deleteBook(bookid);
    }

    @PutMapping(path = "{bookid}")
    public void updateBookName(
            @PathVariable("bookid") Long bookid,
            @RequestParam String bookname
    ) {
        libararySarvice.updateBookName(bookid, bookname);
    }
}
