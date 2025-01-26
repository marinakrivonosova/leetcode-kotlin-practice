package easyleetcodetasks

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
    fun testRemoveElement() {
        assertEquals(2, removeElement(intArrayOf(3, 2, 2, 3), 3))
        assertEquals(5, removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
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

    @Test
    fun mySqrt() {
        assertEquals(2, mySqrt(4))
        assertEquals(2, mySqrt(8))
        assertEquals(0, mySqrt(0))
        assertEquals(1, mySqrt(2))
        assertEquals(1, mySqrt(1))
    }

    @Test
    fun climbStairs() {
        assertEquals(2, climbStairsRecursion(2))
        assertEquals(3, climbStairsRecursion(3))
        assertEquals(5, climbStairsRecursion(4))
        assertEquals(1134903170, climbStairsRecursion(44))
        assertEquals(1836311903, climbStairsRecursion(45))
    }

    @Test
    fun climbStairsNoRecursion() {
        assertEquals(2, climbStairsNoRecursion(2))
        assertEquals(3, climbStairsNoRecursion(3))
        assertEquals(5, climbStairsNoRecursion(4))
        assertEquals(1134903170, climbStairsNoRecursion(44))
        assertEquals(1836311903, climbStairsNoRecursion(45))
    }

    @Test
    fun deleteDuplicates() {
        assertEquals(
            ListNode(1, ListNode(2, ListNode(3))),
            deleteDuplicates(ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3))))))
        )

        assertEquals(
            ListNode(1, ListNode(2)),
            deleteDuplicates(ListNode(1, ListNode(1, ListNode(2))))
        )

        assertEquals(
            ListNode(1),
            deleteDuplicates(ListNode(1))
        )

        assertEquals(
            null,
            deleteDuplicates(null)
        )
    }

    @Test
    fun mergeSortedArrays() {
        val arr1 = intArrayOf(1, 2, 3, 0, 0)
        val arr2 = intArrayOf(3, 4)
        mergeSortedArrays(arr1, 3, arr2, 2)
        assertArrayEquals(intArrayOf(1, 2, 3, 3, 4), arr1)

        val arr3 = intArrayOf(0)
        val arr4 = intArrayOf(1)
        mergeSortedArrays(arr3, 0, arr4, 1)
        assertArrayEquals(intArrayOf(1), arr3)

        val arr5 = intArrayOf(1)
        val arr6 = intArrayOf(0)
        mergeSortedArrays(arr5, 1, arr6, 0)
        assertArrayEquals(intArrayOf(1), arr5)

        val arr7 = intArrayOf(1, 2, 3, 0, 0, 0)
        val arr8 = intArrayOf(2, 5, 6)
        mergeSortedArrays(arr7, 3, arr8, 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), arr7)

        val arr9 = intArrayOf(2, 0)
        val arr10 = intArrayOf(1)
        mergeSortedArrays(arr9, 1, arr10, 1)
        assertArrayEquals(intArrayOf(1, 2), arr9)
    }

    @Test
    fun inorderTraversal() {
        assertEquals(listOf(1, 3, 2), inorderTraversal(TreeNode(1, null, TreeNode(2, TreeNode(3)))))
        assertEquals(
            listOf(4, 2, 6, 5, 7, 1, 3, 9, 8),
            inorderTraversal(
                TreeNode(
                    1,
                    left = TreeNode(
                        2,
                        left = TreeNode(4),
                        right = TreeNode(
                            5,
                            left = TreeNode(6),
                            right = TreeNode(7)
                        )
                    ),
                    right = TreeNode(
                        3,
                        right = TreeNode(
                            8,
                            left = TreeNode(9)
                        )
                    )
                )
            )
        )

        assertEquals(emptyList<Int>(), inorderTraversal(null))
        assertEquals(listOf(1), inorderTraversal(TreeNode(1)))
    }

    @Test
    fun inorderTraversalIterative() {
        assertEquals(listOf(1, 3, 2), inorderTraversalIterative(TreeNode(1, null, TreeNode(2, TreeNode(3)))))
        assertEquals(
            listOf(4, 2, 6, 5, 7, 1, 3, 9, 8),
            inorderTraversal(
                TreeNode(
                    1,
                    left = TreeNode(
                        2,
                        left = TreeNode(4),
                        right = TreeNode(
                            5,
                            left = TreeNode(6),
                            right = TreeNode(7)
                        )
                    ),
                    right = TreeNode(
                        3,
                        right = TreeNode(
                            8,
                            left = TreeNode(9)
                        )
                    )
                )
            )
        )

        assertEquals(emptyList<Int>(), inorderTraversalIterative(null))
        assertEquals(listOf(1), inorderTraversalIterative(TreeNode(1)))
    }

    @Test
    fun isSameTree() {
        assertEquals(
            true, isSameTree(
                TreeNode(1, null, TreeNode(2, TreeNode(3))),
                TreeNode(1, null, TreeNode(2, TreeNode(3)))
            )
        )

        assertEquals(
            false, isSameTree(
                TreeNode(1, null, TreeNode(2, TreeNode(3))),
                TreeNode(1, null, TreeNode(2, TreeNode(3, TreeNode(4))))
            )
        )

        assertEquals(
            false, isSameTree(
                TreeNode(1, null, TreeNode(2, TreeNode(3))),
                TreeNode(1, null, TreeNode(2))
            )
        )

        assertEquals(true, isSameTree(null, null))
        assertEquals(false, isSameTree(null, TreeNode(1)))
    }

    @Test
    fun isSymmetricTree() {
        assertEquals(
            true, isSymmetricTree(
                TreeNode(
                    1,
                    left = TreeNode(
                        2,
                        left = TreeNode(3),
                        right = TreeNode(4)
                    ),
                    right = TreeNode(
                        2,
                        left = TreeNode(4),
                        right = TreeNode(3)
                    )
                )
            )
        )
    }
}
