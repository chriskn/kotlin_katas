package de.itemis.kotlinkata.repository

import de.itemis.kotlinkata.domain.Book

class MagazinRepository : BookRepositoryInterface {

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
        return "MagazinRepository"
    }
}