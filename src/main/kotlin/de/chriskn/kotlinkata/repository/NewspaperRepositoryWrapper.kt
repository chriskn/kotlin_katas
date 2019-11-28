package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Book
import java.util.*

class NewspaperRepositoryWrapper (legacyRepo : ILegacyBookingRepository) : ILegacyBookingRepository by legacyRepo {

    override fun findByAuthor(author: String?): List<Book> {
       return findAll()?.filter { book -> book?.author == author  } ?: Collections.emptyList()
    }

}