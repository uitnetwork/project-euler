package com.projecteuler.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeUtilsTest {

   @Test
   public void testIsPrime() {
      assertTrue("Should be true", PrimeUtils.isPrime(2));
      assertTrue("Should be true", PrimeUtils.isPrime(3));
      assertTrue("Should be true", PrimeUtils.isPrime(37));
      assertTrue("Should be true", PrimeUtils.isPrime(19));

      assertFalse("Should be false", PrimeUtils.isPrime(1));
      assertFalse("Should be false", PrimeUtils.isPrime(10));
      assertFalse("Should be false", PrimeUtils.isPrime(4));
      assertFalse("Should be false", PrimeUtils.isPrime(20));
   }

   @Test
   public void testGetNthPrimeNumber() {
      assertEquals(2, PrimeUtils.getNthPrime(1));
      assertEquals(3, PrimeUtils.getNthPrime(2));
      assertEquals(71, PrimeUtils.getNthPrime(20));
      assertEquals(29, PrimeUtils.getNthPrime(10));
   }

   @Test
   public void testSumPrimeNumbersBelow() {
      assertEquals(5, PrimeUtils.sumPrimeNumbersBelow(5));
      assertEquals(10, PrimeUtils.sumPrimeNumbersBelow(6));
      assertEquals(1060, PrimeUtils.sumPrimeNumbersBelow(100));
      assertEquals(17, PrimeUtils.sumPrimeNumbersBelow(11));
   }

   @Test
   public void testGetConsecutivePrimesOfNumber() {
      // assertEquals(5, PrimeUtils.sumPrimeNumbersBelow(5));
   }

   @Test
   public void testGetPrimesBelowMax() {
      long[] primesBelow11 = { 2, 3, 5, 7 };
      long[] primesBelow20 = { 2, 3, 5, 7, 11, 13, 17, 19 };
      long[] primesBelow30 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
      long[] primeBelow100 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

      assertArrayEquals(primesBelow11,
            PrimeUtils.getPrimesBelowMax(11));
      assertArrayEquals(primesBelow20,
            PrimeUtils.getPrimesBelowMax(20));
      assertArrayEquals(primesBelow30,
            PrimeUtils.getPrimesBelowMax(30));
      assertArrayEquals(primeBelow100,
            PrimeUtils.getPrimesBelowMax(100));
   }

   @Test
   public void testGetPrimeListBelowMax() {
      List<Long> primesBelow11 = Arrays.asList(2l, 3l, 5l, 7l);
      List<Long> primesBelow20 = Arrays.asList(2l, 3l, 5l, 7l, 11l, 13l, 17l,
            19l);
      List<Long> primesBelow30 = Arrays.asList(2l, 3l, 5l, 7l, 11l, 13l, 17l,
            19l, 23l, 29l);
      List<Long> primeBelow100 = Arrays.asList(2l, 3l, 5l, 7l, 11l, 13l, 17l,
            19l, 23l, 29l, 31l, 37l, 41l, 43l, 47l, 53l, 59l, 61l, 67l, 71l,
            73l, 79l, 83l, 89l, 97l);

      assertEquals(primesBelow11, PrimeUtils.getPrimeListBelowMax(11));
      assertEquals(primesBelow20, PrimeUtils.getPrimeListBelowMax(20));
      assertEquals(primesBelow30, PrimeUtils.getPrimeListBelowMax(30));
      assertEquals(primeBelow100, PrimeUtils.getPrimeListBelowMax(100));
   }

}
