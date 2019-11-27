package de.chriskn.kotlinkata._4_NullSafety

import de.chriskn.kotlinkata.domain.Book
import de.chriskn.kotlinkata.repository.LegacyNewspaperRepository
import de.chriskn.kotlinkata.repository.NewspaperRepositoryWrapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * NullSafety is a great feature of Kotlin and avoid the so called "million dollar mistake".
 * But specially when interacting with java code you have to take care of nullable variables.
 *
 * In this test we test the java method [LegacyNewspaperRepository.findByAuthor].
 * The LegacyNewspaperRepository is poorly implemented and returns null as result of findByAuthor in multiple cases.
 * That's why we wrapped it in the class  [NewspaperRepositoryWrapper].
 *
 * For null safety in Kotlin see https://kotlinlang.org/docs/reference/null-safety.html
 */
class NullSafetyTest {

    private val sut = NewspaperRepositoryWrapper(LegacyNewspaperRepository())

    /**
     * Task 1:
     *
     * Override the method [NewspaperRepositoryWrapper.findByAuthor] so it does not return null even
     * when the repository (and therefore the list of authors) is not initialized.
     */
    @Test
    fun test_findAllByAuthor_does_return_empytList_if_legazyRepo_not_initialized() {
        assertThat(sut.findByAuthor("")).hasSize(0)
    }

    /**
     * Task 2:
     *
     * Because of reasons we need to make sure that we can pass null as argument into findByAuthor.
     * Make sure that null can be passed and still an empty list is returned.
     *
     * P.S. Never use null as argument in Kotlin production code and more important never write apis allowing null
     */
    @Test
    fun test_findAllByAuthor_does_return_empytList_if_author_is_null() {
        sut.init("")
        sut.addBook(Book("klaus", "Tolle Geschichte"))
        sut.addBook(Book("Martin", "Noch eine tolle Geschichte"))
        assertThat(sut.findByAuthor(null)).hasSize(0)
    }


    /**
     * Task 3:
     *
     * The LegacyNewspaperRepository also accepts null as Book.
     * Make sure that no errors occur in this case.
     */
    @Test
    fun test_findAllByAuthor_does_return_found_author_if_library_contains_null() {
        sut.init("")
        sut.addBook(Book("klaus", "Tolle Geschichte"))
        sut.addBook(null)
        assertThat(sut.findByAuthor("klaus")).hasSize(1)
    }

}