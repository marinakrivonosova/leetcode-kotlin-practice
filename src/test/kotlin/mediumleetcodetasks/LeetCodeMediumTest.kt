package mediumleetcodetasks

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
}
