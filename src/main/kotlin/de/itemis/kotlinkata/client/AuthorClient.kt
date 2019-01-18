package de.itemis.kotlinkata.client

import de.itemis.kotlinkata.domain.Author
import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingDeque
import kotlin.collections.sumBy
import kotlin.concurrent.thread

class AuthorClient {

    fun getAuthorsById(ids: List<Int>) : List<Author> {
        val c = LinkedBlockingDeque<Author>()
        for (id in ids){
            thread(start = true) {
                val author = getAuthorById(id)
                c.addLast(author)            }
        }
        return c.toList()
    }

    fun registerForEvents(ids: List<Int>)  = runBlocking {
        for (id in ids) {
            registerForEvents(id)
        }
    }

    /**
     * Imagine this runs on a server.
     */
    private fun getAuthorById(id: Int): Author {
        val firstName = "${id}_First"
        val lastName = "${id}_Last"
        return Author(firstName, lastName)
    }

    /**
     * Imagine this runs on a server.
     */
    private suspend fun registerForEvents(id: Int): Int {
        delay(1000L)
        return 200;
    }

}