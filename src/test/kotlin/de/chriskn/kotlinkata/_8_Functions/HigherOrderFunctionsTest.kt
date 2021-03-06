package de.chriskn.kotlinkata._8_Functions

import de.chriskn.kotlinkata.Util
import de.chriskn.kotlinkata.domain.Book
import de.chriskn.kotlinkata.service.BookPriceCalculatorFactory
import de.chriskn.kotlinkata.service.BookType
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

/**
 * In Kotlin functions are first-class citizens which basically means you can use them in the same way as variables.
 * Therefore, functions except functions as parameters or return type. Such functions are called higher order functions.
 *
 * See https://kotlinlang.org/docs/reference/lambdas.html
 *
 */
class HigherOrderFunctionsTest {

    /**
     * Task 1:
     * The method [BookPriceCalculatorFactory.getBookPriceCalculator] is a higher order function returning a calculator function.
     * The returned calculator function should return the price of a book.
     * Which calculator is returned should depend on if the book is a [BookType.BESTSELLER] or a [BookType.NONSELLER].
     * The calculator for bestsellers should increase the price by 50% while the calculator for nonsellers should decrease the price by 20%.
     * Your task is to make the first two tests in this class pass by implementing the function body of the getBookPriceCalculator like described.
     *
     * Hint: Have also a look at the when expressions Kotlin provides: https://kotlinlang.org/docs/reference/control-flow.html
     *
     */
    @Test
    fun test_calculator_increases_price_for_bestsellers() {
        val calculator = BookPriceCalculatorFactory().getBookPriceCalculator(BookType.BESTSELLER)
        val newPrice = calculator.invoke(Book("", "", BigDecimal(10)))
        assertThat(newPrice).isEqualTo(BigDecimal.valueOf(15.0))
    }

    /**
     * See Task 1
     */
    @Test
    fun test_calculator_decreases_price_for_nonsellers() {
        val calculator = BookPriceCalculatorFactory().getBookPriceCalculator(BookType.NONSELLER)
        val newPrice = calculator.invoke(Book("", "", BigDecimal(10)))
        assertThat(newPrice).isEqualTo(BigDecimal.valueOf(8.0))
    }

    /**
     * Task 2:
     * The method [Util.measureTimeMillis] is a higher order function accepting two functions as parameters.
     * The first function is a logging function used to log the time needed to execute the second function. The second one is the actual function.
     * The actual function is already called, but the logging function not.
     *
     * Your task is to make the test test_measureTimeMillis_calls_logging_function pass by calling the logging function inside measureTimeMillis.
     * The test test_measureTimeMillis_returns_function_value already succeeds. Its only for regression.
     *
     * Hint: Use System.currentTimeMillis() to measure the time needed.
     *
     */
    @Test
    fun test_measureTimeMillis_returns_function_value() {
        val function = { 10 + 5 }
        val result = Util().measureTimeMillis({}, function)
        assertThat(result).isEqualTo(15)
    }

    /**
     * See Task 2
     */
    @Test
    fun test_measureTimeMillis_calls_logging_function() {
        val function = { 10 + 5 }
        val loggingFunctionMock = mockk<(Long) -> Unit>(relaxed = true)

        Util().measureTimeMillis(loggingFunctionMock, function)

        verify { loggingFunctionMock.invoke(any()) }
    }

}