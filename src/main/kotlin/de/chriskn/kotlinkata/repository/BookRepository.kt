package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Book


class BookRepository(val library : MutableList<Book>): IBookRepository {

    init {
        library.add(Book("Klaus", "Start With Kotlin Today"))
    }

    constructor() : this(mutableListOf()) {
        library.add(Book("Smith", "Start With Kotlin Today"))
        library.add(Book("Miller", "A Small History Of Kotlin"))
    }

    override fun findAll(): List<Book> {
        return library
    }

    override fun findByAuthor(author: String): List<Book> {
        return findAll().filter { it.author == author }
    }

    override fun findAllInOrder(): List<Book> {
        return findAll().sortedBy { it.author }
    }

    override fun findLimitBooks(limit: Int): List<Book> {
        return findAll().subList(0, limit)
    }

    override fun getName(): String {
        return "BookRepository"
    }

}