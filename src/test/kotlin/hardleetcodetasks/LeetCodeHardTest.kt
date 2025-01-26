package hardleetcodetasks

import kotlin.test.Test
import kotlin.test.assertEquals

internal class LeetCodeHardTest {

    @Test
    fun findMedianSortedArrays() {
        assertEquals(2.000, findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
        assertEquals(2.500, findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
    }


}