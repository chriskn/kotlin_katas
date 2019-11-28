package de.chriskn.kotlinkata._5_Collections

import de.chriskn.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CollectionsTest {

    private val bookRepository = BookRepository()

    /**
     * Task 1: Try your stream skills
     * Extend the method [BookRepository.findByAuthor]
     * by using streams.
     *
     * See https://kotlinlang.org/docs/reference/collection-filtering.html
     */
    @Test
    fun shouldFilterByAuthorName() {
        val author = "Miller"
        val books = bookRepository.findByAuthor(author)
        assertThat(books.map { it.author }).containsExactly(author)
    }

    /**
     * Task 2: Extended streams
     * Extend the method [BookRepository.findAllInOrder]
     * by using streams to return the books in alphabetic order by author
     *
     * See https://kotlinlang.org/docs/reference/collection-ordering.html
     */
    @Test
    fun shouldFindAllBooksInAlphabeticOrder() {
        val books = bookRepository.findAllInOrder()

        val titles = books.map { book -> book.title }
        val sortedTitles = listOf("A Small History Of Kotlin", "Start With Kotlin Today")
        assertThat(titles.slice(1..2)).isEqualTo(sortedTitles)
    }

}