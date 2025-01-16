package sideplayground

import easyleetcodetasks.searchInsert
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PlaygroundTest {

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
    fun testFibonacciRecursion() {
        assertEquals(3, fibonacci(4))
        assertEquals(8, fibonacci(6))
        assertEquals(34, fibonacci(9))
    }

    @Test
    fun testSumDifference() {
        assertEquals(1, sumDifference(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0, sumDifference(intArrayOf(-10000, 0, 0, 0, 10000)))
        assertEquals(999985, sumDifference(intArrayOf(1000000, 1, 2, 3, 4, 5)))
    }

    @Test
    fun testClimbStairsAllPossibleVariants() {
        assertEquals(2, climbStairsAllPossibleVariants(3))
        assertEquals(28, climbStairsAllPossibleVariants(10))
        assertEquals(9, climbStairsAllPossibleVariants(7))
    }

    @Test
    fun testBinaryPow() {
        assertEquals(1024, binaryPow(2, 10))
        assertEquals(4, binaryPow(2, 2))
        assertEquals(16, binaryPow(2, 4))
        assertEquals(64, binaryPow(2, 6))
        assertEquals(256, binaryPow(2, 8))
        assertEquals(2401, binaryPow(7, 4))
        assertEquals(32, binaryPow(2, 5))
    }

    @Test
    fun testBinaryPowNoRecursion() {
        assertEquals(1024, binaryPowNoRecursion(2, 10))
        assertEquals(4, binaryPowNoRecursion(2, 2))
        assertEquals(16, binaryPowNoRecursion(2, 4))
        assertEquals(64, binaryPowNoRecursion(2, 6))
        assertEquals(256, binaryPowNoRecursion(2, 8))
        assertEquals(2401, binaryPowNoRecursion(7, 4))
        assertEquals(32, binaryPowNoRecursion(2, 5))
    }
}
