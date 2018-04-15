package com.uitnetwork.pe.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class MathUtilsTest {
    @Test
    fun `sumDivisibleBy() should return error if n is 0 `() {
        assertThatThrownBy {
            MathUtils.sumDivisibleBy(0, 10)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("divisor should be > 0")
    }

    @Test
    fun `sumDivisibleBy() should return error if n is less than 0 `() {
        assertThatThrownBy {
            MathUtils.sumDivisibleBy(-1, 10)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("divisor should be > 0")
    }

    @Test
    fun `sumDivisibleBy() should return error if sumUtil is less than 0 `() {
        assertThatThrownBy {
            MathUtils.sumDivisibleBy(1, -1)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("dividendUntilInclusive should be >= 0")
    }

    @Test
    fun `sumDivisibleBy() should return correct value `() {
        assertThat(MathUtils.sumDivisibleBy(1, 2)).isEqualTo(3)

        assertThat(MathUtils.sumDivisibleBy(2, 7)).isEqualTo(12)

        assertThat(MathUtils.sumDivisibleBy(3, 10)).isEqualTo(18)
    }

    @Test
    fun `sum() should return error if from is less than 0`() {
        assertThatThrownBy {
            MathUtils.sum(-1, 1)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("fromInclusive should be >= 0")
    }

    @Test
    fun `sum() should return error if to is less than 0`() {
        assertThatThrownBy {
            MathUtils.sum(0, -1)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("toInclusive should be >= 0")
    }

    @Test
    fun `sum() should return error if to is less than from`() {
        assertThatThrownBy {
            MathUtils.sum(2, 1)
        }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("toInclusive should be >= fromInclusive")
    }

    @Test
    fun `sum() should return correct value`() {
        assertThat(MathUtils.sum(1, 2)).isEqualTo(3)

        assertThat(MathUtils.sum(1, 5)).isEqualTo(15)

        assertThat(MathUtils.sum(toInclusive = 6)).isEqualTo(21)

        assertThat(MathUtils.sum(10, 11)).isEqualTo(21)
    }
}