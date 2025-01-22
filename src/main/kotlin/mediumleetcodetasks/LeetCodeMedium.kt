package mediumleetcodetasks

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
