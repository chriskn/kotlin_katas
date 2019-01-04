package de.itemis.kotlinkata.repository

import de.itemis.kotlinkata.domain.Book

class BookRepository {

    val library: MutableList<Book> = ArrayList()

    init {
        library.add(Book("Smith", "Start With Kotlin Today"))
        library.add(Book("Miller", "A Small History Of Kotlin"))
    }

    fun findAll(): List<Book> {
        return library
    }

    fun findByAuthor(author: String): List<Book> {
        return findAll()
    }

    fun findAllInOrder(): List<Book> {
        return findAll()
    }


}