package mediumleetcodetasks

import java.util.*
import kotlin.math.max
import kotlin.math.min

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

//151. Reverse Words in a String
fun reverseWords(s: String): String {
    val splited = s.trim().split(Regex("\\s+")).toTypedArray()
    var start = 0
    var end = splited.size - 1
    while (start < end) {

        val temp = splited[start]
        splited[start] = splited[end]
        splited[end] = temp

        start++
        end--
    }
    return splited.joinToString(" ")

}

fun reverseWordsStreams(s: String): String =
    s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(separator = " ")

//238. Product of Array Except Self
fun productExceptSelf(nums: IntArray): IntArray {
    var prefix = 1
    var suffix = 1
    val result = Array(nums.size) { 0 }

    for (i in nums.indices) {
        result[i] = prefix
        prefix *= nums[i]
    }

    for (i in nums.size - 1 downTo 0) {
        result[i] *= suffix
        suffix *= nums[i]
    }

    return result.toIntArray()
}

//334. Increasing Triplet Subsequence
fun increasingTriplet(nums: IntArray): Boolean {
    var prevMin1 = Int.MAX_VALUE
    var prevMin2 = Int.MAX_VALUE
    for (i in nums) {
        if (i <= prevMin1) prevMin1 = i
        else if (i <= prevMin2) prevMin2 = i
        else return true
    }
    return false
}

//443. String Compression
fun compress(chars: CharArray): Int {
    var index = 0
    var indexChar = 0

    while (index < chars.size) {
        var groupCounter = 0
        val currChar = chars[index]

        while (index < chars.size && currChar == chars[index]) {
            groupCounter++
            index++
        }
        chars[indexChar++] = currChar
        if (groupCounter > 1) {
            for (i in groupCounter.toString()) {
                chars[indexChar++] = i
            }
        }
    }
    return indexChar
}

//11. Container With Most Water
fun maxArea(height: IntArray): Int {
    var currMax = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        if (min(height[left], height[right]) * (right - left) > currMax) currMax =
            min(height[left], height[right]) * (right - left)

        if (height[left] <= height[right]) left++
        else right--

    }
    return currMax
}

//1679. Max Number of K-Sum Pairs
fun maxOperations(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var left = 0
    var right = nums.size - 1
    var count = 0

    while (left < right) {
        if (nums[left] + nums[right] == k) {
            left++
            right--
            count++
        } else if (nums[left] + nums[right] > k) right--
        else left++
    }
    return count
}

fun maxOperationsWithHashMap(nums: IntArray, k: Int): Int {
    var count = 0
    val map = mutableMapOf<Int, Int>()

    for (i in nums) {
        if (i < k) {
            if (map.getOrDefault(k - i, 0) == 0) {
                map[i] = map.getOrDefault(i, 0) + 1
            } else {
                map[k - i] = map.getOrDefault(k - i, 0) - 1
                count++
            }
        }
    }
    return count
}

//1456. Maximum Number of Vowels in a Substring of Given Length
fun maxVowelsWithQueue(s: String, k: Int): Int {
    var max = Int.MIN_VALUE
    var count = 0
    val queue: Queue<Char> = LinkedList()

    for (t in s) {
        queue.add(t)
        if (t.isVowel()) count++
        if (queue.size == k) {
            max = max(count, max)
            if (queue.poll().isVowel()) count--
        }
    }
    return max
}

fun maxVowels(s: String, k: Int): Int {
    var max = Int.MIN_VALUE
    var count = 0
    for (i in s.indices) {
        if (s[i].isVowel()) count++
        if (i - k >= 0 && s[i - k].isVowel()) count--
        max = max(count, max)
    }
    return max
}

private fun Char.isVowel(): Boolean {
    val vowels = charArrayOf('a', 'e', 'o', 'i', 'u')
    return vowels.contains(this)
}

//1004. Max Consecutive Ones III
fun longestOnes(nums: IntArray, k: Int): Int {
    var zeroCount = 0
    var maxLength = 0
    var left = 0

    for (right in nums.indices) {
        if (nums[right] == 0) {
            zeroCount++
        }

        while (zeroCount > k) {
            if (nums[left] == 0) {
                zeroCount--
            }
            left++
        }

        maxLength = max(maxLength, right - left + 1)
    }
    return maxLength
}

//12. Integer to Roman
fun intToRoman(num: Int): String {
    var t: Int = num
    val res = StringBuilder()
    val dictionary = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    for (value in values) {
        while (t >= value) {
            res.append(dictionary[value])
            t -= value
        }
    }

    return res.toString()
}

fun intToRomanV2(num: Int): String {
    val thousand = arrayOf("", "M", "MM", "MMM")
    val hundred = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val tens = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val ones = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

    return thousand[num / 1000] + hundred[(num % 1000) / 100] + tens[((num % 1000) % 100) / 10] + ones[num % 10]
}

fun intToRomanV3(num: Int): String {
    var number = num
    var count = 0
    val res = StringBuilder()


    if (number >= 1000) {
        count = number / 1000
        number = number % 1000
        repeat(count = count, builder = res, "M")
    }

    if (number >= 900) {
        count = number / 900
        number = number % 900
        repeat(count = count, builder = res, "CM")
    }

    if (number >= 500) {
        count = number / 500
        number = number % 500
        repeat(count = count, builder = res, "D")

    }

    if (number >= 400) {
        count = number / 400
        number %= 400
        repeat(count = count, builder = res, "CD")
    }
    if (number >= 100) {
        count = number / 100
        number %= 100
        repeat(count = count, builder = res, "C")
    }

    if (number >= 90) {
        count = number / 90
        number %= 90
        repeat(count = count, builder = res, "XC")
    }

    if (number >= 50) {
        count = number / 50
        number %= 50
        repeat(count = count, builder = res, "L")
    }

    if (number >= 40) {
        count = number / 40
        number %= 40
        repeat(count = count, builder = res, "XL")
    }

    if (number >= 10) {
        count = number / 10
        number %= 10
        repeat(count = count, builder = res, "X")
    }
    if (number >= 9) {
        count = number / 9
        number = number % 9
        repeat(count = count, builder = res, "IX")
    }

    if (number >= 5) {
        count = number / 5
        number %= 5
        repeat(count = count, builder = res, "V")
    }

    if (number >= 4) {
        count = number / 4
        number = number % 4
        repeat(count = count, builder = res, "IV")
    }

    if (number >= 1) {
        count = number / 1
        number = number % 1
        repeat(count = count, builder = res, "I")
    }
    return res.toString()
}

private fun repeat(count: Int, builder: java.lang.StringBuilder, str: String) {
    for (i in 0 until count) {
        builder.append(str)
    }
}

//1493. Longest Subarray of 1's After Deleting One Element
fun longestSubarray(nums: IntArray): Int {
    var max = 0
    var zeroCount = 0
    var l = 0

    for (r in nums.indices) {
        if (nums[r] == 0) {
            zeroCount++
        }

        while (zeroCount > 1) {
            if (nums[l] == 0) zeroCount--
            l++
        }
        max = max(max, r - l)
    }
    return max
}
