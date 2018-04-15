package com.uitnetwork.pe.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PESolution0XTest : AbstractPESolutionTest() {
    @Test()
    fun `problem1() - Find the sum of all the multiples of 3 or 5 below 1000`() {
        assertThat(PESolution0X.problem1()).isEqualTo(233168)
    }
}