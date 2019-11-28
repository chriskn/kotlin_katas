package de.chriskn.kotlinkata.client

import de.chriskn.kotlinkata.domain.Author
import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

class AuthorClient {

    fun getAuthorsById(ids: List<Int>): List<Author> {
        val que = LinkedBlockingDeque<Author>()
        for (id in ids) {
            val job = GlobalScope.launch {
                val author = getAuthorById(id)
                que.addLast(author)
            }
            runBlocking {
                job.join()
            }
        }
        return que.toList()
    }

    fun registerForEvents(ids: List<Int>): List<Int> = runBlocking {
        val deferred = ids.map { id ->
            GlobalScope.async {
                registerForEvents(id)
            }
        }
        deferred.map { it.await() }
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