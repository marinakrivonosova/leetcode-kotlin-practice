package mediumleetcodetasks

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LeetCodeMediumTest {

    @Test
    fun testReverseInt() {
        assertEquals(321, reverse(123))
        assertEquals(-1, reverse(-100))
        assertEquals(-1, reverse(-100))
        assertEquals(0, reverse(-2147483648))
        assertEquals(0, reverse(2147483647))
        assertEquals(0, reverse(1563847412))
        assertEquals(0, reverse(-1563847422))
    }

    @Test
    fun testSortColorsQuicksort() {
        val arr1 = intArrayOf(0, 1, 2, 2, 1, 0, 2, 1, 0)
        sortColors(arr1)
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 1, 1, 2, 2, 2), arr1)

        val arr2 = intArrayOf(
            2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0,
            2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0,
            2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2,
            0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2,
            0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1,
            1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0,
            1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0,
            0, 2, 1, 0, 0
        )
        sortColors(arr2)
        assertArrayEquals(
            intArrayOf(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            ), arr2
        )
    }

    @Test
    fun testSortColorsWithCountt() {
        val arr1 = intArrayOf(0, 1, 2, 2, 1, 0, 2, 1, 0)
        sortColorWithCount(arr1)
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 1, 1, 2, 2, 2), arr1)

        val arr2 = intArrayOf(
            2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0,
            2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0,
            2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2,
            0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2,
            0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1,
            1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0,
            1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0,
            0, 2, 1, 0, 0
        )
        sortColorWithCount(arr2)
        assertArrayEquals(
            intArrayOf(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            ), arr2
        )
    }

    @Test
    fun testSortColorsWith2Pointers() {
        val arr1 = intArrayOf(0, 1, 2, 2, 1, 0, 2, 1, 0)
        sortColorWith2Pointers(arr1)
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 1, 1, 2, 2, 2), arr1)

        val arr2 = intArrayOf(
            2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0,
            2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0,
            2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2,
            0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2,
            0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1,
            1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0,
            1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0,
            0, 2, 1, 0, 0
        )
        sortColorWith2Pointers(arr2)
        assertArrayEquals(
            intArrayOf(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
            ), arr2
        )
    }

    @Test
    fun cornerCases() {
        val cases = listOf(
            intArrayOf(0, 1, 2),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 2, 2, 2),
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 1, 0, 0, 1, 1),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1),

            intArrayOf(0, 0, 2, 2),
            intArrayOf(2, 2, 0, 0, 2, 2),
            intArrayOf(2, 2, 0, 0),
            intArrayOf(0, 2, 0, 2, 0),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(0, 2, 0, 2),

            intArrayOf(2, 2, 1, 1),
            intArrayOf(1, 1, 2, 2, 1, 1),
            intArrayOf(1, 1, 2, 2),
            intArrayOf(2, 1, 2, 1, 2),
            intArrayOf(1, 2, 1, 2),
            intArrayOf(2, 1, 2, 1),
        )

        for (case in cases) {
            val expected = case.sorted().toIntArray()
            val actual = case.copyOf()
            sortColorWith2Pointers(actual)
            assertArrayEquals(expected, actual)
        }
    }
}
