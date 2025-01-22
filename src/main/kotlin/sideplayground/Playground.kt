package sideplayground

import java.util.*

fun binarySearch(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex

    while (start <= end) {
        val middle = (end + start) / 2
        if (nums[middle] == target) {
            return middle
        } else if (nums[middle] < target) {
            start = middle + 1
        } else end = middle - 1
    }
    return -1
}

fun binarySearchRecursion(nums: IntArray, target: Int, start: Int, end: Int): Int {
    if (end >= start) {
        val middle = (end + start) / 2
        return if (nums[middle] == target) {
            middle
        } else if (nums[middle] < target) {
            binarySearchRecursion(nums, target, middle + 1, end)
        } else binarySearchRecursion(nums, target, start, middle - 1)
    }
    return -1
}

// Numbers split into 2 groups and find min possible sum difference
fun sumDifference(elements: IntArray): Long {
    var result = Long.MAX_VALUE
    for (mask in 0 until (1 shl (elements.size - 1))) {
        val sums = LongArray(2)
        elements.forEachIndexed { index, a ->
            sums[(mask shr index) and 0b000001] += a.toLong()
        }
        result = Math.min(result, Math.abs(sums[0] - sums[1]))
    }
    return result
}

fun fibonacci(n: Int): Int {
    if (n < 3) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}

//Climbing stairs with step 1 or step 3 all possible variants
fun climbStairsAllPossibleVariants(x: Int): Int {
    if (x < 3) return 1
    var prevMin3 = 1
    var prevMin2 = 1
    var prevMin1 = 1
    for (i in 3..x) {
        val curr = prevMin3 + prevMin1
        prevMin3 = prevMin2
        prevMin2 = prevMin1
        prevMin1 = curr
    }

    return prevMin1
}

fun binaryPow(a: Int, pow: Int): Int {
    if (pow == 0) return 1
    val res = binaryPow(a, pow / 2)
    return if (pow % 2 == 0) {
        res * res
    } else {
        res * res * a
    }
}

fun binaryPowNoRecursion(a: Int, pow: Int): Int {
    var res = 1
    var n = pow
    var x = a

    while (n > 0) {
        if (n % 2 == 1) {
            res *= x
            n--
        } else {
            x *= x
            n /= 2
        }
    }
    return res
}

fun quicksort(arr: IntArray, lowIndex: Int, highIndex: Int) {
    if (lowIndex >= highIndex) {
        return
    }
    val pivotIndex = partition(arr, lowIndex = lowIndex, highIndex = highIndex)
    quicksort(arr, lowIndex, pivotIndex - 1)
    quicksort(arr, pivotIndex + 1, highIndex)
}

private fun partition(arr: IntArray, lowIndex: Int, highIndex: Int): Int {
    val pivotIndex = Random().nextInt(highIndex - lowIndex) + lowIndex
    var pivotIndexCounter = lowIndex
    swap(arr, pivotIndex, highIndex)

    for (i in lowIndex until highIndex) {
        if (arr[i] < arr[highIndex]) {
            swap(arr, pivotIndexCounter, i)
            pivotIndexCounter++
        }
    }
    swap(arr, pivotIndexCounter, highIndex)
    return pivotIndexCounter
}

private fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}

fun bubbleSort(arr: IntArray) {
    for (i in arr.indices) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1)
            }
        }
    }
}