package com.projecteuler.util;

import static org.junit.Assert.*;

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
      assertEquals("Should be 54321", new BigInteger("54321"), MathUtils.reverseBigInteger(new BigInteger("12345")));
      assertEquals("Should be 321", new BigInteger("321"), MathUtils.reverseBigInteger(new BigInteger("123")));
      assertEquals("Should be 1", new BigInteger("1"), MathUtils.reverseBigInteger(new BigInteger("10")));
      assertEquals("Should be 8", new BigInteger("8"), MathUtils.reverseBigInteger(new BigInteger("8")));
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
      fail("Not yet implemented");
   }

   @Test
   public void testCountNumberOfDivisors_2() {
      fail("Not yet implemented");
   }

   @Test
   public void testCalculatePrimeForm() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetProperDivisors() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetSumOfProperDivisors() {
      fail("Not yet implemented");
   }

   @Test
   public void testGetFactorial() {
      fail("Not yet implemented");
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
