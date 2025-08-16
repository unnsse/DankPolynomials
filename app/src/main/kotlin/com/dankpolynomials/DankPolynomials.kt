package com.dankpolynomials

import kotlin.math.sqrt

const val MIN = -999
const val MAX = 999
const val MIN_B = -1000
const val MAX_B = 1000

data class PolynomialResult(val a: Int, val b: Int, val length: Int)

fun getBestPolynomial(minA: Int, maxA: Int, minB: Int, maxB: Int): PolynomialResult {
    val possibleBValues = (minB..maxB).filter(::isPrime)

    return (minA..maxA).asSequence().flatMap { a ->
        possibleBValues.asSequence().map { b ->
            val length = generateSequence(0) { it + 1 }
                .map { n -> n * n + a * n + b }
                .takeWhile(::isPrime)
                .count()
            PolynomialResult(a, b, length)
        }
    }.maxByOrNull { it.length } ?: PolynomialResult(0, 0, 0)
}

fun isPrime(n: Int): Boolean = when {
    n < 2 -> false
    n == 2 -> true
    n % 2 == 0 -> false
    else -> (3..sqrt(n.toDouble()).toInt() step 2).none { n % it == 0 }
}