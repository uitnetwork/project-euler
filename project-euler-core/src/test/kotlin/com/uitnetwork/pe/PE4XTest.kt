package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE4XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 40 - solution 1`() {
        val peResult = peExec.problem40_1()

        assertThat(peResult.result).isEqualTo(210)
    }

    @Test
    fun `problem 40 - solution 2`() {
        val peResult = peExec.problem40_2()

        assertThat(peResult.result).isEqualTo(210)
    }

    @Test
    fun `problem 41`() {
        val peResult = peExec.problem41()

        assertThat(peResult.result).isEqualTo(7652413)
    }

    @Test
    fun `problem 42`() {
        val peResult = peExec.problem42()

        assertThat(peResult.result).isEqualTo(162)
    }

    @Test
    fun `problem 43`() {
        val peResult = peExec.problem43()

        assertThat(peResult.result).isEqualTo(16695334890)
    }

    @Test
    fun `problem 44`() {
        val peResult = peExec.problem44()

        assertThat(peResult.result).isEqualTo(5482660)
    }

    @Test
    fun `problem 45`() {
        val peResult = peExec.problem45()

        assertThat(peResult.result).isEqualTo(1533776805)
    }

    @Test
    fun `problem 46`() {
        val peResult = peExec.problem46()

        assertThat(peResult.result).isEqualTo(5777)
    }

    @Test
    fun `problem 47`() {
        val peResult = peExec.problem47()

        assertThat(peResult.result).isEqualTo(134043)
    }

    @Test
    fun `problem 48`() {
        val peResult = peExec.problem48()

        assertThat(peResult.result).isEqualTo(9110846700)
    }

    @Test
    fun `problem 49`() {
        val peResult = peExec.problem49()

        assertThat(peResult.result).isEqualTo(296962999629)
    }
}
