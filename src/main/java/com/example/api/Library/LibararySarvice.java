package com.example.api.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LibararySarvice {

  private final LibararyRepository libararyRepository;

     @Autowired
    public LibararySarvice(LibararyRepository libararyRepository) {
        this.libararyRepository = libararyRepository;
    }

    public List<Libarary> getBooks() {
        return  libararyRepository.findAll();

    }

    public void addBooks(Libarary book){
        Optional<Libarary> bookByPublisher = libararyRepository.findBookByPublisher(book.getPublisher());
        if (bookByPublisher.isPresent()) {
            throw new IllegalStateException("Publisher present");
        }
        libararyRepository.save(book);
    }

    public void deleteBook(Long bookid) {
        boolean exists = libararyRepository.existsById(bookid);
        if (!exists) {
            throw new IllegalStateException("Book not exists");
        }
        libararyRepository.deleteById(bookid);
    }
    @Transactional
    public void updateBookName(Long bookid, String bookname) {
        Libarary book = libararyRepository.findById(bookid)
                .orElseThrow(() -> new IllegalStateException(" Booknot exists"));
        if (bookname != null && bookname.length() > 0 && !Objects.equals(book.getBook(), bookname)) {
            book.setBook(bookname);
        }
    }
}
