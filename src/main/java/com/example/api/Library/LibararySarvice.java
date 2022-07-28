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
            throw new IllegalStateException("Publisher present for another book");
        }
        libararyRepository.save(book);
    }

    public void deleteBook(Long bookid) {
        boolean exists = libararyRepository.existsById(bookid);
        if (!exists) {
            throw new IllegalStateException(bookid + "Book not exists");
        }
        libararyRepository.deleteById(bookid);
    }
    @Transactional
    public void updateBookName(Long bookid, String bookName) {
        Libarary book = libararyRepository.findById(bookid)
                .orElseThrow(() -> new IllegalStateException( bookid + " Booknot exists"));
        if (bookName != null && bookName.length() > 0 && !Objects.equals(book.getBook(), bookName)) {
            book.setBook(bookName);
        }
    }
}
