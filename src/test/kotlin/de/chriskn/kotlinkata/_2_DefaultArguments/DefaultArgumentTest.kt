package de.chriskn.kotlinkata._2_DefaultArguments

import de.chriskn.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultArgumentTest {

    private val bookRepository = BookRepository()

    /**
     * Kotlin supports default arguments.
     * Extend the function [BookRepository.findLimitBooks]
     * with a default argument in a way that the limit parameter of 1 is not
     * required anymore for this test to pass.
     */
//    @Test
//    fun shouldReturnLimitedNumberOfBooks() {
//        var books = bookRepository.findLimitBooks()
//        assertThat(books).hasSize(1)
//    }

}