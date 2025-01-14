package easyLeetCodeTasks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class LeetCodeEasyTest {

    private val leetCodeEasy = LeetCodeEasy()

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0, 1), leetCodeEasy.twoSum(intArrayOf(2, 7, 11, 15), 9))
        assertArrayEquals(intArrayOf(1, 2), leetCodeEasy.twoSum(intArrayOf(3, 2, 4), 6))
        assertArrayEquals(intArrayOf(0, 1), leetCodeEasy.twoSum(intArrayOf(3, 3), 6))
    }

    @Test
    fun isPalindrome() {
        assertEquals(true, leetCodeEasy.isPalindrome(121))
        assertEquals(false, leetCodeEasy.isPalindrome(-121))
        assertEquals(false, leetCodeEasy.isPalindrome(10))
        assertEquals(true, leetCodeEasy.isPalindrome(1234321))
        assertEquals(true, leetCodeEasy.isPalindrome(0))

        assertEquals(true, leetCodeEasy.isPalindromeReverseString(121))
        assertEquals(false, leetCodeEasy.isPalindromeReverseString(-121))
        assertEquals(false, leetCodeEasy.isPalindromeReverseString(10))
        assertEquals(true, leetCodeEasy.isPalindromeReverseString(1234321))
        assertEquals(true, leetCodeEasy.isPalindromeReverseString(0))

        assertEquals(true, leetCodeEasy.isPalindromeHalfNumberConverting(121))
        assertEquals(false, leetCodeEasy.isPalindromeHalfNumberConverting(-121))
        assertEquals(false, leetCodeEasy.isPalindromeHalfNumberConverting(10))
        assertEquals(true, leetCodeEasy.isPalindromeHalfNumberConverting(1234321))
        assertEquals(true, leetCodeEasy.isPalindromeHalfNumberConverting(0))
    }

    @Test
    fun romanToInt() {
        assertEquals(3, leetCodeEasy.romanToIntUsingSwitch("III"))
        assertEquals(58, leetCodeEasy.romanToIntUsingSwitch("LVIII"))
        assertEquals(1994, leetCodeEasy.romanToIntUsingSwitch("MCMXCIV"))

        assertEquals(3, leetCodeEasy.romanToInt("III"))
        assertEquals(58, leetCodeEasy.romanToInt("LVIII"))
        assertEquals(1994, leetCodeEasy.romanToInt("MCMXCIV"))
    }

    @Test
    fun longestCommonPrefix() {
        assertEquals("a", leetCodeEasy.longestCommonPrefix(arrayOf("a")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("", "")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("", "a")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("a", "")))
        assertEquals("a", leetCodeEasy.longestCommonPrefix(arrayOf("ab", "a")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("a", "b")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("")))
        assertEquals("fl", leetCodeEasy.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        assertEquals("", leetCodeEasy.longestCommonPrefix(arrayOf("dog", "racecar", "car")))

    }

    @Test
    fun isValidParentheses() {
        assertTrue(leetCodeEasy.isValidParentheses("[]"))
        assertTrue(leetCodeEasy.isValidParentheses("[{}]"))
        assertTrue(leetCodeEasy.isValidParentheses("[(){}]"))
        assertTrue(leetCodeEasy.isValidParentheses("[{()}]"))
        assertFalse(leetCodeEasy.isValidParentheses("[{()}}"))
        assertFalse(leetCodeEasy.isValidParentheses("[}}"))
        assertFalse(leetCodeEasy.isValidParentheses("[]}"))
    }

    @Test
    fun mergeTwoListWithRecursion() {
        assertEquals(
            LeetCodeEasy.ListNode(1, LeetCodeEasy.ListNode(2, LeetCodeEasy.ListNode(3))),
            leetCodeEasy.mergeTwoLists(
                LeetCodeEasy.ListNode(1),
                LeetCodeEasy.ListNode(2, LeetCodeEasy.ListNode(3))
            )
        )
    }

    @Test
    fun mergeTwoList() {
        assertEquals(
            LeetCodeEasy.ListNode(1, LeetCodeEasy.ListNode(2, LeetCodeEasy.ListNode(3))),
            leetCodeEasy.mergeTwoListsNoRecursion(
                LeetCodeEasy.ListNode(1),
                LeetCodeEasy.ListNode(2, LeetCodeEasy.ListNode(3))
            )
        )
    }

    @Test
    fun removeDuplicates() {
        assertEquals(2, leetCodeEasy.removeDuplicates(intArrayOf(1, 2, 2)))
        assertEquals(5, leetCodeEasy.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
    }

    @Test
    fun `test find the index of the first occurrence in a string`() {
        assertEquals(0, leetCodeEasy.strStr("sadbutsad", "sad"))
        assertEquals(3, leetCodeEasy.strStr("sadbutsad", "but"))
        assertEquals(-1, leetCodeEasy.strStr("leetcode", "leeto"))
        assertEquals(0, leetCodeEasy.strStr("", ""))
        assertEquals(0, leetCodeEasy.strStr("a", ""))
    }

    @Test
    fun `test find the index of the first occurrence in a string without index() function`() {
        assertEquals(0, leetCodeEasy.strStrWithoutBuildInFunction("sadbutsad", "sad"))
        assertEquals(3, leetCodeEasy.strStrWithoutBuildInFunction("sadbutsad", "but"))
        assertEquals(-1, leetCodeEasy.strStrWithoutBuildInFunction("leetcode", "leeto"))
        assertEquals(0, leetCodeEasy.strStrWithoutBuildInFunction("", ""))
        assertEquals(0, leetCodeEasy.strStrWithoutBuildInFunction("a", ""))
        assertEquals(2, leetCodeEasy.strStrWithoutBuildInFunction("abc", "c"))
    }

    @Test
    fun `search insert position`() {
        assertEquals(2, leetCodeEasy.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, leetCodeEasy.searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, leetCodeEasy.searchInsert(intArrayOf(1, 3, 5, 6), 7))
    }

    @Test
    fun binarySearch() {
        assertEquals(
            4, leetCodeEasy.binarySearch(
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
            15, leetCodeEasy.binarySearch(
                intArrayOf(
                    1, 2, 3, 4, 5, 6, 7, 19, 20, 21, 22, 23, 24,
                    25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                    37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48
                ), 27
            )
        )
        assertEquals(-1, leetCodeEasy.binarySearch(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(2, leetCodeEasy.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(0, leetCodeEasy.binarySearch(intArrayOf(1, 3, 5, 6), 1))
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
        assertEquals(4, leetCodeEasy.binarySearchRecursion(nums, 5, start = 0, end = nums.lastIndex))

        val nums1 = intArrayOf(
            1, 2, 3, 4, 5, 6, 7, 19, 20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
            37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48
        )
        assertEquals(15, leetCodeEasy.binarySearchRecursion(nums1, 27, start = 0, end = nums1.lastIndex))
        assertEquals(-1, leetCodeEasy.binarySearchRecursion(intArrayOf(1, 3, 5, 6), 2, start = 0, end = 3))
        assertEquals(2, leetCodeEasy.binarySearchRecursion(intArrayOf(1, 3, 5, 6), 5, start = 0, end = 3))
        assertEquals(0, leetCodeEasy.binarySearchRecursion(intArrayOf(1, 3, 5, 6), 1, start = 0, end = 3))
    }

    @Test
    fun testLengthOfLastWord() {
        assertEquals(5, leetCodeEasy.lengthOfLastWord("Hello World"))
        assertEquals(4, leetCodeEasy.lengthOfLastWord("   fly me   to   the moon  "))
        assertEquals(6, leetCodeEasy.lengthOfLastWord("fluffy is still joyboy"))
        assertEquals(11, leetCodeEasy.lengthOfLastWord("he says abracadabra  "))
    }
}