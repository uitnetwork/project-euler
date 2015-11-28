package com.projecteuler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimeUtils {

   public static boolean isPrime(long number) {
      if (number == 2 || number == 3) {
         return true;
      }
      if (number % 2 == 0 || number % 3 == 0 || number <= 1) {
         return false;
      }
      long start = 5;
      int w = 2;
      while (start * start <= number) {
         if (number % start == 0) {
            return false;
         }
         start += w;
         w = 6 - w;
      }

      return true;
   }

   public static boolean isPrimeB2(long n) {
      if (n <= 1)
         return false;
      if (n == 2)
         return true;
      if (n % 2 == 0)
         return false;
      if (n < 9)
         return true;
      if (n % 3 == 0)
         return false;

      long counter = 5;
      while ((counter * counter) <= n) {
         if (n % counter == 0)
            return false;
         if (n % (counter + 2) == 0)
            return false;
         counter += 6;
      }

      return true;
   }

   public static final boolean isAppendPrime(long number1, long number2) {
      boolean result = isPrime(MathUtils.appendNumber(number1, number2))
            && isPrime(MathUtils.appendNumber(number2, number1));
      return result;
   }

   public static long getNthPrime(int n) {
      if (n == 1)
         return 2;
      int position = n - 2; // skip 2;
      OptionalLong result = LongStream.iterate(3, l -> l + 2)
            .filter(PrimeUtils::isPrime).skip(position).findFirst();
      return result.getAsLong();
   }

   public static long sumPrimeNumbersBelow(long number) {
      long[] primes = getPrimesBelowMax(number);
      return LongStream.of(primes).sum();
   }

   // TODO: need refactor INDEED
   public static final int getConsecutivePrimesOfNumber(long a, long b) {
      int count = 0;
      for (int i = 0;; i++) {
         long value = i * i + a * i + b;
         if (value < 0)
            value *= -1;
         if (PrimeUtils.isPrime(value)) {
            count++;
         } else {
            break;
         }
      }
      return count;
   }

   public static long[] getPrimesBelowMax(long max) {
      return LongStream.range(2, max).filter(PrimeUtils::isPrime).toArray();
   }

   public static int[] getPrimesBelowMax(int max) {
      return IntStream.range(2, max).filter(PrimeUtils::isPrime).toArray();
   }

   public static List<Long> getPrimeListBelowMax(long max) {
      Supplier<List<Long>> supplier = ArrayList<Long>::new;
      ObjLongConsumer<List<Long>> longConsumer = (list, l) -> list.add(l);
      return LongStream.range(2, max).filter(PrimeUtils::isPrime)
            .collect(supplier, longConsumer, null);
   }

   // TODO: need refacter using sieve
   public static List<Long> getPrimeNumbersToNth(long n) {
      List<Long> result = new ArrayList<Long>();
      result.add(2L);
      if (n == 1) {
         return result;
      }
      List<Long> primeNumbers = LongStream
            .iterate(3, l -> l + 2)
            .filter(PrimeUtils::isPrime)
            .limit(n - 1)
            .collect(ArrayList<Long>::new,
                  (ArrayList<Long> list, long l) -> list.add(l), null);
      result.addAll(primeNumbers);
      return result;
   }

}
