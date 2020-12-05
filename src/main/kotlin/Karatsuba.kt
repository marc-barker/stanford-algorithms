import kotlin.math.pow

fun main() {
    // fails because internal multiply() calls contain numbers with an odd number of digits
    println(multiply(5678,1234))
    println(5678*1234)
    // succeeds because internal variables all have an even number of digits
    println(multiply(11, 11))
    println(11*11)
}

fun multiply(int1: Int, int2: Int): Int {
    val n: Int = int1.toString().length
    if (n == 1) {
        return int1 * int2
    }

    val denominator: Int = powerOfTen(n / 2)

    val a: Int = int1 / denominator
    val b: Int = int1 % denominator
    val c: Int = int2 / denominator
    val d: Int = int2 % denominator

    val p: Int = a + b
    val q: Int = c + d

    val ac: Int = multiply(a, c)
    val bd: Int = multiply(b, d)
    val pq: Int = multiply(p, q)
    val adbc: Int = pq - ac - bd

    return powerOfTen(n) * ac + denominator*adbc + bd
}

fun powerOfTen(exponent: Int): Int {
    return 10.toDouble().pow(exponent).toInt()
}
