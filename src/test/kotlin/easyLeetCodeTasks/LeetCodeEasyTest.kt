package easyLeetCodeTasks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class LeetCodeEasyTest {

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(2, 7, 11, 15), 9))
        assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(3, 2, 4), 6))
        assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(3, 3), 6))
    }

    @Test
    fun isPalindrome() {
        assertEquals(true, isPalindrome(121))
        assertEquals(false, isPalindrome(-121))
        assertEquals(false, isPalindrome(10))
        assertEquals(true, isPalindrome(1234321))
        assertEquals(true, isPalindrome(0))

        assertEquals(true, isPalindromeReverseString(121))
        assertEquals(false, isPalindromeReverseString(-121))
        assertEquals(false, isPalindromeReverseString(10))
        assertEquals(true, isPalindromeReverseString(1234321))
        assertEquals(true, isPalindromeReverseString(0))

        assertEquals(true, isPalindromeHalfNumberConverting(121))
        assertEquals(false, isPalindromeHalfNumberConverting(-121))
        assertEquals(false, isPalindromeHalfNumberConverting(10))
        assertEquals(true, isPalindromeHalfNumberConverting(1234321))
        assertEquals(true, isPalindromeHalfNumberConverting(0))
    }

    @Test
    fun romanToInt() {
        assertEquals(3, romanToIntUsingSwitch("III"))
        assertEquals(58, romanToIntUsingSwitch("LVIII"))
        assertEquals(1994, romanToIntUsingSwitch("MCMXCIV"))

        assertEquals(3, romanToInt("III"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }

    @Test
    fun longestCommonPrefix() {
        assertEquals("a", longestCommonPrefix(arrayOf("a")))
        assertEquals("", longestCommonPrefix(arrayOf("", "")))
        assertEquals("", longestCommonPrefix(arrayOf("", "a")))
        assertEquals("", longestCommonPrefix(arrayOf("a", "")))
        assertEquals("a", longestCommonPrefix(arrayOf("ab", "a")))
        assertEquals("", longestCommonPrefix(arrayOf("a", "b")))
        assertEquals("", longestCommonPrefix(arrayOf("")))
        assertEquals("fl", longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        assertEquals("", longestCommonPrefix(arrayOf("dog", "racecar", "car")))

    }

    @Test
    fun isValidParentheses() {
        assertTrue(isValidParentheses("[]"))
        assertTrue(isValidParentheses("[{}]"))
        assertTrue(isValidParentheses("[(){}]"))
        assertTrue(isValidParentheses("[{()}]"))
        assertFalse(isValidParentheses("[{()}}"))
        assertFalse(isValidParentheses("[}}"))
        assertFalse(isValidParentheses("[]}"))
    }

    @Test
    fun mergeTwoListWithRecursion() {
        assertEquals(
            ListNode(1, ListNode(2, ListNode(3))),
            mergeTwoLists(
                ListNode(1),
                ListNode(2, ListNode(3))
            )
        )
    }

    @Test
    fun mergeTwoList() {
        assertEquals(
            ListNode(1, ListNode(2, ListNode(3))),
            mergeTwoListsNoRecursion(
                ListNode(1),
                ListNode(2, ListNode(3))
            )
        )
    }

    @Test
    fun removeDuplicates() {
        assertEquals(2, removeDuplicates(intArrayOf(1, 2, 2)))
        assertEquals(5, removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    }

    @Test
    fun `test find the index of the first occurrence in a string`() {
        assertEquals(0, strStr("sadbutsad", "sad"))
        assertEquals(3, strStr("sadbutsad", "but"))
        assertEquals(-1, strStr("leetcode", "leeto"))
        assertEquals(0, strStr("", ""))
        assertEquals(0, strStr("a", ""))
    }

    @Test
    fun `test find the index of the first occurrence in a string without index() function`() {
        assertEquals(0, strStrWithoutBuildInFunction("sadbutsad", "sad"))
        assertEquals(3, strStrWithoutBuildInFunction("sadbutsad", "but"))
        assertEquals(-1, strStrWithoutBuildInFunction("leetcode", "leeto"))
        assertEquals(0, strStrWithoutBuildInFunction("", ""))
        assertEquals(0, strStrWithoutBuildInFunction("a", ""))
        assertEquals(2, strStrWithoutBuildInFunction("abc", "c"))
    }

    @Test
    fun `search insert position`() {
        assertEquals(2, searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, searchInsert(intArrayOf(1, 3, 5, 6), 7))
    }

    @Test
    fun binarySearch() {
        assertEquals(
            4, binarySearch(
                intArrayOf(
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                    25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                    37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
                    49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                    61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72,
                    73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
                    85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96,
                    97, 98, 99, 100
                ), 5
            )
        )

        assertEquals(
            15, binarySearch(
                intArrayOf(
                    1, 2, 3, 4, 5, 6, 7, 19, 20, 21, 22, 23, 24,
                    25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                    37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48
                ), 27
            )
        )
        assertEquals(-1, binarySearch(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(2, searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(0, binarySearch(intArrayOf(1, 3, 5, 6), 1))
    }

    @Test
    fun binarySearchRecursion() {
        val nums = intArrayOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
            37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
            49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72,
            73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96,
            97, 98, 99, 100
        )
        assertEquals(4, binarySearchRecursion(nums, 5, start = 0, end = nums.lastIndex))

        val nums1 = intArrayOf(
            1, 2, 3, 4, 5, 6, 7, 19, 20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
            37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48
        )
        assertEquals(15, binarySearchRecursion(nums1, 27, start = 0, end = nums1.lastIndex))
        assertEquals(-1, binarySearchRecursion(intArrayOf(1, 3, 5, 6), 2, start = 0, end = 3))
        assertEquals(2, binarySearchRecursion(intArrayOf(1, 3, 5, 6), 5, start = 0, end = 3))
        assertEquals(0, binarySearchRecursion(intArrayOf(1, 3, 5, 6), 1, start = 0, end = 3))
    }

    @Test
    fun testLengthOfLastWord() {
        assertEquals(5, lengthOfLastWord("Hello World"))
        assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "))
        assertEquals(6, lengthOfLastWord("fluffy is still joyboy"))
        assertEquals(11, lengthOfLastWord("he says abracadabra  "))
    }

    @Test
    fun testPlusOne() {
        assertArrayEquals(intArrayOf(1, 2, 4), plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(1, 0), plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(4, 3, 2, 2), plusOne(intArrayOf(4, 3, 2, 1)))
        assertArrayEquals(intArrayOf(1, 0, 0), plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1), plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)))
    }

    @Test
    fun testAddBinary() {
        assertEquals("100", addBinary(a = "11", b = "1"))
        assertEquals("10101", addBinary(a = "1010", b = "1011"))
    }
}