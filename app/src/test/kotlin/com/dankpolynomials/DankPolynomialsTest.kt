package com.dankpolynomials

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class DankPolynomialsTest : StringSpec({

    "isPrime should return true for prime numbers" {
        isPrime(2).shouldBeTrue()
        isPrime(997).shouldBeTrue()
        isPrime(7919).shouldBeTrue()
    }

    "isPrime should return false for non-prime numbers" {
        isPrime(1000).shouldBeFalse()
        isPrime(984).shouldBeFalse()
    }

    "isPrime should handle edge cases" {
        isPrime(-100).shouldBeFalse()
        isPrime(-1).shouldBeFalse()
        isPrime(0).shouldBeFalse()
        isPrime(1).shouldBeFalse()
    }

    "getBestPolynomial should return expected result" {
        val result = getBestPolynomial(MIN, MAX, MIN_B, MAX_B)
        println("Best Polynomial: n² + ${result.a}n + ${result.b}, Consecutive Primes: ${result.length}")
        result.length shouldBeGreaterThan 0
    }
})

// Infix extension function for readability
infix fun Int.shouldBeGreaterThan(other: Int) = (this > other).shouldBeTrue()