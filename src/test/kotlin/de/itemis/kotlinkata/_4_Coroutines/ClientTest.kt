package de.itemis.kotlinkata._4_Coroutines

import de.itemis.kotlinkata.client.Client
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import org.assertj.core.api.Assertions.assertThat

class ClientTest{

    val client = Client()
    val twoSeconds = 1000*2L

    @Test
    fun test_getAuthorsById_Fast_is_fast(){
        val timeNeeded = measureTimeMillis {
            client.getAuhtorsById_Fast((0..100_000).toList())
        }
        assertThat(timeNeeded).isLessThan(twoSeconds)
    }

    @Test
    fun test_getAuthorsById_Fast_creates_all_authors(){
        val authors = client.getAuhtorsById_Fast((0..100_000).toList())
        assertThat(authors.size).isEqualTo(100_000)

    }

    @Test
    fun test_getAuthorsById_Slow_is_fast(){
        val timeNeeded = measureTimeMillis {
            client.getAuthorsById_Slow((0..100_000).toList())
        }
        assertThat(timeNeeded).isLessThan(twoSeconds)
    }

    @Test
    fun test_getAuthorsById_Slow_creates_all_authors(){
        val authors = client.getAuthorsById_Slow((0..100_000).toList())
        assertThat(authors.size).isEqualTo(100_000)
    }
}