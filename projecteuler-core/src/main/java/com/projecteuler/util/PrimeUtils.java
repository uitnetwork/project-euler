package com.projecteuler.util;

import static java.util.stream.LongStream.rangeClosed;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;

public class PrimeUtils {

   // TODO: need refacter using sieve
   public static boolean isPrime(long n) {
      if (n < 2) {
         return false;
      }
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

   // TODO: need refacter using sieve
   public static long getNthPrime(int n) {
      if (n == 1)
         return 2;
      int position = n - 2; // skip 2;
      OptionalLong result = LongStream.iterate(3, l -> l + 2)
            .filter(PrimeUtils::isPrime).skip(position).findFirst();
      return result.getAsLong();
   }

   // TODO: need refacter using sieve
   public static long sumPrimeNumbersBelow(int n) {
      long result = 2;
      for (int i = 3; i < n; i = i + 2) {
         if (PrimeUtils.isPrime(i)) {
            result += i;
         }
      }
      return result;
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

   // TODO: need refacter using sieve
   public static long[] getPrimesBelowMaxInclusive(long max) {
      return rangeClosed(2, max).filter(PrimeUtils::isPrime).toArray();
   }

   // TODO: need refacter using sieve
   public static List<Long> getPrimeListBelowMax(long max) {
      Supplier<List<Long>> supplier = ArrayList<Long>::new;
      ObjLongConsumer<List<Long>> longConsumer = (list, l) -> list.add(l);
      return rangeClosed(2, max).filter(PrimeUtils::isPrime).collect(supplier,
            longConsumer, null);
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
