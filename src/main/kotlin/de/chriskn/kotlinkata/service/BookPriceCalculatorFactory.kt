package de.chriskn.kotlinkata.service

import de.chriskn.kotlinkata.domain.Book
import java.math.BigDecimal

enum class BookType { BESTSELLER, NONSELLER }

class BookPriceCalculatorFactory{

    fun getBookPriceCalculator(type: BookType): (Book) -> BigDecimal {
        return { book -> book.price }
    }



}
