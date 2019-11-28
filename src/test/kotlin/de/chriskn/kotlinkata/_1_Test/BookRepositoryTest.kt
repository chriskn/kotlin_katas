package de.chriskn.kotlinkata._1_Test

import de.chriskn.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class BookRepositoryTest {

    /**
     * Write your first kotlin test
     * The method [BookRepository.findAll] does not have a test yet.
     * Create a test for the method in this file.
     *
     * Why you dont have to declare the test method as public?
     *
     * Hint: AssertJ is available. Use it with assertThat...
     */
    @Test
    fun test_findAll_finds_all(){
        val repo = BookRepository()
        assertThat(repo.findAll()).hasSize(3)
    }

}