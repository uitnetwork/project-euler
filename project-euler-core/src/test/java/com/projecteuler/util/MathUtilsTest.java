package com.projecteuler.util;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void testSumToN() {
        assertEquals("Should be 0", 0, MathUtils.sumToN(0));
        assertEquals("Should be 1", 1, MathUtils.sumToN(1));
        assertEquals("Should be 55", 55, MathUtils.sumToN(10));
        assertEquals("Should be 5050", 5050, MathUtils.sumToN(100));
    }

    @Test
    public void testSumSquaresToN() {
        assertEquals("Should be 385", 385, MathUtils.sumSquaresToN(10));
        assertEquals("Should be 55", 55, MathUtils.sumSquaresToN(5));
        assertEquals("Should be 14", 14, MathUtils.sumSquaresToN(3));
        assertEquals("Should be 9455", 9455, MathUtils.sumSquaresToN(30));
    }

    @Test
    public void testGetLargestPrimeFactor() {
        assertEquals("Should be 2", 2, MathUtils.getLargestPrimeFactor(2));
        assertEquals("Should be 3", 3, MathUtils.getLargestPrimeFactor(3));
        assertEquals("Should be 5", 5, MathUtils.getLargestPrimeFactor(15));
        assertEquals("Should be 17", 17, MathUtils.getLargestPrimeFactor(17));
    }

    @Test
    public void testIsPalindromeNumber() {
        assertTrue("Should be true", MathUtils.isPalindromeNumber(3));
        assertTrue("Should be true", MathUtils.isPalindromeNumber(123321));
        assertTrue("Should be true", MathUtils.isPalindromeNumber(12321));
        assertFalse("Should be false", MathUtils.isPalindromeNumber(12345));
    }

    @Test
    public void testIsPalindromeBigInteger() {
        assertTrue("Should be true",
                MathUtils.isPalindromeBiginteger(new BigInteger("3")));
        assertTrue("Should be true",
                MathUtils.isPalindromeBiginteger(new BigInteger("123321")));
        assertTrue("Should be true",
                MathUtils.isPalindromeBiginteger(new BigInteger("12321")));
        assertFalse("Should be true",
                MathUtils.isPalindromeBiginteger(new BigInteger("12345")));
    }

    @Test
    public void testIsPalindromeNumberInBase() {
        // base 10
        assertTrue("Should be true", MathUtils.isPalindromeNumberInBase(3, 10));
        assertTrue("Should be true",
                MathUtils.isPalindromeNumberInBase(123321, 10));
        assertTrue("Should be true",
                MathUtils.isPalindromeNumberInBase(12321, 10));
        assertFalse("Should be false",
                MathUtils.isPalindromeNumberInBase(12345, 10));

        // base 2
        assertTrue("Should be true", MathUtils.isPalindromeNumberInBase(9, 2));
        assertFalse("Should be false", MathUtils.isPalindromeNumberInBase(10, 2));

    }

    @Test
    public void testReverseNumber() {
        assertEquals("Should be 54321", 54321, MathUtils.reverseNumber(12345));
        assertEquals("Should be 321", 321, MathUtils.reverseNumber(123));
        assertEquals("Should be 1", 1, MathUtils.reverseNumber(10));
        assertEquals("Should be 8", 8, MathUtils.reverseNumber(8));
    }

    @Test
    public void testReverseBigInteger() {
        assertEquals("Should be 54321", new BigInteger("54321"),
                MathUtils.reverseBigInteger(new BigInteger("12345")));
        assertEquals("Should be 321", new BigInteger("321"),
                MathUtils.reverseBigInteger(new BigInteger("123")));
        assertEquals("Should be 1", new BigInteger("1"),
                MathUtils.reverseBigInteger(new BigInteger("10")));
        assertEquals("Should be 8", new BigInteger("8"),
                MathUtils.reverseBigInteger(new BigInteger("8")));
    }

    @Test
    public void testGcd() {
        assertEquals("Should be 111", 111, MathUtils.gcd(111, 333));
        assertEquals("Should be 5", 5, MathUtils.gcd(15, 25));
        assertEquals("Should be 9", 9, MathUtils.gcd(99, 27));
        assertEquals("Should be 20", 20, MathUtils.gcd(60, 100));
    }

    @Test
    public void testLcd() {
        assertEquals("Should be 77", 77, MathUtils.lcd(7, 11));
        assertEquals("Should be 30", 30, MathUtils.lcd(10, 15));
        assertEquals("Should be 630", 630, MathUtils.lcd(90, 7));
        assertEquals("Should be 22", 22, MathUtils.lcd(22, 11));
    }

    @Test
    public void testLcdToN() {
        assertEquals("Should be 420", 420, MathUtils.lcdToN(7));
        assertEquals("Should be 2520", 2520, MathUtils.lcdToN(10));
        assertEquals("Should be 60", 60, MathUtils.lcdToN(5));
        assertEquals("Should be 6", 6, MathUtils.lcdToN(3));
    }

    @Test
    public void testLcdToNUsingPrime() {
        assertEquals("Should be 420", 420, MathUtils.lcdToNUsingPrime(7));
        assertEquals("Should be 2520", 2520, MathUtils.lcdToNUsingPrime(10));
        assertEquals("Should be 60", 60, MathUtils.lcdToNUsingPrime(5));
        assertEquals("Should be 6", 6, MathUtils.lcdToNUsingPrime(3));
    }

    @Test
    public void testCountNumberOfDivisors() {
        assertEquals("Should be 4", 4, MathUtils.countNumberOfDivisors(6));
        assertEquals("Should be 8", 8, MathUtils.countNumberOfDivisors(30));
        assertEquals("Should be 12", 12, MathUtils.countNumberOfDivisors(90));
        assertEquals("Should be 9", 9, MathUtils.countNumberOfDivisors(100));
    }

    @Test
    public void testGetAllDivisors() {
        long[] expectFor220 = {1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110, 220};
        long[] expectFor500 = {1, 2, 4, 5, 10, 20, 25, 50, 100, 125, 250, 500};
        long[] expectFor50 = {1, 2, 5, 10, 25, 50};
        long[] expectFor80 = {1, 2, 4, 5, 8, 10, 16, 20, 40, 80};

        assertArrayEquals("Wrong divisors", expectFor220,
                MathUtils.getAllDivisors(220));
        assertArrayEquals("Wrong divisors", expectFor500,
                MathUtils.getAllDivisors(500));
        assertArrayEquals("Wrong divisors", expectFor50,
                MathUtils.getAllDivisors(50));
        assertArrayEquals("Wrong divisors", expectFor80,
                MathUtils.getAllDivisors(80));
    }

    @Test
    public void testGetProperDivisors() {
        long[] expectFor220 = {1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110};
        long[] expectFor500 = {1, 2, 4, 5, 10, 20, 25, 50, 100, 125, 250};
        long[] expectFor50 = {1, 2, 5, 10, 25};
        long[] expectFor80 = {1, 2, 4, 5, 8, 10, 16, 20, 40};

        assertArrayEquals("Wrong divisors", expectFor220,
                MathUtils.getProperDivisors(220));
        assertArrayEquals("Wrong divisors", expectFor500,
                MathUtils.getProperDivisors(500));
        assertArrayEquals("Wrong divisors", expectFor50,
                MathUtils.getProperDivisors(50));
        assertArrayEquals("Wrong divisors", expectFor80,
                MathUtils.getProperDivisors(80));
    }

    @Test
    public void testGetSumOfProperDivisors() {
        assertEquals("Should be 284", 284, MathUtils.getSumOfProperDivisors(220));
        assertEquals("Should be 43", 43, MathUtils.getSumOfProperDivisors(50));
        assertEquals("Should be 592", 592, MathUtils.getSumOfProperDivisors(500));
        assertEquals("Should be 106", 106, MathUtils.getSumOfProperDivisors(80));
    }

    @Test
    public void testGetFactorialBigInteger() {
        assertEquals("Should be 3628800", new BigInteger("3628800"),
                MathUtils.getFactorialBigInteger(10));

        assertEquals("Should be 120", new BigInteger("120"),
                MathUtils.getFactorialBigInteger(5));

        assertEquals("Should be 40320", new BigInteger("40320"),
                MathUtils.getFactorialBigInteger(8));

        assertEquals("Should be 6227020800", new BigInteger("6227020800"),
                MathUtils.getFactorialBigInteger(13));

    }

    @Test
    public void testGetFactorial() {
        assertEquals("Should be 3628800", 3628800, MathUtils.getFactorial(10));
        assertEquals("Should be 120", 120, MathUtils.getFactorial(5));
        assertEquals("Should be 40320", 40320, MathUtils.getFactorial(8));
        assertEquals("Should be 6227020800", 6227020800l,
                MathUtils.getFactorial(13));
    }

    @Test
    public void testGetAlphabeticalValue() {
        assertEquals("Should be 6", 6, MathUtils.getAlphabeticalValue("ABC"));
        assertEquals("Should be 75", 75, MathUtils.getAlphabeticalValue("XYZ"));
        assertEquals("Should be 33", 33, MathUtils.getAlphabeticalValue("KJL"));
        assertEquals("Should be 39", 39, MathUtils.getAlphabeticalValue("NML"));
    }

    @Test
    public void testIsAbundantNumber() {
        assertTrue("Should be true", MathUtils.isAbundantNumber(30));
        assertTrue("Should be true", MathUtils.isAbundantNumber(104));
        assertFalse("Should be false", MathUtils.isAbundantNumber(49));
        assertFalse("Should be false", MathUtils.isAbundantNumber(79));
    }

    @Test
    public void testGetRecurringCycleDecimalOfN() {
        assertEquals("Should be 1", 1,
                MathUtils.getNumberOfRecurringDigitsInDecimalFractionPart(6));
        assertEquals("Should be 6", 6,
                MathUtils.getNumberOfRecurringDigitsInDecimalFractionPart(7));
        assertEquals("Should be 0", 0,
                MathUtils.getNumberOfRecurringDigitsInDecimalFractionPart(2));
        assertEquals("Should be 1", 1,
                MathUtils.getNumberOfRecurringDigitsInDecimalFractionPart(3));
    }

    @Test
    public void testIsPandigitalNumber() {
        assertTrue("Should be true", MathUtils.isPandigitalNumber(123456789));
        assertTrue("Should be true", MathUtils.isPandigitalNumber(12345));
        assertTrue("Should be true", MathUtils.isPandigitalNumber(321));
        assertTrue("Should be true", MathUtils.isPandigitalNumber(123));
        assertTrue("Should be true", MathUtils.isPandigitalNumber(1234567));
        assertTrue("Should be true", MathUtils.isPandigitalNumber(12345678));

        assertFalse("Should be false", MathUtils.isPandigitalNumber(123567));
        assertFalse("Should be false", MathUtils.isPandigitalNumber(1235678));
        assertFalse("Should be false", MathUtils.isPandigitalNumber(23456789));
        assertFalse("Should be false", MathUtils.isPandigitalNumber(12345689));
        assertFalse("Should be false", MathUtils.isPandigitalNumber(1023456789));

    }

    @Test
    public void testIsPandigitalNumberIncludeZero() {
        assertTrue("Should be true",
                MathUtils.isPandigitalNumberIncludeZero(1023456789));
        assertTrue("Should be true",
                MathUtils.isPandigitalNumberIncludeZero(1234567890));

        assertFalse("Should be false",
                MathUtils.isPandigitalNumberIncludeZero(1023456788));
        assertFalse("Should be false",
                MathUtils.isPandigitalNumberIncludeZero(1023456778));

    }

    @Test
    public void testGetListOfPandigitalNumbersIncludeZero() {
        // fail("Not yet implemented");
    }

    @Test
    public void testGetListOfPandigitalNumbers() {
        // fail("Not yet implemented");
    }

    @Test
    public void testGetProductOfPandigital() {
        // fail("Not yet implemented");
    }

    @Test
    public void testHasEvenDigit() {
        assertTrue("Should be true", MathUtils.hasEvenDigit(12345));
        assertTrue("Should be true", MathUtils.hasEvenDigit(135798));
        assertTrue("Should be true", MathUtils.hasEvenDigit(127953));

        assertFalse("Should be false", MathUtils.hasEvenDigit(13));
        assertFalse("Should be false", MathUtils.hasEvenDigit(531));
        assertFalse("Should be false", MathUtils.hasEvenDigit(3579));

    }

    @Test
    public void testGetAllPermutationsOfNumber() {
        // fail("Not yet implemented");
    }

    @Test
    public void testGetCircularNumbers() {
        // fail("Not yet implemented");
    }

    @Test
    public void testIsTruncatable() {
        assertTrue("", MathUtils.isTruncatablePrime(3797));
        assertTrue("", MathUtils.isTruncatablePrime(739397));
        assertTrue("", MathUtils.isTruncatablePrime(3137));
        assertTrue("", MathUtils.isTruncatablePrime(313));

        assertFalse("", MathUtils.isTruncatablePrime(347));
        assertFalse("", MathUtils.isTruncatablePrime(397));
        assertFalse("", MathUtils.isTruncatablePrime(37397));
        assertFalse("", MathUtils.isTruncatablePrime(7393931));
    }

    @Test
    public void testIsPentagonalNumber() {
        // fail("Not yet implemented");
    }

    @Test
    public void testIsHexagonalNumber() {
        // fail("Not yet implemented");
    }

    @Test
    public void testSameDigits6Times() {
        // fail("Not yet implemented");
    }

    @Test
    public void testGetExponent() {
        assertEquals("Should be 2", 2, MathUtils.getExponentOf10(100));
        assertEquals("Should be 1", 1, MathUtils.getExponentOf10(99));
        assertEquals("Should be 2", 2, MathUtils.getExponentOf10(999));
        assertEquals("Should be 3", 3, MathUtils.getExponentOf10(1000));
    }

    @Test
    public void testIsCombinationGreaterThan() {
        // fail("Not yet implemented");
    }

    @Test
    public void testGetDigitalSum() {
        assertEquals("Should be 15", 15,
                MathUtils.getDigitalSum(new BigInteger("12345")));
        assertEquals("Should be 20", 20,
                MathUtils.getDigitalSum(new BigInteger("123455")));
        assertEquals("Should be 27", 27,
                MathUtils.getDigitalSum(new BigInteger("1234557")));
        assertEquals("Should be 36", 36,
                MathUtils.getDigitalSum(new BigInteger("12345579")));
    }

    @Test
    public void testCompareNumberOfDigits() {
        assertEquals("Should be -1", -1, MathUtils.compareNumberOfDigits(
                new BigInteger("12345"), new BigInteger("123456")));
        assertEquals("Should be 6", 6, MathUtils.compareNumberOfDigits(
                new BigInteger("123456789"), new BigInteger("123")));
        assertEquals("Should be 3", 3, MathUtils.compareNumberOfDigits(
                new BigInteger("123456"), new BigInteger("123")));
        assertEquals("Should be 2", 2, MathUtils.compareNumberOfDigits(
                new BigInteger("9876"), new BigInteger("22")));

    }

}
