package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE5XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 50`() {
        val peResult = peExec.problem50()

        assertThat(peResult.result).isEqualTo(997651)
    }

    @Test
    fun `problem 51`() {
        val peResult = peExec.problem51()

        assertThat(peResult.result).isEqualTo(121313)
    }

    @Test
    fun `problem 52`() {
        val peResult = peExec.problem52()

        assertThat(peResult.result).isEqualTo(142857)
    }

    @Test
    fun `problem 53`() {
        val peResult = peExec.problem53()

        assertThat(peResult.result).isEqualTo(4075)
    }

    @Test
    fun `problem 54`() {
        val peResult = peExec.problem54()

        assertThat(peResult.result).isEqualTo(376)
    }

    @Test
    fun `problem 55`() {
        val peResult = peExec.problem55()

        assertThat(peResult.result).isEqualTo(249)
    }

    @Test
    fun `problem 56`() {
        val peResult = peExec.problem56()

        assertThat(peResult.result).isEqualTo(972)
    }

    @Test
    fun `problem 57`() {
        val peResult = peExec.problem57()

        assertThat(peResult.result).isEqualTo(153)
    }

    @Test
    fun `problem 58`() {
        val peResult = peExec.problem58()

        assertThat(peResult.result).isEqualTo(26241)
    }

    @Test
    fun `problem 59`() {
        val peResult = peExec.problem59()

        assertThat(peResult.result).isEqualTo(107359)
    }
}
