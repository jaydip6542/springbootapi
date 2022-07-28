package com.example.api.Library;

import javax.persistence.*;

@Entity
@Table
public class Libarary {

    @Id
    @SequenceGenerator(
            name = "libarary_sequence",
            sequenceName = "libarary_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="libarary_sequence"
    )
    private Long id;
    private String book;
    private String author;
    private String publisher;

    public Libarary() {
    }

    public Libarary(Long id,
                    String book,
                    String author,
                    String publisher) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.publisher = publisher;
    }

    public Libarary(String book,
                    String author,
                    String publisher) {
        this.book = book;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getBook() {
        return book;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Libarary{" +
                "id=" + id +
                ", book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
