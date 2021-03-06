package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Author

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