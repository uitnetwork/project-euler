package com.projecteuler.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MathUtils {

   public static final long sumMultiplesOfANumberBelowMax(long number, long max) {
      // n + n*2 +...+ n*m = n*(1+2+...+m) = n*m*(m+1)/2;
      long m = (max - 1) / number; // -1 because of below max
      return number * sumZeroToN(m);
   }

   public static final long sumZeroToN(long n) {
      return n * (n + 1) / 2;
   }

   public static final long getLargestPrimeFactor(long number) {
      long result = -1;
      long start = 2;
      while (start <= number) {
         while (number % start == 0) {
            number /= start;
            result = start;
         }
         ++start;
      }
      return result;
   }

   // palindrome number is the number which will be equaled to the reverse of
   // that number: eg: 10001
   public static final boolean isPalindromeNumber(long number) {
      long temp = number;
      int length = 1;
      while ((temp /= 10) > 0) {
         length *= 10;
      }
      while (number > 0) {
         long start = number / length;
         long end = number % 10;
         if (start != end) {
            return false;
         }
         number = (number % length) / 10;
         length /= 100;
      }
      return true;
   }

   public static boolean isPalindromeNumber2(int x) {
      if (x < 0)
         return false;
      int div = 1;
      while (x / div >= 10) {
         div *= 10;
      }
      while (x != 0) {
         int l = x / div;
         int r = x % 10;
         if (l != r)
            return false;
         x = (x % div) / 10;
         div /= 100;
      }
      return true;
   }

   public static final long reverseNumber(long number) {
      long result = 0;
      while (number > 0) {
         result = result * 10 + number % 10;
         number /= 10;
      }
      return result;
   }

   public static final long getSmallestCommonMultipleFrom1ToN(long end) {
      long result = 1;
      for (long i = 2; i <= end; ++i) {
         result=getSmallestCommonMultipleOf2Number(result, i);
      }
      return result;
   }

   public static final long getSmallestCommonMultipleOf2Number(long num1,
         long num2) {
      return (num1*num2)/getGreatestCommonDivisor(num1, num2);
   }

   public static long getGreatestCommonDivisor(long a, long b) {
      if (a == 0)
         return b;
      while (b != 0) {
         if (a > b)
            a = a - b;
         else
            b = b - a;
      }
      return a;
   }
}
