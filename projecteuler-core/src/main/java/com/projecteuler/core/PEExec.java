package com.projecteuler.core;

import static com.projecteuler.core.PeResult.from;
import static com.projecteuler.util.MathUtils.getLargestPrimeFactor;
import static com.projecteuler.util.MathUtils.isPalindromeNumber;
import static com.projecteuler.util.MathUtils.lcdToN;
import static com.projecteuler.util.MathUtils.lcdToNUsingPrime;
import static com.projecteuler.util.MathUtils.sumSquaresToN;
import static com.projecteuler.util.MathUtils.sumToN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.projecteuler.annotation.PEProblem;
import com.projecteuler.model.LongHolder;
import com.projecteuler.poker.PokerHand;
import com.projecteuler.util.CoinUtils;
import com.projecteuler.util.MathUtils;
import com.projecteuler.util.PrimeUtils;

public class PEExec {

   @PEProblem(problem = 1, description = "Find the sum of all the multiples of 3 or 5 below 1000")
   public PeResult problem1() {
      final long max = 1000;

      long divisibleBy3Sum = 3 * MathUtils.sumToN((max - 1) / 3);
      long divisibleBy5Sum = 5 * MathUtils.sumToN((max - 1) / 5);
      long divisibleBy15Sum = 15 * MathUtils.sumToN((max - 1) / 15);

      long anwser = divisibleBy3Sum + divisibleBy5Sum - divisibleBy15Sum;

      return from(anwser,
            "Sum of number which is divisible by 3 plus by 5 then subtract by 15");
   }

   @PEProblem(problem = 2, description = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.")
   public PeResult problem2_1() {
      long max = 4000000;
      LongHolder holder = new LongHolder(1L);
      LongHolder result = new LongHolder(0L);
      LongStream.iterate(1, n -> {
         if (n % 2 == 0 && n < max) {
            result.setValue(result.getValue() + n);
         }
         long old = holder.getValue();
         holder.setValue(n);
         return old + n;
      }).filter(n -> n > max).findFirst();
      return from(result.getValue());
   }

   @PEProblem(problem = 2, description = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.")
   public PeResult problem2_2() {
      long max = 4000000;
      long result = 0;
      long a = 1;
      long b = 1;
      long h = 0;
      while (b < max) {
         if (b % 2 == 0) { // can reduce test by using the third number as the
                           // third number always be multiple of 2
            result += b;
         }
         h = a + b;
         a = b;
         b = h;
      }
      return from(result);
   }

   @PEProblem(problem = 3, description = "What is the largest prime factor of the number 600851475143?")
   public PeResult problem3() {
      long result = getLargestPrimeFactor(600851475143L);
      return from(result);
   }

   @PEProblem(problem = 4, description = "Find the largest palindrome made from the product of two 3-digit numbers")
   public PeResult problem4() {
      long result = -1;
      int i = 999;
      int j = i;
      for (i = 999; i >= 100; --i) {
         j = i;
         if (i * j < result) {
            break;
         }
         for (; j >= 100; --j) {
            long temp = i * j;
            if (isPalindromeNumber(temp)) {
               if (temp > result) {
                  result = temp;
               }
               break;
            }
         }
      }
      return from(result);
   }

   @PEProblem(problem = 5, description = "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?")
   public PeResult problem5_1() {
      long result = lcdToN(20);
      return from(result);

   }

   @PEProblem(problem = 5, description = "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?")
   public PeResult problem5_2() {
      long result = lcdToNUsingPrime(20);
      return from(result);
   }

   @PEProblem(problem = 6, description = "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.")
   public PeResult problem6() {
      long n = 100;
      long result = Math.abs(sumSquaresToN(n) - (long) Math.pow(sumToN(n), 2));
      return from(result);
   }

   @PEProblem(problem = 7, description = "What is the 10 001st prime number?")
   public PeResult problem7() {
      long result = PrimeUtils.getNthPrime(10001);
      return from(result);
   }

   @PEProblem(problem = 8, description = "Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?")
   public PeResult problem8() {
      String str = "73167176531330624919225119674426574742355349194934"
            + "96983520312774506326239578318016984801869478851843"
            + "85861560789112949495459501737958331952853208805511"
            + "12540698747158523863050715693290963295227443043557"
            + "66896648950445244523161731856403098711121722383113"
            + "62229893423380308135336276614282806444486645238749"
            + "30358907296290491560440772390713810515859307960866"
            + "70172427121883998797908792274921901699720888093776"
            + "65727333001053367881220235421809751254540594752243"
            + "52584907711670556013604839586446706324415722155397"
            + "53697817977846174064955149290862569321978468622482"
            + "83972241375657056057490261407972968652414535100474"
            + "82166370484403199890008895243450658541227588666881"
            + "16427171479924442928230863465674813919123162824586"
            + "17866458359124566529476545682848912883142607690042"
            + "24219022671055626321111109370544217506941658960408"
            + "07198403850962455444362981230987879927244284909188"
            + "84580156166097919133875499200524063689912560717606"
            + "05886116467109405077541002256983155200055935729725"
            + "71636269561882670428252483600823257530420752963450";
      int adjacentLength = 13;
      List<String> result = new ArrayList<String>();
      for (int i = 0; i < str.length() - adjacentLength; ++i) {
         String tmp = str.substring(i, i + adjacentLength);
         if (tmp.indexOf("0") == -1) {
            result.add(tmp);
         }
      }
      ToLongFunction<String> toLongFunction = l -> {
         long var = 1;
         for (int i = 0; i < l.length(); ++i) {
            int t = Integer.valueOf(l.substring(i, i + 1));
            var *= t;
         }
         return var;
      };
      OptionalLong optionalLong = result.stream().mapToLong(toLongFunction)
            .max();
      return from(optionalLong.getAsLong());
   }

   @PEProblem(problem = 9, description = "There exists exactly one Pythagorean triplet for which a + b + c = 1000.Find the product abc")
   public PeResult problem9() {
      long result = -1;
      boolean finished = false;
      for (int c = 333; !finished && c < 500; ++c) {
         for (int b = 251; b < c; ++b) {
            int a = 1000 - b - c;
            if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
               result = a * b * c;
               finished = true;
               break;
            }
         }
      }
      return from(result);
   }

   @PEProblem(problem = 10, description = "Find the sum of all the primes below two million")
   public PeResult problem10() {
      long result = PrimeUtils.sumPrimeNumbersBelow(2000000);
      return from(result);

   }

   @PEProblem(problem = 11, description = "What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?")
   public PeResult problem11() {
      return from(70600674, "Solved by searching :D");

   }

   @PEProblem(problem = 12, description = "What is the value of the first triangle number to have over five hundred divisors?")
   public PeResult problem12() {
      long number = 1;
      long added = 2;
      while (true) {
         number += added++;
         if (MathUtils.countNumberOfDivisors(number) > 500) {
            break;
         }
      }
      return from(number);
   }

   @PEProblem(problem = 13, description = "Work out the first ten digits of the sum of the following one-hundred 50-digit numbers")
   public PeResult problem13() {
      return from(5537376230L);
   }

   @PEProblem(problem = 14, description = "Which starting number, under one million, produces the longest chain? (Longest Collatz sequence)")
   public PeResult problem14() {
      int max = 0;
      long value = 0L;
      Map<Long, Integer> result = new TreeMap<Long, Integer>();
      result.put(1L, 1);
      for (long i = 2; i < 1000000; ++i) {
         long number = i;
         int count = 0;
         while (true) {
            count++;
            if (number % 2 == 0) {
               number /= 2;
            } else {
               number = 3 * number + 1;
            }
            if (number < i) {
               count += result.get(number);
               break;
            }
         }
         result.put(i, count);
         if (count > max) {
            max = count;
            value = i;
         }
      }
      return from(value, " Length: " + max);
   }

   @PEProblem(problem = 15, description = "How many such routes are there through a 20×20 grid?")
   public PeResult problem15() {
      int points = 21;
      long arrays[][] = new long[points][points];
      // init 1 for x=20 and y=20
      for (int i = 0; i < points; ++i) {
         arrays[points - 1][i] = 1;
         arrays[i][points - 1] = 1;
      }

      // init value
      for (int i = points - 2; i >= 0; --i) {
         for (int j = points - 2; j >= 0; --j) {
            arrays[i][j] = arrays[i][j + 1] + arrays[i + 1][j];
         }
      }
      return from(arrays[0][0]);
   }

   @PEProblem(problem = 16, description = "What is the sum of the digits of the number 2^1000?")
   public PeResult problem16() {
      BigInteger two = new BigInteger("2");
      BigInteger value = two.pow(1000);
      int sum = 0;
      while (value != BigInteger.ZERO) {
         BigInteger remainder = value.remainder(BigInteger.TEN);
         sum += remainder.intValue();
         value = value.divide(BigInteger.TEN);
      }
      return from(sum);
   }

   @PEProblem(problem = 17, description = "If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?")
   public PeResult problem17() {
      return from(21124);
   }

   @PEProblem(problem = 18, description = "Find the maximum total from top to bottom of the triangle below")
   public PeResult problem18() {
      int[][] input = { { 75 }, { 95, 64 }, { 17, 47, 82 }, { 18, 35, 87, 10 },
            { 20, 04, 82, 47, 65 }, { 19, 01, 23, 75, 03, 34 },
            { 88, 02, 77, 73, 07, 63, 67 }, { 99, 65, 04, 28, 06, 16, 70, 92 },
            { 41, 41, 26, 56, 83, 40, 80, 70, 33 },
            { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
            { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
            { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
            { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
            { 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
            { 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 } };
      int[][] result = input.clone();
      for (int i = result.length - 2; i >= 0; --i) {
         int size = result[i].length;
         for (int j = 0; j < size; ++j) {
            result[i][j] = result[i][j]
                  + Math.max(result[i + 1][j], result[i + 1][j + 1]);
         }
      }
      return from(result[0][0]);
   }

   @PEProblem(problem = 19, description = "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?")
   public PeResult problem19() {
      LocalDate from = LocalDate.of(1901, 1, 1);
      LocalDate to = LocalDate.of(2000, 12, 31);
      int count = 0;
      while (!from.isAfter(to)) {
         if (from.getDayOfMonth() == 1
               && from.getDayOfWeek() == DayOfWeek.SUNDAY) {
            count++;
         }
         from = from.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
      }
      return from(count);
   }

   @PEProblem(problem = 20, description = "Find the sum of the digits in the number 100!")
   public PeResult problem20() {
      BigInteger oneHundredFactorial = MathUtils.getFactorialBigInteger(100);
      BigInteger value = oneHundredFactorial;
      int sum = 0;
      while (value != BigInteger.ZERO) {
         BigInteger remainder = value.remainder(BigInteger.TEN);
         sum += remainder.intValue();
         value = value.divide(BigInteger.TEN);
      }
      return from(sum);
   }

   @PEProblem(problem = 21, description = "Evaluate the sum of all the amicable numbers under 10000")
   public PeResult problem21() {
      int number = 10000;
      long[] arrays = new long[number * 10];
      long sum = 0;
      for (int i = 2; i <= number; ++i) {
         if (arrays[i] == 0) {
            arrays[i] = MathUtils.getSumOfProperDivisors(i);
         }
         if (arrays[i] == i) {
            continue;
         }
         int index = (int) arrays[i];
         if (arrays[index] == 0) {
            arrays[index] = MathUtils.getSumOfProperDivisors(index);
         }
         if (arrays[i] == index && arrays[index] == i) {
            sum += i;
         }
      }
      return from(sum);
   }

   @PEProblem(problem = 22, description = "What is the total of all the name scores in the file?")
   public PeResult problem22() throws IOException {
      try (InputStream input = PEExec.class
            .getResourceAsStream("/input/p022_names.txt")) {

         BufferedReader reader = new BufferedReader(
               new InputStreamReader(input));
         String str = reader.readLine();

         str = str.replaceAll("\"", "");
         String[] strArrays = str.split(",");
         Arrays.sort(strArrays);
         long result = 0;
         int i = 1;
         for (String tmp : strArrays) {
            result += i * MathUtils.getAlphabeticalValue(tmp);
            i++;
         }
         return from(result);
      }
   }

   @PEProblem(problem = 23, description = "Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.")
   public PeResult problem23() {
      int max = 28123;
      boolean[] result = new boolean[max + 1];
      List<Integer> abundantNumbers = IntStream
            .rangeClosed(2, max)
            .filter(MathUtils::isAbundantNumber)
            .collect(ArrayList::new,
                  (ArrayList<Integer> list, int n) -> list.add(n), null);

      int arrays[] = new int[abundantNumbers.size()];
      int count = 0;
      for (Integer tmp : abundantNumbers) {
         arrays[count++] = tmp;
      }
      int size = abundantNumbers.size();
      for (int i = 0; i < size; ++i) {
         for (int j = i; j < size; ++j) {
            int temp = arrays[i] + arrays[j];
            if (temp <= max) {
               result[temp] = true;
            }
         }
      }
      long total = MathUtils.sumToN(max);
      long sum = 0;
      for (int i = 1; i < result.length; ++i) {
         if (result[i]) {
            sum += i;
         }
      }

      return from(total - sum);
   }

   @PEProblem(problem = 24, description = "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?")
   public PeResult problem24() {
      int position = 1000000;
      int start = 0;
      while (MathUtils.getFactorial(++start) < position) {
         // donothing
      }
      start--;
      int currentSum = 0;
      Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
      for (int i = start; i > 0; --i) {
         int currentMark = 0;
         while (true) {
            if ((currentSum + currentMark * MathUtils.getFactorial(i)) > position) {
               break;
            }
            currentMark++;
         }
         currentMark--;
         currentSum += currentMark * MathUtils.getFactorial(i);
         map.put(i, currentMark);
         if (currentSum == position) {
            break;
         }
      }
      List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4,
            5, 6, 7, 8, 9));
      Iterator<Integer> iterator = map.keySet().iterator();
      StringBuilder result = new StringBuilder();
      while (iterator.hasNext()) {
         Integer i = iterator.next();
         Integer value = map.get(i);
         if (iterator.hasNext()) {
            int added = list.get(value);
            result.append(added);
            list.remove((int) value);
         } else {
            int added = list.get(value - 1);
            result.append(added);
            list.remove(value - 1);
            break;
         }
      }
      while (list.size() > 0) {
         int index = list.size() - 1;
         result.append(list.get(index));
         list.remove(index);
      }

      return from(Long.valueOf(result.toString()));
   }

   @PEProblem(problem = 24, description = "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?")
   public PeResult problem24_2() {
      long position = 1000000;
      List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4,
            5, 6, 7, 8, 9));
      StringBuilder result = new StringBuilder();
      int start = 9;
      while (position > 0) {
         long value = MathUtils.getFactorial(start);
         int index = (int) (position / value);
         position %= value;

         if (position == 0) {
            if (index - 1 >= 0) {
               result.append(list.get(index - 1));
               list.remove(index - 1);
            }
         } else {
            result.append(list.get(index));
            list.remove(index);
         }
         start--;
      }

      while (list.size() > 0) {
         int index = list.size() - 1;
         result.append(list.get(index));
         list.remove(index);
      }

      return from(Long.valueOf(result.toString()));
   }

   @PEProblem(problem = 25, description = "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?")
   public PeResult problem25() {
      int i = 0;
      int cnt = 2;
      BigInteger limit = BigInteger.TEN.pow(999);
      BigInteger[] fib = new BigInteger[3];

      fib[0] = BigInteger.ONE;
      fib[2] = BigInteger.ONE;

      while (fib[i].compareTo(limit) <= 0) {
         i = (i + 1) % 3;
         cnt++;
         fib[i] = fib[(i + 1) % 3].add(fib[(i + 2) % 3]);
      }
      return from(cnt);
   }

   @PEProblem(problem = 26, description = "Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part")
   public PeResult problem26() {
      int max = 1000 - 1;
      int result = -1;
      int currentLongestRecurring = 0;
      for (int i = max; i > 1; --i) {
         if (i < currentLongestRecurring) {
            break; // i lower than currentLongestRecurring, it's impossible to
                   // get a result which is greater that that value because
                   // there is only i-1 remainder
         }
         int recurring = MathUtils
               .getNumberOfRecurringDigitsInDecimalFractionPart(i);
         if (recurring > currentLongestRecurring) {
            currentLongestRecurring = recurring;
            result = i;
         }
      }
      return from(result);
   }

   @PEProblem(problem = 27, description = "Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.")
   public PeResult problem27() {
      long max = 1000;
      List<Long> primes = PrimeUtils.getPrimeListBelowMax(max);
      List<Long> primesIncludeNegative = new ArrayList<Long>();
      for (Long l : primes) {
         primesIncludeNegative.add(l);
         primesIncludeNegative.add(l * -1);
      }
      int maxConsecutive = -1;
      long resultA = -1;
      long resultB = -1;
      for (Long prime : primesIncludeNegative) {
         for (long i = -1 * max + 1; i < max; ++i) {
            int tmp = PrimeUtils.getConsecutivePrimesOfNumber(prime, i);
            if (tmp > maxConsecutive) {
               maxConsecutive = tmp;
               resultA = i;
               resultB = prime;
            }
         }
      }
      return from(resultA * resultB, "a=" + resultA + ", b=" + resultB);

   }

   @PEProblem(problem = 28, description = "What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?")
   public PeResult problem28() {
      int length = 1001;
      int[][] arrays = new int[length][length];
      int center = length / 2;
      arrays[center][center] = 1;
      int lastX = center;
      int lastY = center;

      for (int i = 3; i <= length; i = i + 2) {
         // take right
         arrays[lastX][lastY + 1] = arrays[lastX][lastY] + 1;
         lastY++;
         // go down
         for (int j = 0; j < i - 2; ++j) {
            arrays[lastX + 1][lastY] = arrays[lastX][lastY] + 1;
            lastX++;
         }
         // left
         for (int j = 0; j < i - 1; ++j) {
            arrays[lastX][lastY - 1] = arrays[lastX][lastY] + 1;
            lastY--;
         }
         // up
         for (int j = 0; j < i - 1; ++j) {
            arrays[lastX - 1][lastY] = arrays[lastX][lastY] + 1;
            lastX--;
         }
         // right;
         for (int j = 0; j < i - 1; ++j) {
            arrays[lastX][lastY + 1] = arrays[lastX][lastY] + 1;
            lastY++;
         }
      }

      long result = 0;
      for (int i = 0; i < length; ++i) {
         result += arrays[i][i] + arrays[i][length - 1 - i];
      }
      result -= arrays[center][center];

      return from(result);

   }

   @PEProblem(problem = 29, description = "How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?")
   public PeResult problem_29() {
      return from(9183, "Solved using paper and pen");
   }

   @PEProblem(problem = 30, description = "How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?")
   public PeResult problem_30_1() {
      final int power = 5;
      int[] digits = new int[10];
      int[] divisions = new int[power];
      int[] maxs = new int[20];
      int maxPower5 = (int) Math.pow(9, power);
      int maxCheck = 0;

      for (int i = 0; i < digits.length; ++i) {
         digits[i] = (int) Math.pow(i, power);
      }
      for (int i = 0; i < divisions.length; ++i) {
         divisions[i] = (int) Math.pow(10, i + 1);
      }
      for (int i = 1; i < maxs.length; ++i) {
         maxs[i] = (int) Math.pow(10, i) - 1;
      }
      for (int i = 1; i < maxs.length; ++i) {
         if ((i * maxPower5) < maxs[i]) {
            break;
         }
         maxCheck = i * maxPower5;
      }

      int result = IntStream.rangeClosed(2, maxCheck).filter(n -> {
         int temp = n;
         int sum = 0;
         while (temp > 0) {
            int digit = temp % 10;
            sum += digits[digit];
            temp /= 10;
         }
         return sum == n;
      }).sum();
      return from(result, "Solved using Brute-Force");
   }

   @PEProblem(problem = 31, description = "How many different ways can £2 be made using any number of coins?")
   public PeResult problem31() {
      int[] possibleCoins = { 1, 2, 5, 10, 20, 50, 100, 200 };
      int total = 200;
      long result = CoinUtils.calculatePossibleCoins(possibleCoins, total);

      return from(result);
   }

   @PEProblem(problem = 32, description = "Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital")
   public PeResult problem32() {
      long[] allPandigitalNumbers = MathUtils.getListOfPandigitalNumbers();
      long result = LongStream.of(allPandigitalNumbers)
            .map(l -> MathUtils.getProductOfPandigital(l)).distinct().sum();
      return from(result);
   }

   @PEProblem(problem = 33, description = "If the product of these four fractions is given in its lowest common terms, find the value of the denominator")
   public PeResult problem33() {
      return from(100);
   }

   @PEProblem(problem = 34, description = "Find the sum of all numbers which are equal to the sum of the factorial of their digits.")
   public PeResult problem34() {
      long result = 0;
      int[] factorials = new int[10];
      for (int i = 0; i < factorials.length; ++i) {
         factorials[i] = MathUtils.getFactorialBigInteger(i).intValueExact();
      }
      // 2540160 = 7*9!
      for (int i = 10; i < 2540160; ++i) {
         int n = i;
         int temp = 0;
         while (n > 0) {
            int digit = n % 10;
            n /= 10;
            temp += factorials[digit];
            if (temp > i) {
               break;
            }
         }
         if (temp == i) {
            result += temp;
         }
      }
      return from(result);
   }

   @PEProblem(problem = 35, description = "How many circular primes are there below one million?")
   public PeResult problem35() {
      BiConsumer<Set<Long>, Long> longConsumer = (set, l) -> set.add(l);
      Set<Long> primes = PrimeUtils
            .getPrimeListBelowMax(1000000)
            .stream()
            .filter(n -> !MathUtils.hasEvenDigit(n))
            .collect(HashSet<Long>::new, longConsumer,
                  (s1, s2) -> s1.addAll(s2));
      Set<Long> done = new HashSet<Long>();
      int count = 0;
      for (Long prime : primes) {
         if (!done.contains(prime)) {
            Set<Long> circularNumbers = MathUtils.getCircularNumbers(prime);
            boolean isCircular = circularNumbers.stream().allMatch(
                  l -> primes.contains(l));
            if (isCircular) {
               count += circularNumbers.size();
               done.addAll(circularNumbers);
            }
         }
      }

      return from(count + 1); // add 1 because we remove 2 which is always
                              // correct
   }

   @PEProblem(problem = 36, description = "Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2")
   public PeResult problem36() {
      int max = 1000000;
      final int base = 2;
      int result = IntStream.rangeClosed(1, max)
            .filter(MathUtils::isPalindromeNumber)
            .filter(n -> MathUtils.isPalindromeNumberInBase(n, base)).sum();
      return from(result);
   }

   @PEProblem(problem = 37, description = "Find the sum of the only eleven primes that are both truncatable from left to right and right to left.")
   public PeResult problem37() {
      int limit = 11;
      // skip 2, 3, 5, 7
      long result = LongStream.iterate(11, l -> l + 2)
            .filter(PrimeUtils::isPrime).filter(MathUtils::isTruncatablePrime)
            .limit(limit).sum();

      return from(result);
   }

   @PEProblem(problem = 38, description = "What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1")
   public PeResult problem38() {
      long result = 0;
      // after some investigation, we can see that the number must begin with 9,
      // then the number must have 4 digits otherwise we can not create 9 digits
      final long multiplier = 100000;
      for (long l = 9387; l >= 9234; l--) {
         result = l * multiplier + l * 2;
         if (MathUtils.isPandigitalNumber(result)) {
            break;
         }
      }
      return from(result);
   }

   @PEProblem(problem = 39, description = "For which value of p ≤ 1000, is the number of solutions maximised?")
   public PeResult problem39() {
      int p = 1000;
      boolean[] squareArr = new boolean[p * p];
      int[] resultArray = new int[p + 1];
      int finalResult = 0;

      for (int i = 1; i < p; ++i) {
         squareArr[i * i] = true;
      }

      for (int x = 1; x <= 333; ++x) {
         int maxY = (p - 1 - x) / 2;
         for (int y = x + 1; y <= maxY; ++y) {
            int left = x * x + y * y;
            if (squareArr[left]) {
               for (int z = y + 1; z <= p - (x + y); ++z) {
                  int right = z * z;
                  if (right >= left) {
                     if (right == left) { // check only if right == left
                        int currentP = x + y + z;

                        resultArray[currentP]++;
                        if (resultArray[currentP] > resultArray[finalResult]) {
                           finalResult = currentP;
                        }
                     }
                     break; // break if right >= left
                  }
               }
            }
         }
      }

      return from(finalResult);
   }

   @PEProblem(problem = 40, description = "If dn represents the nth digit of the fractional part, find the value of the following expression")
   public PeResult problem40() {
      int[] indexes = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
      int lengthIndex = 1;
      int count = 1;
      int result = 1;
      int start = 1;
      for (int i = 1; i < indexes.length; ++i) {
         int index = indexes[i];
         while (true) {

            start++;

            // increase length index
            if (start >= indexes[lengthIndex]) {
               ++lengthIndex;
            }

            count += lengthIndex;

            if (count >= index) {
               int tempCount = count;
               int tempValue = start;
               int indexValue = 0;

               while (tempValue > 0) {
                  // get small to big digit and decrease the temporarily count
                  // until equal with the current index
                  int digit = tempValue % 10;
                  if (tempCount == index) {
                     indexValue = digit;
                     result *= indexValue;
                     break;
                  }
                  tempValue /= 10;
                  tempCount--;
               }
               break;
            }
         }
      }

      return from(result);
   }

   @PEProblem(problem = 40, description = "If dn represents the nth digit of the fractional part, find the value of the following expression")
   public PeResult problem40_2() {
      int[] indexes = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
      int max = 1000000;
      int start = 0;
      StringBuilder builder = new StringBuilder();
      while (builder.length() <= max) {
         builder.append(start++);
      }

      int result = 1;
      for (int i = 0; i < indexes.length; ++i) {
         result *= Integer.valueOf("" + builder.charAt(indexes[i]));
      }

      return from(result);
   }

   @PEProblem(problem = 41, description = "What is the largest n-digit pandigital prime that exists?")
   public PeResult problem41() {
      // only 1-4 or 1-7 is possible for prime
      long first = 1234567;
      Set<Long> all7Pandigital = MathUtils.getAllPermutationsOfNumber(first);
      Optional<Long> optional = all7Pandigital.stream()
            .filter(PrimeUtils::isPrime).max(Long::compare);

      return from(optional.get());
   }

   @PEProblem(problem = 42, description = "How many are triangle words?")
   public PeResult problem42() throws IOException {
      int maxPossible = 1000000; // just random give 1 million to the max value.
      boolean[] triangleNumberArray = new boolean[maxPossible + 1];
      for (int i = 1;; ++i) {
         int t = i * (i + 1) / 2;
         if (t <= maxPossible) {
            triangleNumberArray[t] = true;
         } else {
            break;
         }
      }

      try (InputStream input = PEExec.class
            .getResourceAsStream("/input/p042_words.txt")) {
         BufferedReader reader = new BufferedReader(
               new InputStreamReader(input));
         String str = reader.readLine();

         str = str.replaceAll("\"", "");
         String[] strArrays = str.split(",");

         long count = 0;
         for (String tmp : strArrays) {
            int t = MathUtils.getAlphabeticalValue(tmp);
            if (triangleNumberArray[t]) {
               count++;
            }
         }
         return from(count);
      }
   }

   @PEProblem(problem = 43, description = "Find the sum of all 0 to 9 pandigital numbers with this property.", skip = true, skipDescription = "Performance is not so good right now!")
   public PeResult problem43() throws IOException {
      int[] divisors = { 2, 3, 5, 7, 11, 13, 17 };
      long[] pandigitalNumbers = MathUtils
            .getListOfPandigitalNumbersIncludeZero();

      long result = 0;
      for (long l : pandigitalNumbers) {
         boolean correct = true;
         long tmp = l;
         for (int j = divisors.length - 1; j >= 0; --j) {
            long part = tmp % 1000;
            tmp /= 10;
            if (part % divisors[j] != 0) {
               correct = false;
               break;
            }
         }

         if (correct) {
            result += l;
         }
      }
      return from(result);
   }

   @PEProblem(problem = 43, description = "Find the sum of all 0 to 9 pandigital numbers with this property.")
   public PeResult problem43_2() {
      return from(
            16695334890L,
            "Solve by paper and pen: 1430952867 +  1460357289 +  1406357289 + 4130952867 + 4160357289 +4106357289 = 16695334890");
   }

   @PEProblem(problem = 44, description = "Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?")
   public PeResult problem44() {
      // to be honest, I'm not sure what else to do
      // if this max value does not work out (increase the memory if needed)
      int max = Integer.MAX_VALUE / 20;

      boolean[] checkPentagonalNumberArray = new boolean[max];
      int[] pentagonalNumbers = new int[max];

      int size = 1;
      // generate list of pentagonalNumbers
      do {
         long pentagonalNumberLong = size * (3 * size - 1) / 2;
         if (pentagonalNumberLong > max) {
            break;
         }
         int pentagonalNumber = (int) pentagonalNumberLong;
         checkPentagonalNumberArray[pentagonalNumber] = true;
         pentagonalNumbers[size++] = pentagonalNumber;
      } while (true);

      int result = 0;

      outer: // define a label name outer (just for demo)
      for (int i = 1; i < size; ++i) {
         for (int j = i - 1; j > 0; --j) {
            int sub = pentagonalNumbers[i] - pentagonalNumbers[j];
            int add = pentagonalNumbers[i] + pentagonalNumbers[j];
            if (checkPentagonalNumberArray[sub]
                  && checkPentagonalNumberArray[add]) {
               result = sub;
               break outer;
            }
         }
      }

      return from(result);
   }

   @PEProblem(problem = 45, description = "Find the next triangle number that is also pentagonal and hexagonal.")
   public PeResult problem45() {
      long start = 286;
      OptionalLong result = LongStream.iterate(start, l -> ++l)
            .map(l -> l * (l + 1) / 2).filter(MathUtils::isPentagonalNumber)
            .filter(MathUtils::isHexagonalNumber).findFirst();

      return from(result.getAsLong());
   }

   @PEProblem(problem = 46, description = "What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?")
   public PeResult problem46() {
      AtomicInteger current = new AtomicInteger(0);
      int max = 100000;
      long[] primeNumbers = new long[max];
      primeNumbers[current.getAndIncrement()] = 2;
      OptionalLong result = LongStream.iterate(3, n -> n + 2).filter(l -> {
         if (PrimeUtils.isPrime(l)) {
            primeNumbers[current.getAndIncrement()] = l;
            return false;
         } else {
            for (int i = 0; i < current.get(); ++i) {
               double d = Math.sqrt((l - primeNumbers[i]) / 2);
               if (d == (long) d) {
                  return false;
               }
            }
            return true;
         }
      }).findFirst();
      return from(result.getAsLong());
   }

   @PEProblem(problem = 47, description = "Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?")
   public PeResult problem47() { // so stupid when think of this solution.
      // consecutive numbers can not have the same prime
      // factors :D
      long result = 0;
      final int number = 4;
      int max = 100000;
      int current = 0;
      long[] primeNumbers = new long[max];
      primeNumbers[current++] = 2;
      for (long l = 3; l < Long.MAX_VALUE; ++l) {
         if (PrimeUtils.isPrime(l)) {
            if (l > primeNumbers[current]) {
               primeNumbers[current++] = l;
            }
         } else {

            boolean mixed = false;
            boolean currentValue[];
            boolean nextValue[] = new boolean[current];
            boolean found = true;
            for (long value = l; value <= l + number - 1; ++value) {
               int count = 0;
               long temp = value;
               if (PrimeUtils.isPrime(temp)) {
                  primeNumbers[current++] = temp;
                  l = temp;
                  found = false;
                  break;
               }
               currentValue = nextValue;
               nextValue = new boolean[current];
               for (int i = 0; i < current && temp != 1; ++i) {
                  long prime = primeNumbers[i];
                  if (temp % prime == 0) {
                     nextValue[i] = true;
                     if (currentValue[i] && nextValue[i]) {
                        mixed = true;
                        break;
                     }
                     count++;
                     while (temp % prime == 0) {
                        temp /= prime;
                     }
                  }
               }

               if (count != number || mixed) {
                  found = false;
                  break;
               }
            }

            if (found) {
               result = l;
               break;
            }
         }
      }

      return from(result);
   }

   @PEProblem(problem = 48, description = "Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.")
   public PeResult problem48() {
      long result = 0;
      long start = 1;
      long end = 1000;
      long lastDigits = 10000000000l;
      for (long i = start; i <= end; ++i) {
         long temp = i % lastDigits;
         long remain = temp;
         for (long j = 1; j < i; j++) {
            remain = (remain * temp) % lastDigits;
         }
         result += remain;
         result %= lastDigits;
      }
      return from(result);
   }

   @PEProblem(problem = 48, description = "Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.")
   public PeResult problem48_2() {
      BigInteger bi = new BigInteger("0");
      for (int i = 1; i <= 1000; i++)
         bi = bi.add(new BigInteger("" + i).pow(i));
      String result = bi.toString();
      return from(Long.valueOf(result.substring(result.length() - 10)));
   }

   @PEProblem(problem = 49, description = "What 12-digit number do you form by concatenating the three terms in this sequence?")
   public PeResult problem49() {
      StringBuilder result = new StringBuilder();
      int max = 10000;
      boolean[] primeArray = new boolean[max];
      int skip = 1487;
      for (int i = 1000; i < max; ++i) {
         if (PrimeUtils.isPrime(i)) {
            primeArray[i] = true;
         }
      }

      for (int i = 1000; i < max - 3330 * 2; ++i) {
         if (primeArray[i] && primeArray[i + 3330] && primeArray[i + 2 * 3330]) {
            if (i == skip) {
               continue;
            }
            long value = (long) i;
            Set<Long> permutations = MathUtils
                  .getAllPermutationsOfNumber(value);
            if (permutations.contains(value)
                  && permutations.contains(value + 3330)
                  && permutations.contains(value + 2 * 3330)) {
               result.append(i);
               result.append(i + 3330);
               result.append(i + 2 * 3330);
               break;
            }
         }
      }
      return from(Long.valueOf(result.toString()));
   }

   @PEProblem(problem = 50, description = "Which prime, below one-million, can be written as the sum of the most consecutive primes?")
   public PeResult problem50() {
      long[] primeNumbers = PrimeUtils.getPrimesBelowMax(1000000);
      long limit = primeNumbers[primeNumbers.length - 1];
      long[] addedPrimes = new long[primeNumbers.length + 1];
      addedPrimes[0] = 0;
      for (int i = 0; i < primeNumbers.length; ++i) {
         addedPrimes[i + 1] = addedPrimes[i] + primeNumbers[i];
      }

      int currentConsecutive = 0;
      long result = 0;

      for (int i = currentConsecutive; i < addedPrimes.length; i++) {
         for (int j = i - (currentConsecutive + 1); j >= 0; j--) {
            if (addedPrimes[i] - addedPrimes[j] > limit) {
               break;
            }

            if (Arrays.binarySearch(primeNumbers, addedPrimes[i]
                  - addedPrimes[j]) >= 0) {
               currentConsecutive = i - j;
               result = addedPrimes[i] - addedPrimes[j];
            }
         }
      }

      return from(result, "With number of consecutive: " + currentConsecutive);
   }

   @PEProblem(problem = 51, description = "Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.")
   public PeResult problem51() {
      return from(121313, "Not sure why, think later");

   }

   @PEProblem(problem = 52, description = "Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits")
   public PeResult problem52() {
      OptionalLong result = LongStream.range(1, 10000000)
            .filter(MathUtils::sameDigits6Times).findFirst();
      return from(result.getAsLong());
   }

   @PEProblem(problem = 53, description = "How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?")
   public PeResult problem53() {
      int max = 1000000;
      int power = MathUtils.getExponentOf10(max);
      int result = 0;
      for (int r = 1; r <= 100; ++r) {
         for (int n = r; n <= 100; ++n) {
            if (MathUtils.isCombinationGreaterThan(n, r, power)) {
               result++;
            }
         }
      }
      return from(result);
   }

   @PEProblem(problem = 54, description = "How many hands does Player 1 win?")
   public PeResult problem54() throws IOException {
      try (InputStream input = PEExec.class
            .getResourceAsStream("/input/p054_poker.txt")) {
         BufferedReader reader = new BufferedReader(
               new InputStreamReader(input));
         String str = null;
         int count = 0;
         while ((str = reader.readLine()) != null) {
            String hand1 = str.substring(0, 14);
            String hand2 = str.substring(15);
            PokerHand pokerHand1 = new PokerHand(hand1);
            PokerHand pokerHand2 = new PokerHand(hand2);
            int compare = pokerHand1.compareTo(pokerHand2);
            if (compare == 1) {
               count++;
            }
         }
         return from(count);
      }
   }

   @PEProblem(problem = 55, description = "How many Lychrel numbers are there below ten-thousand?")
   public PeResult problem55() {
      int max = 10000;
      int count = 0;
      int iterate = 0;
      for (int i = 0; i < max; ++i) {
         BigInteger bigInteger = new BigInteger(i + "");
         iterate = 0;
         boolean isLychrel = true;
         while (iterate < 50) {
            iterate++;
            BigInteger reverse = MathUtils.reverseBigInteger(bigInteger);
            BigInteger sum = bigInteger.add(reverse);
            if (MathUtils.isPalindromeBiginteger(sum)) {
               isLychrel = false;
               break;
            }
            bigInteger = sum;
         }
         if (isLychrel) {
            count++;
         }
      }

      return from(count);
   }

   @PEProblem(problem = 56, description = "Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?")
   public PeResult problem56() {
      final int maxExclusive = 100;
      OptionalLong optionalLong = IntStream
            .range(2, maxExclusive)
            .mapToLong(i -> {
               long maxDigitalSum = i;
               BigInteger currentNumber = BigInteger.valueOf(i);
               BigInteger curretnBigInteger = currentNumber;
               for (int j = 2; j < maxExclusive; ++j) { // start from ^2
                     curretnBigInteger = curretnBigInteger
                           .multiply(currentNumber);
                     long digitalSum = MathUtils
                           .getDigitalSum(curretnBigInteger);
                     if (digitalSum > maxDigitalSum) {
                        maxDigitalSum = digitalSum;
                     }
                  }
                  return maxDigitalSum;
               }).max();
      return from(optionalLong.getAsLong());
   }

   @PEProblem(problem = 56, description = "Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?")
   public PeResult problem56_2() {
      long result = 0;
      final int maxExclusive = 100;
      for (int i = maxExclusive - 1; i > 1; --i) {
         for (int j = i; j > 1; --j) {
            if (result > (int) 9 * j * Math.log10(i)) {
               break;
            }
            BigInteger bigInteger = BigInteger.valueOf(i).pow(j);
            long digitalSum = MathUtils.getDigitalSum(bigInteger);
            if (digitalSum > result) {
               result = digitalSum;
            }
         }
      }
      return from(result);
   }

   @PEProblem(problem = 57, description = "In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?")
   public PeResult problem57() {
      final int MAX_EXPANSION = 1000;
      BigInteger numerator = BigInteger.valueOf(1);
      BigInteger denominator = BigInteger.valueOf(1);
      BigInteger two = BigInteger.valueOf(2);
      int resultCount = 0;
      int expansionCount = 0;
      BigInteger currentNumerator;
      BigInteger currentDenominator;
      while (expansionCount < MAX_EXPANSION) {
         expansionCount++;
         currentNumerator = denominator.multiply(two).add(numerator);
         currentDenominator = denominator.add(numerator);
         if (MathUtils.compareNumberOfDigits(currentNumerator,
               currentDenominator) > 0) {
            resultCount++;
         }
         numerator = currentNumerator;
         denominator = currentDenominator;
      }

      return from(resultCount);
   }
}
