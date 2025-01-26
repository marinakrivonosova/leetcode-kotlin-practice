package mediumleetcodetasks

import kotlin.math.max

//7. Reverse Integer
fun reverse(x: Int): Int {
    var result = 0
    var input = x

    while (input != 0) {
        val digit = input % 10
        input /= 10
        if (result > Int.MAX_VALUE / 10
            || (result == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10)
        ) {
            return 0
        }
        if (result < Int.MIN_VALUE / 10
            || (result == Int.MIN_VALUE / 10 && digit < Int.MIN_VALUE % 10)
        ) {
            return 0
        }

        result = result * 10 + digit
    }

    return result
}

//75. Sort Colors
fun sortColors(nums: IntArray) {
    sortColors(nums, 0, nums.size - 1)

}

private fun sortColors(nums: IntArray, lowIndex: Int, highIndex: Int) {
    if (lowIndex >= highIndex) {
        return
    }
    val partition = partition(nums, lowIndex, highIndex)
    sortColors(nums, 0, partition - 1)
    sortColors(nums, partition + 1, highIndex)

}

private fun partition(nums: IntArray, lowIndex: Int, highIndex: Int): Int {
    val pivotIndex = (lowIndex + highIndex) / 2
    var pointer = lowIndex

    swap(nums, pivotIndex, highIndex)

    for (i in lowIndex..highIndex) {
        if (nums[i] < nums[highIndex]) {
            swap(nums, i, pointer)
            pointer++
        }
    }
    swap(nums, pointer, highIndex)
    return pointer
}

private fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}

fun sortColorWithCount(nums: IntArray) {
    val counter = Array(3) { 0 }

    for (i in nums) {
        counter[i]++
    }
    for (i in 0 until counter[0]) {
        nums[i] = 0
    }

    for (i in counter[0] until counter[0] + counter[1]) {
        nums[i] = 1
    }

    for (i in counter[0] + counter[1] until nums.size) {
        nums[i] = 2
    }
}

fun sortColorWith2Pointers(nums: IntArray) {
    var left = 0
    var right = nums.size - 1

    var i = 0

    while (i <= right) {
        if (nums[i] == 0) {
            swap(nums, i, left)
            left++
        }
        if (nums[i] == 2) {
            swap(nums, i, right)
            right--
            i--
        }
        i++
    }
}

//2. Add Two Numbers

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val result = ListNode(0)
    var curr = result
    var carry = 0
    var list1 = l1
    var list2 = l2

    while (list1 != null || list2 != null || carry != 0) {
        val v1 = list1?.`val` ?: 0
        val v2 = list2?.`val` ?: 0

        var currSum = v1 + v2 + carry
        carry = currSum / 10
        currSum %= 10

        curr.next = ListNode(`val` = currSum)
        curr = curr.next!!

        list1 = list1?.next
        list2 = list2?.next
    }

    return result.next
}

data class ListNode(var `val`: Int, var next: ListNode? = null)

//3. Longest Substring Without Repeating Characters
fun lengthOfLongestSubstringN2(s: String): Int {
    if (s.length < 2) return s.length
    var max = 0
    var counter = 0
    for (i in s.indices) {
        var result = s[i].toString()
        counter++
        var j = i + 1
        while (j < s.length) {
            if (!result.contains(s[j])) {
                counter++
                result += s[j]
                j++
            } else {
                j = s.length
            }
        }
        max = max(max, counter)
        counter = 0
    }
    return max
}

fun lengthOfLongestSubstring(s: String): Int {
    val charSet = mutableSetOf<Char>()
    var result = 0
    var left = 0

    for (r in s.indices) {
        while (charSet.contains(s[r])) {
            charSet.remove(s[left])
            left++
        }
        charSet.add(s[r])
        result = max(result, r - left + 1)
    }
    return result
}

//8. String to Integer (atoi)
fun myAtoi(s: String): Int {
    var res = 0L
    var negative = 1
    var i = 0
    while (i < s.length && s[i] == ' ') i++
    if (i < s.length && s[i] == '-') {
        negative = -1
        i++
    } else if (i < s.length && s[i] == '+') {
        i++
    }

    while (i < s.length && s[i] in '0'..'9') {
        if (res * negative > Int.MAX_VALUE) return Int.MAX_VALUE
        if (res * negative < Int.MIN_VALUE) return Int.MIN_VALUE
        res = res * 10 + (s[i] - '0')
        i++
    }

    res *= negative
    if (res > Int.MAX_VALUE) return Int.MAX_VALUE
    if (res < Int.MIN_VALUE) return Int.MIN_VALUE

    return res.toInt()
}

//5. Longest Palindromic Substring
fun longestPalindrome(s: String): String {
    var max = ""
    for (i in s.indices) {
        val oP = oddPalindrome(s, i)
        max = if (oP.length > max.length) oP else max
        val eP = evenPalindrome(s, i)
        max = if (eP.length > max.length) eP else max

    }
    return max
}

fun oddPalindrome(s: String, center: Int): String {
    var left = center - 1
    var right = center + 1
    while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
    }
    return s.substring(left + 1, right)
}

fun evenPalindrome(s: String, center: Int): String {
    var left = center
    var right = center + 1
    while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
    }
    return s.substring(left + 1, right)
}
