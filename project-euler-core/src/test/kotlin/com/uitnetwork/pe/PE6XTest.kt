package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE6XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 60`() {
        val peResult = peExec.problem60()

        assertThat(peResult.result).isEqualTo(26033)
    }

    @Test
    fun `problem 61`() {
        val peResult = peExec.problem61()

        assertThat(peResult.result).isEqualTo(28684)
    }

    @Test
    fun `problem 62`() {
        val peResult = peExec.problem62()

        assertThat(peResult.result).isEqualTo(127035954683)
    }

    @Test
    fun `problem 63`() {
        val peResult = peExec.problem63()

        assertThat(peResult.result).isEqualTo(49)
    }
}
