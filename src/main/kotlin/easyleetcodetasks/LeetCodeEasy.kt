package easyleetcodetasks

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.set
import kotlin.math.abs
import kotlin.math.max

// 1. Two Sum
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

//9. Palindrome Number
fun isPalindrome(x: Int): Boolean {
    val stringVer = x.toString()
    return if (stringVer[0] != stringVer[stringVer.length - 1]) false
    else {
        var isPal = true
        for (i in 0..stringVer.length / 2) {
            if (stringVer[i] != stringVer[stringVer.length - 1 - i]) isPal = false
        }
        return isPal
    }
}

//9. Palindrome Number
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

//9. Palindrome Number
fun isPalindromeReverseString(x: Int): Boolean {
    val stringVer = x.toString()
    val reversed = stringVer.reversed()
    return stringVer == reversed
}

//13. Roman to Integer
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

//13. Roman to Integer
fun romanToInt(s: String): Int {
    var result = 0
    val dictionary = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
    )

    for (i in 0 until s.lastIndex) {
        if ((dictionary[s[i]] ?: 0) < (dictionary[s[i + 1]] ?: 0)) result -= dictionary[s[i]] ?: 0
        else result += dictionary[s[i]] ?: throw IllegalArgumentException("Unexpected char '${s[i]}'")

    }
    return result + (dictionary[s.last()] ?: 0)
}

//14. Longest Common Prefix
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

//20. Valid Parentheses
fun isValidParentheses(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pair = mapOf(
        '(' to ')', '{' to '}', '[' to ']'
    )
    for (el in s) {
        if (pair.containsKey(el)) {
            stack.addLast(el)
        } else if (stack.isEmpty() || el != pair.getOrDefault(stack.removeLast(), "")) return false
    }
    return stack.isEmpty()
}

data class ListNode(var `val`: Int, var next: ListNode? = null)

//21. Merge Two Sorted Lists
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` < list2.`val`) {
        ListNode(list1.`val`, mergeTwoLists(list1.next, list2))
    } else {
        ListNode(list2.`val`, mergeTwoLists(list2.next, list1))
    }
}

//21. Merge Two Sorted Lists
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

//26. Remove Duplicates from Sorted Array
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

//27. Remove Element
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
        if (nums[middle] > target) end = middle - 1
        else if (nums[middle] < target) start = middle + 1
        else return middle
    }
    return start
}

//58. Length of Last Word
fun lengthOfLastWord(s: String): Int {
    return s.split(' ').last { it.isNotEmpty() }.length
}

//66. Plus One
fun plusOne(digits: IntArray): IntArray {
    val n = digits.size
    for (i in n - 1 downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    val array = IntArray(n + 1) { 0 }
    array[0] = 1
    return array
}

//67. Add Binary
fun addBinary(a: String, b: String): String {
    val aReversed = a.reversed()
    val bReversed = b.reversed()
    var carry = 0
    val res = StringBuilder()

    val max = max(a.length, b.length)

    for (i in 0 until max) {
        val digA = if (i < a.length) aReversed[i] - '0' else 0
        val digB = if (i < b.length) bReversed[i] - '0' else 0
        val total = digA + digB + carry
        res.append(total % 2)
        carry = total / 2
    }

    if (carry != 0) res.append(1)
    return res.reversed().toString()
}

//69. Sqrt of x
fun mySqrt(x: Int): Int {
    if (x == 0) return 0
    if (x == 1) return 1
    var start = 0
    var end = x

    while (start <= end) {
        val middle = start + (end - start) / 2
        if (middle < x / middle) start = middle + 1
        else if (middle > x / middle) end = middle - 1
        else return middle
    }
    return end
}

//70. Climbing Stairs
fun climbStairsRecursion(n: Int): Int {
    if (n < 2) return 1
    return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2)
}

//70. Climbing Stairs
fun climbStairsNoRecursion(n: Int): Int {
    var prev = 0
    var curr = 1
    for (i in 1..n) {
        val t = curr
        curr += prev
        prev = t
    }
    return curr
}

//83. Remove Duplicates from Sorted List
fun deleteDuplicates(head: ListNode?): ListNode? {
    var curr = head

    while (curr?.next != null) {
        if (curr.`val` == curr.next!!.`val`) {
            curr.next = curr.next!!.next
        } else {
            curr = curr.next
        }
    }
    return head
}

//88. Merge Sorted Array
fun mergeSortedArrays(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    if (m == 0) nums1[0] = nums2[0]
    var last = m + n - 1
    var mCopy = m - 1
    var nCopy = n - 1

    while (mCopy >= 0 && nCopy >= 0) {
        if (nums1[mCopy] > nums2[nCopy]) {
            nums1[last] = nums1[mCopy]
            mCopy--
        } else {
            nums1[last] = nums2[nCopy]
            nCopy--
        }
        last--
    }

    while (nCopy >= 0) {
        nums1[last] = nums2[nCopy]
        nCopy--
        last--
    }
}

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

//94. Binary Tree Inorder Traversal
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        result.add(root.`val`)
        inorder(root.right)
    }

    inorder(root)
    return result
}

fun inorderTraversalIterative(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var curr = root

    while (curr != null || stack.isNotEmpty()) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.pop()
        result.add(curr.`val`)
        curr = curr.right
    }
    return result
}

//100. Same Tree
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return (p == null && q == null) ||
            (p != null &&
                    q != null &&
                    q.`val` == p.`val` &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right))
}

//101. Symmetric Tree
fun isSymmetricTree(root: TreeNode?): Boolean {
    return root == null || isSymmetricTree(root.left, root.right)
}

fun isSymmetricTree(left: TreeNode?, right: TreeNode?): Boolean {
    return left == null && right == null ||
            left != null &&
            right != null &&
            left.`val` == right.`val` &&
            isSymmetricTree(left.left, right.right) &&
            isSymmetricTree(left.right, right.left)
}

//104. Maximum Depth of Binary Tree
fun maxDepth(root: TreeNode?): Int {
    return findHeight(root)
}

private fun findHeight(root: TreeNode?): Int {
    if (root == null) return 0
    val left = findHeight(root.left)
    val right = findHeight(root.right)
    return 1 + Math.max(left, right)
}

//108. Convert Sorted Array to Binary Search Tree
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return build(nums, 0, nums.size - 1)
}

private fun build(nums: IntArray, l: Int, r: Int): TreeNode? {
    val mid = (r + l) / 2

    if (l > r) return null;
    return TreeNode(
        `val` = nums[mid],
        left = build(nums, l, mid - 1),
        right = build(nums, mid + 1, r)
    )
}

//110. Balanced Binary Tree
fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    return abs(height(root.left) - height(root.right)) < 2 &&
            isBalanced(root.left) &&
            isBalanced(root.right)

}

private fun height(root: TreeNode?): Int {
    if (root == null) return 0
    val left = height(root.left)
    val right = height(root.right)
    return 1 + Math.max(left, right)
}

/**
 * Check that tree with a root in [node] is balanced and also returns height of that tree
 */
fun checkBalance(node: TreeNode?): Pair<Boolean, Int> = node?.let {
    val (balancedL, heightL) = checkBalance(it.left)
    val (balancedR, heightR) = checkBalance(it.right)
    (balancedL && balancedR && abs(heightL - heightR) <= 1) to (1 + max(heightL, heightR))
} ?: (true to 0)


//111. Minimum Depth of Binary Tree
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = minDepth(root.left)
    val right = minDepth(root.right)

    if (left == 0) return right + 1
    if (right == 0) return left + 1
    return 1 + Math.min(left, right)
}

//112. Path Sum
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    if (root.left == null && root.right == null) return targetSum == root.`val`
    return hasPathSum(root.right, targetSum - root.`val`)
            || hasPathSum(root.left, targetSum - root.`val`)

}
