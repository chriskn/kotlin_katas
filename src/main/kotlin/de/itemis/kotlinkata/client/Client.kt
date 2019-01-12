package de.itemis.kotlinkata.client

import de.itemis.kotlinkata.domain.Author
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread


class Client {

    fun getAuhtorsById_Fast(ids: List<Int>) : List<Author> {
        val c = LinkedBlockingDeque<Author>()
        for (id in ids){
            GlobalScope.launch {
                val firstname = "${id}_First"
                val lastname = "${id}_Last"
                val author = Author(firstname, lastname)
                c.addLast(author)
            }
        }
        return c.toList()
    }


    fun getAuthorsById_Slow(ids: List<Int>) : List<Author> {
        val c = LinkedBlockingDeque<Author>()
        for (id in ids){
            thread(start = true) {
                val firstname = "${id}_First"
                val lastname = "${id}_Last"
                val author = Author(firstname, lastname)
                c.addLast(author)            }
        }
        return c.toList()
    }
}