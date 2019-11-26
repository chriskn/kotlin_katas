package de.chriskn.kotlinkata._4_Collections

import de.chriskn.kotlinkata.domain.Book
import de.chriskn.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StreamTest {

    val bookRepository = BookRepository()

    /**
     * Task 1: Try your stream skills
     * Extend the method [de.itemis.kotlinkata.repository.BookRepository.findByAuthor]
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
     * Extend the method [de.itemis.kotlinkata.repository.BookRepository.findAllInOrder]
     * by using streams to return the books in alphabetic order
     *
     * See https://kotlinlang.org/docs/reference/collection-ordering.html
     */
    @Test
    fun shouldFindAllBooksInAlphabeticOrder() {
        initBooks()

        val books = bookRepository.findAllInOrder()

        val titles = books.map { book -> book.title }
        val sortedTitles = listOf("A Small History Of Kotlin", "Start With Kotlin Today")
        assertThat(titles).isEqualTo(sortedTitles)
    }

    private fun initBooks() {
        val library: MutableList<Book> = ArrayList()
        library.add(Book("Smith", "Start With Kotlin Today"))
        library.add(Book("Miller", "A Small History Of Kotlin"))
        bookRepository.library = library
    }

}