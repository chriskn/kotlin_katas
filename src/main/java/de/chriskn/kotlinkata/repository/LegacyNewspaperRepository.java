package de.chriskn.kotlinkata.repository;

import de.chriskn.kotlinkata.domain.Book;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LegacyNewspaperRepository implements ILegacyBookingRepository {

    private List<Book> books;
    private String name;

    @Override
    public void init(String name) {
        books = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        if (null == books || null == author) {
            return null;
        }
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllInOrder() {
        if (null == books) {
            return null;
        }
        List<Book> booksSorted = new ArrayList(books);
        booksSorted.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
        return booksSorted;
    }

    @Override
    public List<Book> findLimitBooks(int limit) {
        if (null == books) {
            return null;
        }
        return books.subList(0, limit);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
