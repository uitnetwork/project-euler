package com.projecteuler.util;

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
}
