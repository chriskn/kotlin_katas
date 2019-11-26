package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Book

interface IBookRepository {
    fun findAll(): List<Book>
    fun findByAuthor(author: String): List<Book>
    fun findAllInOrder(): List<Book>
    fun findLimitBooks(limit: Int): List<Book>
    fun getName(): String
}