package de.itemis.kotlinkata.repository

import de.itemis.kotlinkata.domain.Book

interface BookRepositoryInterface {
    fun findAll(): List<Book>
    fun findByAuthor(author: String): List<Book>
    fun findAllInOrder(): List<Book>
    fun findLimitBooks(limit: Int): List<Book>
    fun getName(): String
}