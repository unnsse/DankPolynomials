package com.dankpolynomials

fun main() {
    val result = getBestPolynomial(MIN, MAX, MIN_B, MAX_B)
    println("Best Polynomial: n² + ${result.a}n + ${result.b}, Consecutive Primes: ${result.length}")
}