package com.uitnetwork.pe.solution

import com.uitnetwork.pe.util.MathUtils

object PESolution0X {
    fun problem1(): Long {
        val dividendUntilInclusive = 999L
        val sumDivisibleBy3 = MathUtils.sumDivisibleBy(3, dividendUntilInclusive)
        val sumDivisibleBy5 = MathUtils.sumDivisibleBy(5, dividendUntilInclusive)
        val sumDivisibleBy15 = MathUtils.sumDivisibleBy(15, dividendUntilInclusive)

        return sumDivisibleBy3 + sumDivisibleBy5 - sumDivisibleBy15
    }
}