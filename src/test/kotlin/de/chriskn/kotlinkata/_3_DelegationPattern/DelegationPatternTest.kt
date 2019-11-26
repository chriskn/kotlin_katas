package de.chriskn.kotlinkata._3_DelegationPattern

import de.chriskn.kotlinkata.repository.MagazineRepositoryI
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DelegationPatternTest {

    /**
     * Kotlin eases the implementation of the Delegation pattern.
     * Take a look at [de.itemis.kotlinkata.repository.MagazinRepository].
     * It uses a BookRepository and delegates all function except for getName() to
     * the repository. Kotlin supports a much cleaner syntax. Try to keep this test
     * passing while removing all functions from the MagazinRepository except for the
     * getName() function.
     * For more information see https://kotlinlang.org/docs/reference/delegation.html
     */
    @Test
    fun shouldReturnMagazineName() {
        val repository = MagazineRepositoryI()
        assertThat(repository.getName()).isEqualTo("MagazineRepository")
    }
}