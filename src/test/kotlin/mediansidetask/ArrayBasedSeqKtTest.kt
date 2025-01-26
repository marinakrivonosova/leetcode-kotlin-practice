package mediansidetask

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArrayBasedSeqKtTest {

    @Test
    fun fromSortedArr() {
        val fromSortedArr = fromSortedArr(intArrayOf(1, 2, 3, 100))

        assertEquals(1, fromSortedArr.next())
        assertEquals(2, fromSortedArr.next())
        assertEquals(3, fromSortedArr.next())
        assertEquals(100, fromSortedArr.next())
        assertEquals(null, fromSortedArr.next())
        assertEquals(null, fromSortedArr.next())
        assertEquals(null, fromSortedArr.next())
    }

    @Test
    fun merge() {
        val a = fromSortedArr(intArrayOf(-1, 2, 30, 100))
        val b = fromSortedArr(intArrayOf(1, 5, 10, 1000))

        val sortedSeq = merge(a, b)

        assertEquals(-1, sortedSeq.next())
        assertEquals(1, sortedSeq.next())
        assertEquals(2, sortedSeq.next())
        assertEquals(5, sortedSeq.next())
        assertEquals(10, sortedSeq.next())
        assertEquals(30, sortedSeq.next())
        assertEquals(100, sortedSeq.next())
        assertEquals(1000, sortedSeq.next())
        assertEquals(null, sortedSeq.next())
        assertEquals(null, sortedSeq.next())
    }

    @Test
    fun drop() {
        val a = fromSortedArr(intArrayOf(-1, 1, 2, 4, 6, 11, 18, 23, 30, 100))
        a.drop(2)

        assertEquals(2, a.next())
        assertEquals(4, a.next())

        a.drop(3)

        assertEquals(23, a.next())
        assertEquals(30, a.next())
        assertEquals(100, a.next())


        val b = NaturalNumbers()
        b.drop(5)

        assertEquals(6, b.next())
    }

    @Test
    fun getMedian() {

        val a = intArrayOf(1, 3)
        val b = intArrayOf(2)

        assertEquals(2.000, getMedian(a, b))

        val c = intArrayOf(1, 3)
        val d = intArrayOf(2, 4)

        assertEquals(2.500, getMedian(c, d))
        assertEquals(1.000, getMedian(intArrayOf(1, 1, 1, 1, 1, 1), intArrayOf(0, 0, 0, 0, 0)))
        assertEquals(0.000, getMedian(intArrayOf(1, 1), intArrayOf(0, 0, 0, 0, 0)))

    }
}