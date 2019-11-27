package de.chriskn.kotlinkata._7_Coroutines

import de.chriskn.kotlinkata.client.AuthorClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * For help regarding coroutines @see [https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html]
 * Let all tests in this class pass.
 */
class AuthorClientTest {

    private val client = AuthorClient()
    private val inputIds = (1..100_000).toList()
    private val expectedAuthorSize = inputIds.size
    private val twoSeconds = 1000L * 2
    private val fiveSeconds = 1000L * 5

    /**
     * Task 1: Launching coroutines in kotlin
     * The current [AuthorClient.getAuthorsById] implementation
     * uses [Thread]s and is to slow for our purposes.
     *
     * Your first task is to make [AuthorClient.getAuthorsById] run in under 2 Second for the given ids.
     * Therefore, use coroutines instead of threads.
     */
    @Test
    fun test_getAuthorsById_takes_less_then_2s_for_100k_ids() {
        val timeNeeded = measureTimeMillis {
            client.getAuthorsById(inputIds)
        }
        assertThat(timeNeeded).isLessThan(twoSeconds)
    }

    /**
     * Task 2: Await the result of coroutines
     * Strangely enough, [AuthorClient.getAuthorsById] does not always return
     * the expected amount of authors.
     *
     * Make sure [AuthorClient.getAuthorsById] returns all authors by awaiting the result.
     * Therefore, join all jobs in a blocking block.
     */
    @Test
    fun test_getAuthorsById_returns_all_authors() {
        val authors = client.getAuthorsById(inputIds)
        assertThat(authors.size).isEqualTo(expectedAuthorSize)
    }


    /**
     * Task 3: Run coroutines asynchronous
     * The method [AuthorClient.registerForEvents] is also too slow.
     * The registration is currently called synchronous which is not needed.
     *
     * You task is to change [AuthorClient.registerForEvents] to run asynchronous
     * and therefore make sure it runs under 5 seconds.
     */
    @Test
    fun test_registerForEvents_takes_less_then_5_seconds_for_5_authors() {
        val timeNeeded = measureTimeMillis {
            client.registerForEvents((1..5).toList())
        }
        assertThat(timeNeeded).isLessThan(fiveSeconds)
    }

    /**
     * Task 4: Get results from asynchronous coroutines
     * Currently we ignore the resulting status codes returned by [AuthorClient.registerForEvents].
     * In order to know if the registration was successful, we want to
     * consider the returned status codes.
     *
     * Your task is to change [AuthorClient.registerForEvents] to return the
     * status code from the asynchronous call for each author id.
     * Uncomment this test and make it pass.
     */
//    @Test
//    fun test_registerForEvents_return_status_codes() {
//        val statusCodes = client.registerForEvents((1..5).toList())
//        assertThat(statusCodes.size).isEqualTo(5)
//    }

}