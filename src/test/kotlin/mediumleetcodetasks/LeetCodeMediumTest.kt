package mediumleetcodetasks

import org.junit.jupiter.api.Assertions.*
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

    @Test
    fun testAddTwoNumbers() {
        assertEquals(
            ListNode(
                7, ListNode(
                    0, ListNode(8)
                )
            ), addTwoNumbers(
                ListNode(2, ListNode(4, ListNode(3))),
                ListNode(5, ListNode(6, ListNode(4)))
            )
        )

        assertEquals(
            ListNode(
                7, ListNode(
                    0, ListNode(8)
                )
            ), addTwoNumbers(
                ListNode(2, ListNode(4, ListNode(3))),
                ListNode(5, ListNode(6, ListNode(4)))
            )
        )
    }

    @Test
    fun testLengthOfLongestSubstring() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, lengthOfLongestSubstring("bbbbb"))
        assertEquals(0, lengthOfLongestSubstring(""))
        assertEquals(3, lengthOfLongestSubstring("pwwkew"))
        assertEquals(1, lengthOfLongestSubstring(" "))
        assertEquals(2, lengthOfLongestSubstring("au"))
    }

    @Test
    fun testLengthOfLongestSubstringN1() {
        assertEquals(3, lengthOfLongestSubstringN2("abcabcbb"))
        assertEquals(1, lengthOfLongestSubstringN2("bbbbb"))
        assertEquals(0, lengthOfLongestSubstringN2(""))
        assertEquals(3, lengthOfLongestSubstringN2("pwwkew"))
        assertEquals(1, lengthOfLongestSubstringN2(" "))
        assertEquals(2, lengthOfLongestSubstringN2("au"))
    }

    @Test
    fun testMyAtoi() {
        assertEquals(42, myAtoi("42"))
        assertEquals(-42, myAtoi("   -42"))
        assertEquals(-42, myAtoi("   -042"))
        assertEquals(1337, myAtoi("1337c0d3"))
        assertEquals(0, myAtoi("0-1"))
        assertEquals(0, myAtoi("words and 98"))
        assertEquals(-2147483648, myAtoi("-91283472332"))
        assertEquals(3, myAtoi("3.141592"))
        assertEquals(3, myAtoi("3+2"))
        assertEquals(0, myAtoi("+-12"))
        assertEquals(2147483647, myAtoi("9223372036854775808"))
    }

    @Test
    fun longestPalindrome() {
        assertEquals("a", longestPalindrome("a"))
        assertEquals("aba", longestPalindrome("aba"))
        assertEquals("bab", longestPalindrome("babad"))
        assertEquals("bb", longestPalindrome("cbbd"))
        assertEquals("bb", longestPalindrome("bb"))
        assertEquals("bb", longestPalindrome("abb"))
        assertEquals("aca", longestPalindrome("aacabdkacaa"))
    }

    @Test
    fun testReverseWords() {
        assertEquals("blue is sky the", reverseWordsStreams("the sky is blue"))
        assertEquals("blue is sky the", reverseWordsStreams("  the sky is blue  "))

        assertEquals("blue is sky the", reverseWords("the sky is blue"))
        assertEquals("blue is sky the", reverseWords("  the sky is blue  "))
        assertEquals("example good a", reverseWords("a good   example"))
    }

    @Test
    fun testProductExceptSelf() {
        assertArrayEquals(intArrayOf(24, 12, 8, 6), productExceptSelf(intArrayOf(1, 2, 3, 4)))
        assertArrayEquals(intArrayOf(0, 0, 9, 0, 0), productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)))
    }

    @Test
    fun testIncreasingTriplet() {
        assertTrue(increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
        assertFalse(increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
        assertTrue(increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
        assertTrue(increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))
    }

    @Test
    fun testCompressString() {
        assertEquals(6, compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
        assertEquals(1, compress(charArrayOf('a')))
        assertEquals(6, compress(charArrayOf('a','a','a','b', 'b','a','a')))
        assertEquals(4, compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')))
    }

}
