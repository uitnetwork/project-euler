package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE0XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 2 - solution 1`() {
        val peResult = peExec.problem2_1()

        assertThat(peResult.result).isEqualTo(4613732)
    }

    @Test
    fun `problem 2 - solution 2`() {
        val peResult = peExec.problem2_2()

        assertThat(peResult.result).isEqualTo(4613732)
    }

    @Test
    fun `problem 3`() {
        val peResult = peExec.problem3()

        assertThat(peResult.result).isEqualTo(6857)
    }

    @Test
    fun `problem 4`() {
        val peResult = peExec.problem4()

        assertThat(peResult.result).isEqualTo(906609)
    }

    @Test
    fun `problem 5 - solution 1`() {
        val peResult = peExec.problem5_1()

        assertThat(peResult.result).isEqualTo(232792560)
    }

    @Test
    fun `problem 5 - solution 2`() {
        val peResult = peExec.problem5_2()

        assertThat(peResult.result).isEqualTo(232792560)
    }

    @Test
    fun `problem 6`() {
        val peResult = peExec.problem6()

        assertThat(peResult.result).isEqualTo(25164150)
    }

    @Test
    fun `problem 7`() {
        val peResult = peExec.problem7()

        assertThat(peResult.result).isEqualTo(104743)
    }

    @Test
    fun `problem 8`() {
        val peResult = peExec.problem8()

        assertThat(peResult.result).isEqualTo(23514624000)
    }

    @Test
    fun `problem 9`() {
        val peResult = peExec.problem9()

        assertThat(peResult.result).isEqualTo(31875000)
    }
}
