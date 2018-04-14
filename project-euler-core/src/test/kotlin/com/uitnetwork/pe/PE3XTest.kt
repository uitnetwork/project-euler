package com.uitnetwork.pe

import com.projecteuler.core.PEExec
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PE3XTest {
    private val peExec = PEExec()

    @Test
    fun `problem 30`() {
        val peResult = peExec.problem30()

        assertThat(peResult.result).isEqualTo(443839)
    }

    @Test
    fun `problem 31`() {
        val peResult = peExec.problem31()

        assertThat(peResult.result).isEqualTo(73682)
    }

    @Test
    fun `problem 32`() {
        val peResult = peExec.problem32()

        assertThat(peResult.result).isEqualTo(45228)
    }

    @Test
    fun `problem 33`() {
        val peResult = peExec.problem33()

        assertThat(peResult.result).isEqualTo(100)
    }

    @Test
    fun `problem 34`() {
        val peResult = peExec.problem34()

        assertThat(peResult.result).isEqualTo(40730)
    }

    @Test
    fun `problem 35`() {
        val peResult = peExec.problem35()

        assertThat(peResult.result).isEqualTo(55)
    }

    @Test
    fun `problem 36`() {
        val peResult = peExec.problem36()

        assertThat(peResult.result).isEqualTo(872187)
    }

    @Test
    fun `problem 37`() {
        val peResult = peExec.problem37()

        assertThat(peResult.result).isEqualTo(748317)
    }

    @Test
    fun `problem 38`() {
        val peResult = peExec.problem38()

        assertThat(peResult.result).isEqualTo(932718654)
    }

    @Test
    fun `problem 39`() {
        val peResult = peExec.problem39()

        assertThat(peResult.result).isEqualTo(840)
    }
}
