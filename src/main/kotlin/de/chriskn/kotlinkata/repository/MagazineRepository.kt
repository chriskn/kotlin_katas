package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Book

class MagazineRepositoryI : IBookRepository {

    val repository = BookRepository()

    override fun findAll(): List<Book> {
        return repository.findAll()
    }

    override fun findByAuthor(author: String): List<Book> {
        return repository.findByAuthor(author)
    }

    override fun findAllInOrder(): List<Book> {
        return repository.findAllInOrder()
    }

    override fun findLimitBooks(limit: Int): List<Book> {
        return repository.findLimitBooks(limit)
    }

    override fun getName(): String {
        return "MagazineRepository"
    }
}