package de.itemis.kotlinkata._4_DelegationPattern

import de.itemis.kotlinkata.repository.MagazinRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DelegationPatternTest {

    /**
     * Kotlin eases the implementation of the Delegation pattern.
     * Take a look at [de.itemis.kotlinkata.repository.MagazinRepository].
     * It uses a BookRepository and delegates all function except for getName() to
     * the repository. Kotlin supports a much cleaner syntax. Try to keep this test
     * passed while removing all functions from the MagazinRepository except for the
     * getName() function.
     * For more information see https://kotlinlang.org/docs/reference/delegation.html
     */
    @Test
    fun shouldReturnMagazinName() {
        val repository = MagazinRepository()
        assertThat(repository.getName()).isEqualTo("MagazinRepository")

    }
}