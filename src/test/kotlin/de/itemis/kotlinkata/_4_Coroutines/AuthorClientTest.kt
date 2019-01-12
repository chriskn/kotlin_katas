package de.itemis.kotlinkata._4_Coroutines

import de.itemis.kotlinkata.client.AuthorClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AuthorClientTest {

    private val client = AuthorClient()
    private val inputIds = (0..100_000).toList()
    private val expectedAuthorSize = inputIds.size
    private val twoSeconds = 1000L * 2

    /**
     * Task 1: Launching coroutines in kotlin
     * The current [AuthorClient.getAuthorsById] implementation
     * uses [Thread]s and is to slow for our purposes.
     *
     * Your first task is to make [AuthorClient.getAuthorsById] run in under 2 Second for the given ids.
     * Therefore use coroutines instead of threads.
     * @see [https://kotlinlang.org/docs/tutorials/coroutines/coroutines-basic-jvm.html]
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
     * Strangely enough, [AuthorClient.getAuthorsById] does not return
     * the expected amount of authors.
     *
     * Make sure [AuthorClient.getAuthorsById] returns all authors by awaiting the result.
     * Therefore await the termination of all jobs in a blocking block.
     */
    @Test
    fun test_getAuthorsById_returns_all_authors() {
        val authors = client.getAuthorsById(inputIds)
        assertThat(authors.size).isEqualTo(expectedAuthorSize)
    }




}