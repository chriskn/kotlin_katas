package de.itemis.kotlinkata._2_ValueClasses

import de.itemis.kotlinkata.repository.AuthorRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValueClassTest {

    val repository = AuthorRepository()

    /**
     * Task 1: Data Value Classes
     * [https://kotlinlang.org/docs/reference/data-classes.html]
     * Kotlin has its own syntax for data classes, which are purely for storing data in your domain model
     * In this task you need to replace the [de.itemis.kotlinkata.domain.Author] class by an kotlin data class
     * Hint: You can take a look at the class [de.itemis.kotlinkata.domain.Book]
     */
    @Test
    fun shouldFindAllAuthors(){
        var authors = repository.findAll()
        assertThat(authors.map { a -> a.lastName }).contains("Miller")
        assertTrue(false)
    }

}