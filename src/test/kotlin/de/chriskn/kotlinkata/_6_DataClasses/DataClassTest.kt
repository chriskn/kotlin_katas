package de.chriskn.kotlinkata._6_DataClasses

import de.chriskn.kotlinkata.domain.Author
import de.chriskn.kotlinkata.domain.Book
import de.chriskn.kotlinkata.repository.AuthorRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * See https://kotlinlang.org/docs/reference/data-classes.html
 */
class DataClassTest {

    val repository = AuthorRepository()
    var author = Author("Peter", "Miller")

    /**
     * Task 1: Data Class
     * Kotlin has its own syntax for data classes, which are purely for storing data in your domain model
     * In this task you need to replace the [Author] java class by an kotlin data class
     * Hint: You can take a look at the class [Book]
     * Make sure the test uses the new class and still works.
     */
    @Test
    fun shouldFindAllAuthors() {
        val authors = repository.findAll()
        assertThat(authors.map { it.lastName }).contains("Miller")
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
        print(author.toString())
        assertTrue(author.toString() == authorAsString)
    }

    /**
     * Task 3: Another generated method for a data class is copy().
     * Is also supports to copy all attributes but at the same time alter one or multiple attributes during copy.
     * Extend the following test to make it pass without changing any production code.
     */
    @Test
    fun shouldGiveYouACopyFunction() {
        val anotherAuthor = author.copy()

        // Do not change any assert
        assertThat(anotherAuthor).isNotEqualTo(author)
        assertThat(anotherAuthor.lastName).isEqualTo("Smith")
    }

}