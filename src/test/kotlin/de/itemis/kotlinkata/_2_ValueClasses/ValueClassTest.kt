package de.itemis.kotlinkata._2_ValueClasses

import de.itemis.kotlinkata.domain.Author
import de.itemis.kotlinkata.repository.AuthorRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValueClassTest {

    val repository = AuthorRepository()
    var author = Author("Peter", "Miller")

    /**
     * Task 1: Data Class
     * [https://kotlinlang.org/docs/reference/data-classes.html]
     * Kotlin has its own syntax for data classes, which are purely for storing data in your domain model
     * In this task you need to replace the [de.itemis.kotlinkata.domain.Author] class by an kotlin data class
     * Hint: You can take a look at the class [de.itemis.kotlinkata.domain.Book]
     */
    @Test
    fun shouldFindAllAuthors() {
        var authors = repository.findAll()
        assertThat(authors.map { it.getLastName() }).contains("Miller")
    }


    /**
     * Task 2: Data Class Functions
     * A kotlin data class will give you the following functions for free:
     * hashCode() / equals()
     * toString()
     * componentN()
     * copy()
     * Fix this test by adding the correct string for the [authorAsString] variable
     */
    @Test
    fun shouldGiveYouAToStringFunForFree() {
        val authorAsString = "TODO"
        assertThat(author.toString()).isEqualTo(authorAsString)
    }

    /**
     * Task 3: Another generated method for a data class is copy().
     * Is also supports to copy all attributes but at the same time alter one or multiple attributes during copy.
     * Extend the following test to make it pass without chaning any production code.
     */
    @Test
    fun shouldGiveYouACopyFunction() {
        val anotherAuthor = author.copy()

        // Do not change any assert
        assertThat(anotherAuthor).isNotEqualTo(author)
        assertThat(anotherAuthor.lastName).isEqualTo("Smith")
    }

}