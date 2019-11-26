package de.chriskn.kotlinkata._1_Test

import de.chriskn.kotlinkata.repository.`IBookRepository.kt`
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrimaryConstructorTest {


    /**
     * The BookRepository class currently uses a second constructor
     * to init the library. Your task is to extend the library list with the
     * help of the primary constructor and init function.
     * Try to make this test pass without changing the constructor() method,
     * but rather add an init function for the primary constructor.
     * For more information see https://kotlinlang.org/docs/reference/classes.html
     */
    @Test
    fun shouldUsePrimaryConstructor() {
        val repository = `IBookRepository.kt`()

        assertThat(repository.findAll().size).isEqualTo(3)
    }
}