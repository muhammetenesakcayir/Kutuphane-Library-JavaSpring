package com.kutuphane.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String bookName;
    @NotEmpty
    private String bookSubtitle;
    @NotEmpty
    private String bookSerialName;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @NotEmpty
    @Column(unique = true)
    private String isbnNo;

    private String explanation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSubtitle() {
        return bookSubtitle;
    }

    public void setBookSubtitle(String bookSubtitle) {
        this.bookSubtitle = bookSubtitle;
    }

    public String getBookSerialName() {
        return bookSerialName;
    }

    public void setBookSerialName(String bookSerialName) {
        this.bookSerialName = bookSerialName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(String isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
