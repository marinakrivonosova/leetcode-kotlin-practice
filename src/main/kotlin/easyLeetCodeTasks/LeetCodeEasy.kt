package easyLeetCodeTasks

class LeetCodeEasy {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (result.containsKey(diff)) {
                return intArrayOf(result.getValue(diff), i)
            } else {
                result[nums[i]] = i
            }
        }
        return intArrayOf(0, 0)
    }

    fun isPalindrome(x: Int): Boolean {
        val stringVer = x.toString()
        return if (stringVer[0] != stringVer[stringVer.length - 1]) false
        else {
            var isPal = true
            for (i in 0..stringVer.length / 2) {
                if (stringVer[i] != stringVer[stringVer.length - 1 - i])
                    isPal = false
            }
            return isPal
        }
    }

    fun isPalindromeHalfNumberConverting(x: Int): Boolean {
        var xCopy = x
        if (x < 0 || (x % 10 == 0 && x != 0)) return false
        var reversed = 0

        while (reversed < xCopy) {
            reversed = (reversed * 10) + (xCopy % 10)
            xCopy /= 10
        }

        return xCopy == reversed || xCopy == reversed / 10
    }

    fun isPalindromeReverseString(x: Int): Boolean {
        val stringVer = x.toString()
        val reversed = stringVer.reversed()
        return stringVer == reversed
    }

    fun romanToIntUsingSwitch(s: String): Int {
        var result = 0

        for (i in 0..s.length - 2) {
            result += when (s[i]) {
                'I' -> if (s[i + 1] == 'V' || s[i + 1] == 'X') -1 else 1
                'V' -> 5
                'X' -> if (s[i + 1] == 'L' || s[i + 1] == 'C') -10 else 10
                'L' -> 50
                'C' -> if (s[i + 1] == 'D' || s[i + 1] == 'M') -100 else 100
                'D' -> 500
                'M' -> 1000
                else -> throw IllegalArgumentException("Unexpected char '${s[i]}'")
            }
        }

        when (s[s.length - 1]) {
            'I' -> result += 1
            'V' -> result += 5
            'X' -> result += 10
            'L' -> result += 50
            'C' -> result += 100
            'D' -> result += 500
            'M' -> result += 1000
        }
        return result
    }

    fun romanToInt(s: String): Int {
        var result = 0
        val dictionary = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        for (i in 0 until s.lastIndex) {
            if ((dictionary[s[i]] ?: 0) < (dictionary[s[i + 1]] ?: 0)) result -= dictionary[s[i]] ?: 0
            else result += dictionary[s[i]] ?: throw IllegalArgumentException("Unexpected char '${s[i]}'")

        }
        return result + (dictionary[s.last()] ?: 0)
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val firstWord = strs[0]
        for (i in firstWord.indices) {
            for (s in strs) {
                if (s.length == i || s[i] != firstWord[i]) return firstWord.substring(0, i)
            }
        }
        return firstWord
    }

    fun isValidParentheses(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val pair = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
        for (el in s) {
            if (pair.containsKey(el)) {
                stack.addLast(el)
            } else if (stack.isEmpty()
                || el != pair.getOrDefault(stack.removeLast(), "")
            )
                return false
        }
        return stack.isEmpty()
    }

    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` < list2.`val`) {
            ListNode(list1.`val`, mergeTwoLists(list1.next, list2))
        } else {
            ListNode(list2.`val`, mergeTwoLists(list2.next, list1))
        }
    }

    fun mergeTwoListsNoRecursion(list1: ListNode?, list2: ListNode?): ListNode? {
        var p1 = list1
        var p2 = list2
        var result: ListNode? = null
        var lastElement: ListNode? = null

        fun append(node: ListNode?) {
            if (lastElement == null) {
                lastElement = node
                result = lastElement
            } else {
                lastElement!!.next = node
                lastElement = lastElement!!.next
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                append(ListNode(p1.`val`))
                p1 = p1.next
            } else {
                append(ListNode(p2.`val`))
                p2 = p2.next
            }
        }

        append(p1 ?: p2)

        return result
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var k = 1
        for (i in 1..nums.lastIndex) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]
                k++
            }
        }

        return k
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        var k = 0
        for (x in nums) {
            if (x != `val`) {
                nums[k] = x
                k++
            }
        }
        return k
    }


    //28. Find the Index of the First Occurrence in a String
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }

    //28. Find the Index of the First Occurrence in a String
    fun strStrWithoutBuildInFunction(haystack: String, needle: String): Int {
        val needleLength = needle.length
        val haystackLength = haystack.length
        if (haystackLength < needleLength) return -1
        if (needle.isEmpty() || haystack == needle) return 0

        val end = haystackLength - needleLength

        for (i in 0..end) {
            if (haystack.substring(i, needleLength + i) == needle) {
                return i
            }
        }
        return -1
    }

    // 35. Search Insert Position
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val middle = (end + start) / 2
            if (nums[middle] > target)
                end = middle - 1
            else if (nums[middle] < target)
                start = middle + 1
            else return middle
        }
        return start
    }

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
            if (nums[middle] == target) {
                return middle
            } else if (nums[middle] < target) {
                return binarySearchRecursion(nums, target, middle + 1, end)
            } else return binarySearchRecursion(nums, target, start, middle - 1)
        }
        return -1
    }

    fun lengthOfLastWord(s: String): Int {
        return s.split(' ').last { it.isNotEmpty() }.length
    }
}