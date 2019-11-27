package de.chriskn.kotlinkata.repository;

import de.chriskn.kotlinkata.domain.Book;

import java.util.List;

public interface ILegacyBookingRepository {
    void init(String name);
    void addBook(Book book);
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    List<Book> findAllInOrder();
    List<Book> findLimitBooks(int limit);
    String getName();
}
