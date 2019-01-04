package de.itemis.kotlinkata.`2_Collections`

import de.itemis.kotlinkata.domain.Book
import de.itemis.kotlinkata.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StreamTest {

    val bookRepository = BookRepository()

    /**
     * Task 2.1: Try your stream skills
     * Extend the method [de.itemis.kotlinkata.repository.BookRepository.findByAuthor]
     * by using streams.
     */
    @Test
    fun shouldFilterByAuthorName() {
        val author = "Miller"
        val books = bookRepository.findByAuthor(author)
        assertThat(books).containsExactly(Book(author,""))
    }

    /**
     * Task 2.2: Extended streams
     * Extend the method [de.itemis.kotlinkata.repository.BookRepository.findAllInOrder]
     * by using streams to return the books in alphabetic order
     */
    @Test
    fun shouldFindAllBooksInAlphabeticOrder(){
        val books = bookRepository.findAllInOrder()

        val titles = books.map { book -> book.title }
        val sortedTitles = arrayOf("A Small History Of Kotlin", "Start With Kotlin Today")
        assertThat(titles).isEqualTo(sortedTitles)
    }

}