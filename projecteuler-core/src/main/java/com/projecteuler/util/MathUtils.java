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

}
