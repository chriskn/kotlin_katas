package de.chriskn.kotlinkata._4_DelegationPattern

import de.chriskn.kotlinkata.repository.BookRepository
import de.chriskn.kotlinkata.repository.MagazineRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DelegationPatternTest {

    /**
     * Kotlin eases the implementation of the Delegation pattern.
     * Take a look at [MagazineRepository].
     * It uses a BookRepository and delegates all function except for getName() to
     * the repository. Delegation allows a much cleaner syntax. Try to keep this test
     * passing while removing all functions from the MagazinRepository except for the
     * getName() function and delegate to the .
     * For more information see https://kotlinlang.org/docs/reference/delegation.html
     *
     */
    @Test
    fun shouldReturnMagazineName() {
        val repository = MagazineRepository(BookRepository())
        assertThat(repository.getName()).isEqualTo("MagazineRepository")
    }
}