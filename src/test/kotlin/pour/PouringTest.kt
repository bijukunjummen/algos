package pour

import io.vavr.kotlin.list
import org.junit.Test

class PouringTest {

    @Test
    fun testWith2Glasses() {
        val capacity = list(4, 9)
        val initialState = list(0, 0)
        val pouring = Pouring(capacity, initialState)

        pouring.solution(list(0, 6)).take(2).forEach { println(it) }

    }

    @Test
    fun testWith3Glasses() {
        val capacity = list(12, 8, 5)
        val initialState = list(12, 0, 0)
        val pouring = Pouring(capacity, initialState)

        pouring.solution(list(6, 6, 0)).take(2).forEach { println(it) }

    }
}