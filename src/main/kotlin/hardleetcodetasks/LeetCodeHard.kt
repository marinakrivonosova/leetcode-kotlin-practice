package hardleetcodetasks

//4. Median of Two Sorted Arrays (should be O(log(m+n)) but mine is O(n+m)
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val s = Array(nums1.size + nums2.size) { 0 }

    var last = nums1.size + nums2.size - 1
    var n = nums1.size - 1
    var m = nums2.size - 1

    while (n >= 0 && m >= 0) {
        if (nums1[n] > nums2[m]) {
            s[last] = nums1[n]
            n--
        } else {
            s[last] = nums2[m]
            m--
        }
        last--
    }
    while (m >= 0) {
        s[last] = nums2[m]
        m--
        last--
    }

    while (n >= 0) {
        s[last] = nums1[n]
        n--
        last--
    }

    val t = s.size / 2
    return if (s.size % 2 == 0) {
        return (s[t] + s[t - 1]) / 2.0
    } else {
        s[t].toDouble()
    }
}