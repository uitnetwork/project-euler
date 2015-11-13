package com.projecteuler.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import org.junit.Test;

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
   public void testGetSmallestCommonMultipleFrom1ToN() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetSmallestCommonMultipleOf2Number() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetGreatestCommonDivisor() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetSmallestCommonMultipleFrom1ToN_2() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetPrimeNumberListBelowMax() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetPrimeNumberArrayBelowMax() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetPrimeNumbersToNth() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPrime() {
      fail("Not yet implemented");
   }

   @Test
   public void testSumSquareZeroToN() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetNthPrimeNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testSumPrimeNumbersBelow() {
      fail("Not yet implemented");
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
      long[] expectFor220 = { 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110, 220 };
      long[] expectFor500 = { 1, 2, 4, 5, 10, 20, 25, 50, 100, 125, 250, 500 };
      long[] expectFor50 = { 1, 2, 5, 10, 25, 50 };
      long[] expectFor80 = { 1, 2, 4, 5, 8, 10, 16, 20, 40, 80 };

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
      long[] expectFor220 = { 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 };
      long[] expectFor500 = { 1, 2, 4, 5, 10, 20, 25, 50, 100, 125, 250 };
      long[] expectFor50 = { 1, 2, 5, 10, 25 };
      long[] expectFor80 = { 1, 2, 4, 5, 8, 10, 16, 20, 40 };

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
   public void testGetBigIntegerFactorial() {
      assertEquals("Should be 3628800", new BigInteger("3628800"),
            MathUtils.getBigIntegerFactorial(10));

      assertEquals("Should be 120", new BigInteger("120"),
            MathUtils.getBigIntegerFactorial(5));

      assertEquals("Should be 40320", new BigInteger("40320"),
            MathUtils.getBigIntegerFactorial(8));

      assertEquals("Should be 6227020800", new BigInteger("6227020800"),
            MathUtils.getBigIntegerFactorial(13));

   }

   @Test
   public void testGetPermutationOfNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetAlphabeticalvalue() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsAbundantNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetRecurringCycleDecimalOfN() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetConsecutivePrimesOfNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testCalculatePossibleCoins() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPandigitalNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPandigitalNumber2() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPandigitalNumberIncludeZero() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetListOfPandigitalNumbersIncludeZero() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetListOfPandigitalNumbers() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetProductOfPandigital() {
      fail("Not yet implemented");
   }

   @Test
   public void testSumOfNumberHasEqualFactorialOFDigits() {
      fail("Not yet implemented");
   }

   @Test
   public void testContainEvenDigit() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetAllPermutationsOfNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetCircularNumbers() {
      fail("Not yet implemented");
   }

   @Test
   public void testCreatePalindrome() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsTruncatable() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPentagonalNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsHexagonalNumber() {
      fail("Not yet implemented");
   }

   @Test
   public void testSameDigits6Times() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetPower() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsCombinationGreaterThan() {
      fail("Not yet implemented");
   }

   @Test
   public void testIsPalindromeNumberBigInteger() {
      fail("Not yet implemented");
   }

   @Test
   public void testReverseNumberBigInteger() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetDigitalSum() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetDigitalSumByStream() {
      fail("Not yet implemented");
   }

   @Test
   public void testCompareDigitsLongLong() {
      fail("Not yet implemented");
   }

   @Test
   public void testCompareDigitsBigIntegerBigInteger() {
      fail("Not yet implemented");
   }

   @Test
   public void testMain() {
      fail("Not yet implemented");
   }

   @Test
   public void testObject() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetClass() {
      fail("Not yet implemented");
   }

   @Test
   public void testHashCode() {
      fail("Not yet implemented");
   }

   @Test
   public void testEquals() {
      fail("Not yet implemented");
   }

   @Test
   public void testClone() {
      fail("Not yet implemented");
   }

   @Test
   public void testToString() {
      fail("Not yet implemented");
   }

   @Test
   public void testNotify() {
      fail("Not yet implemented");
   }

   @Test
   public void testNotifyAll() {
      fail("Not yet implemented");
   }

   @Test
   public void testWaitLong() {
      fail("Not yet implemented");
   }

   @Test
   public void testWaitLongInt() {
      fail("Not yet implemented");
   }

   @Test
   public void testWait() {
      fail("Not yet implemented");
   }

   @Test
   public void testFinalize() {
      fail("Not yet implemented");
   }

}
