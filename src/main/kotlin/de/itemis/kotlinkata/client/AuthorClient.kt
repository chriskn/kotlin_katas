package de.itemis.kotlinkata.client

import de.itemis.kotlinkata.Author
import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingDeque

class AuthorClient {

    fun getAuthorsById(ids: List<Int>): List<Author> {
        val que = LinkedBlockingDeque<Author>()

        for (id in ids) {
            runBlocking {
                var job = GlobalScope.launch {
                    val author = getAuthorById(id)
                    que.addLast(author)

                }
                job.join()
            }

        }
        return que.toList()
    }

    fun registerForEvents(ids: List<Int>): List<Int> {
        var statusCodes: MutableList<Int> = ArrayList()
        runBlocking {
            for (id in ids) {
                statusCodes.add(GlobalScope.async {
                    registerForEvents(id)
                }.await())
            }
        }
        return statusCodes
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
