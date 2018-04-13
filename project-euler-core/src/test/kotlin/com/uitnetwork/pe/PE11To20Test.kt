package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE11To20Test {
    private val peExec = PEExec()

    @Test
    fun `problem 11`() {
        val peResult = peExec.problem11()

        assertThat(peResult.result).isEqualTo(70600674)
    }

    @Test
    fun `problem 12`() {
        val peResult = peExec.problem12()

        assertThat(peResult.result).isEqualTo(76576500)
    }

    @Test
    fun `problem 13`() {
        val peResult = peExec.problem13()

        assertThat(peResult.result).isEqualTo(5537376230)
    }

    @Test
    fun `problem 14`() {
        val peResult = peExec.problem14()

        assertThat(peResult.result).isEqualTo(837799)
    }

    @Test
    fun `problem 15`() {
        val peResult = peExec.problem15()

        assertThat(peResult.result).isEqualTo(137846528820)
    }

    @Test
    fun `problem 16`() {
        val peResult = peExec.problem16()

        assertThat(peResult.result).isEqualTo(1366)
    }

    @Test
    fun `problem 17`() {
        val peResult = peExec.problem17()

        assertThat(peResult.result).isEqualTo(21124)
    }

    @Test
    fun `problem 18`() {
        val peResult = peExec.problem18()

        assertThat(peResult.result).isEqualTo(1074)
    }

    @Test
    fun `problem 19`() {
        val peResult = peExec.problem19()

        assertThat(peResult.result).isEqualTo(171)
    }

    @Test
    fun `problem 20`() {
        val peResult = peExec.problem20()

        assertThat(peResult.result).isEqualTo(648)
    }
}
