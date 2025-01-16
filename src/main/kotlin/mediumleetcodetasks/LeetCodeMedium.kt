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
