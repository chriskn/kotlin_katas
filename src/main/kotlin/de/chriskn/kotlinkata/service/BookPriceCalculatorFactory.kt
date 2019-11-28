package de.chriskn.kotlinkata.service

import de.chriskn.kotlinkata.domain.Book
import java.lang.IllegalArgumentException
import java.math.BigDecimal

enum class BookType { BESTSELLER, NONSELLER }

class BookPriceCalculatorFactory{

    fun getBookPriceCalculator(type: BookType): (Book) -> BigDecimal {
        when (type) {
            BookType.BESTSELLER -> return {book -> book.price.multiply(BigDecimal.valueOf(1.5))}
            BookType.NONSELLER -> return {book -> book.price.multiply(BigDecimal.valueOf(0.8))}
            else -> throw IllegalArgumentException("Unknown Booktype ${type.name}")
        }
    }
}
