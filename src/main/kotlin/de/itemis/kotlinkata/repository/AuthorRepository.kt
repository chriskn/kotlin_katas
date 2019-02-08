package de.itemis.kotlinkata.repository

import de.itemis.kotlinkata.Author

class AuthorRepository {

    val authors: List<Author> = listOf(
        Author(
            "Peter",
            "Miller"
        ), Author("Willy", "Smith")
    )

    fun findAll(): List<Author> {
        return authors
    }

}