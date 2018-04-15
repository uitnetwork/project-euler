package com.uitnetwork.pe.util

import org.springframework.util.Assert

object MathUtils {

    fun sumDivisibleBy(divisor: Long, dividendUntilInclusive: Long): Long {
        Assert.isTrue(divisor > 0, "divisor should be > 0")
        Assert.isTrue(dividendUntilInclusive >= 0, "dividendUntilInclusive should be >= 0")

        val quotient = dividendUntilInclusive / divisor
        return divisor * sum(toInclusive = quotient)
    }

    fun sum(fromInclusive: Long = 0, toInclusive: Long): Long {
        Assert.isTrue(fromInclusive >= 0, "fromInclusive should be >= 0")
        Assert.isTrue(toInclusive >= 0, "toInclusive should be >= 0")
        Assert.isTrue(toInclusive >= fromInclusive, "toInclusive should be >= fromInclusive")

        return when {
            fromInclusive == 0L && (toInclusive % 2 == 0L) -> toInclusive / 2 * (toInclusive + 1)
            fromInclusive == 0L -> (toInclusive + 1) / 2 * toInclusive
            else -> sum(toInclusive = toInclusive) - sum(toInclusive = fromInclusive - 1)
        }
    }
}