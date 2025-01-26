package mediansidetask

//4. Median of Two Sorted Arrays (should be O(log(m+n)) but mine is O(n+m)
class ArrayBasedSeq(private val arr: IntArray) : SortedSeq {
    private var index = 0

    override fun next(): Int? =
        if (index >= arr.size) null else arr[index++]
}

class NaturalNumbers : SortedSeq {
    private var i = 1

    override fun next(): Int = i++
}

/* Returns SortedSeq from an array */
fun fromSortedArr(a: IntArray): SortedSeq {
    return ArrayBasedSeq(a)
}

class MergedLazySortedSeq(
    private val a: SortedSeq,
    private val b: SortedSeq
) : SortedSeq {

    private var l: Int? = null
    private var r: Int? = null

    override fun next(): Int? {
        if (l == null) l = a.next()
        if (r == null) r = b.next()
        return if (l == null || r != null && r!! <= l!!) {
            val t = r
            r = null
            t
        } else {
            val t = l
            l = null
            t
        }
    }
}

fun merge(a: SortedSeq, b: SortedSeq): SortedSeq {
    return MergedLazySortedSeq(a, b)
}

fun SortedSeq.drop(n: Int) {
    for (i in 1..n) {
        this.next()
    }
}

fun getMedian(a: IntArray, b: IntArray): Double {
    val mergedSeq = merge(fromSortedArr(a), fromSortedArr(b))
    val size = a.size + b.size
    mergedSeq.drop(size / 2 - 1)

    val t1 = mergedSeq.next() ?: throw IllegalStateException("Sequence ended prematurely")
    val t2 = mergedSeq.next() ?: throw IllegalStateException("Sequence ended prematurely")

    return if (size % 2 != 0) t2.toDouble() else (t1 + t2) / 2.0
}