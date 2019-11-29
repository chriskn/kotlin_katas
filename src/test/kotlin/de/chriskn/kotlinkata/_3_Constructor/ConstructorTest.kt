package de.chriskn.kotlinkata._3_Constructor

import de.chriskn.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * The BookRepository class currently uses a secondary constructor
 * to init the library.
 *
 * For more information see https://kotlinlang.org/docs/reference/classes.html
 */
class ConstructorTest {

    /**
     * Task 1:
     *
     * Your task is to extend the library list with the help of the init function.
     * Try to make this test pass without changing the constructor() method but rather add an init function.
     * The author of the new book should start with the letter "x" so it does not effect other tests.
     * Debug the test and check the order in which the books were added.
     */
    @Test
    fun shouldUseInitFunction() {
        val repository = BookRepository()

        assertThat(repository.findAll()).hasSize(3)
    }

    /**
     * Task 2:
     *
     * Now your task is to extend the library list with the help of a primary constructor.
     * Uncomment the test and let it pass without changing it.
     * Note: Adding a primary constructor with parameter also will lead to changes in the secondary constructor
     *
     */
//    @Test
//    fun shouldUsePrimaryConstructor() {
//        val books = mutableListOf(Book("Max", "Start With Kotlin Today"),
//                Book("Mustermann", "Start With Kotlin Today"))
//        val repository = BookRepository(books)
//
//        assertThat(repository.findAll().size).isEqualTo(3)
//    }
}