package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE2XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 20`() {
        val peResult = peExec.problem20()

        assertThat(peResult.result).isEqualTo(648)
    }

    @Test
    fun `problem 21`() {
        val peResult = peExec.problem21()

        assertThat(peResult.result).isEqualTo(31626)
    }

    @Test
    fun `problem 22`() {
        val peResult = peExec.problem22()

        assertThat(peResult.result).isEqualTo(871198282)
    }

    @Test
    fun `problem 23`() {
        val peResult = peExec.problem23()

        assertThat(peResult.result).isEqualTo(4179871)
    }

    @Test
    fun `problem 24`() {
        val peResult = peExec.problem24()

        assertThat(peResult.result).isEqualTo(2783915460)
    }

    @Test
    fun `problem 25`() {
        val peResult = peExec.problem25()

        assertThat(peResult.result).isEqualTo(4782)
    }

    @Test
    fun `problem 26`() {
        val peResult = peExec.problem26()

        assertThat(peResult.result).isEqualTo(983)
    }

    @Test
    fun `problem 27`() {
        val peResult = peExec.problem27()

        assertThat(peResult.result).isEqualTo(-59231)
    }

    @Test
    fun `problem 28`() {
        val peResult = peExec.problem28()

        assertThat(peResult.result).isEqualTo(669171001)
    }

    @Test
    fun `problem 29`() {
        val peResult = peExec.problem29()

        assertThat(peResult.result).isEqualTo(9183)
    }
}
