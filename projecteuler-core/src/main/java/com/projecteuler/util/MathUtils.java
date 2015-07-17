package com.projecteuler.util;

import static java.util.stream.LongStream.rangeClosed;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;

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
         result = getSmallestCommonMultipleOf2Number(result, i);
      }
      return result;
   }

   public static final long getSmallestCommonMultipleOf2Number(long num1,
         long num2) {
      return (num1 * num2) / getGreatestCommonDivisor(num1, num2);
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

   public static final long getSmallestCommonMultipleFrom1ToN_2(long end) {
      List<Long> primes = getPrimeNumbersBelowMax(end);
      long result = 1;
      for (Long l : primes) {
         int power = (int) (Math.log(end) / Math.log(l));
         System.out.println("l: " + l + " and power: " + power);
         result *= (long) Math.pow(l, power);
      }
      return result;
   }

   public static List<Long> getPrimeNumbersBelowMax(long max) {
      Supplier<List<Long>> supplier = ArrayList<Long>::new;
      ObjLongConsumer<List<Long>> longConsumer = (list, l) -> list.add(l);
      return rangeClosed(2, max).filter(MathUtils::isPrime).collect(supplier,
            longConsumer, null);
   }

   public static boolean isPrime(long n) {
      if (n == 2)
         return true;
      if (n % 2 == 0)
         return false;
      for (int i = 3; i * i <= n; i += 2) {
         if (n % i == 0)
            return false;
      }
      return true;
   }

   // 1^2+2^2+.....n^2
   public static long sumSquareZeroToN(long n) {
      return n * (n + 1) * (2 * n + 1) / 6;
   }

   public static long getnthPrimeNumber(int n) {
      if (n == 1)
         return 2;
      int position = n - 2; // skip 2;
      OptionalLong result = LongStream.iterate(3, l -> l + 2)
            .filter(MathUtils::isPrime).skip(position).findFirst();
      return result.getAsLong();
   }

}
