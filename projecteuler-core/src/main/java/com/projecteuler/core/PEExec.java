package com.projecteuler.core;

import static com.projecteuler.util.MathUtils.getLargestPrimeFactor;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN_2;
import static com.projecteuler.util.MathUtils.isPalindromeNumber;
import static com.projecteuler.util.MathUtils.sumMultiplesOfANumberBelowMax;
import static com.projecteuler.util.MathUtils.sumSquareZeroToN;
import static com.projecteuler.util.MathUtils.sumZeroToN;

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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.TreeMap;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.projecteuler.annotation.PEProblem;
import com.projecteuler.model.LongHolder;
import com.projecteuler.util.MathUtils;

public class PEExec {

   @PEProblem(problem = 1, description = "Find the sum of all the multiples of 3 or 5 below 1000")
   public void problem1() {
      long max = 1000;
      long anwser = sumMultiplesOfANumberBelowMax(3, max)
            + sumMultiplesOfANumberBelowMax(5, max)
            - sumMultiplesOfANumberBelowMax(15, max);

      System.out.println("Anwser: " + anwser);
   }

   @PEProblem(problem = 2, description = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.")
   public void problem2_1() {
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
      System.out.println("Result: " + result.getValue());
   }

   @PEProblem(problem = 2, description = "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.")
   public void problem2_2() {
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
      System.out.println("Result: " + result);
   }

   @PEProblem(problem = 3, description = "What is the largest prime factor of the number 600851475143?")
   public void problem3() {
      System.out.println("Result: " + getLargestPrimeFactor(600851475143L));
   }

   @PEProblem(problem = 4, description = "Find the largest palindrome made from the product of two 3-digit numbers")
   public void problem4() {
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
      System.out.println("Result: " + result);
   }

   @PEProblem(problem = 5, description = "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?")
   public void problem5_1() {
      System.out.println("Result: " + getSmallestCommonMultipleFrom1ToN(20));
   }

   @PEProblem(problem = 5, description = "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?")
   public void problem5_2() {
      System.out.println("Result: " + getSmallestCommonMultipleFrom1ToN_2(200));
   }

   @PEProblem(problem = 6, description = "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.")
   public void problem6() {
      long n = 100;
      System.out
            .println("Result: "
                  + Math.abs(sumSquareZeroToN(n)
                        - (long) Math.pow(sumZeroToN(n), 2)));
   }

   @PEProblem(problem = 7, description = "What is the 10 001st prime number?")
   public void problem7() {
      System.out.println("Result for 10001: "
            + MathUtils.getNthPrimeNumber(10001));
   }

   @PEProblem(problem = 8, description = "Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?")
   public void problem8() {
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
      System.out.println("Result: " + optionalLong.getAsLong());
   }

   @PEProblem(problem = 9, description = "There exists exactly one Pythagorean triplet for which a + b + c = 1000.Find the product abc")
   public void problem9() {
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
      System.out.println("Result: " + result);
   }

   @PEProblem(problem = 10, description = "Find the sum of all the primes below two million")
   public void problem10() {
      System.out.println("Result: " + MathUtils.sumPrimeNumbersBelow(2000000));

   }

   @PEProblem(problem = 11, description = "What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?")
   public void problem11() {
      System.out.println("Result: 1788696 (solved by searching :D)");

   }

   @PEProblem(problem = 12, description = "What is the value of the first triangle number to have over five hundred divisors?")
   public void problem12() {
      long number = 1;
      long added = 2;
      while (true) {
         number += added++;
         if (MathUtils.countNumberOfDivisors_2(number) > 500) {
            break;
         }
      }
      System.out.println("Result: " + number);
   }

   @PEProblem(problem = 13, description = "Work out the first ten digits of the sum of the following one-hundred 50-digit numbers")
   public void problem13() {
      System.out.println("Result: " + 5537376230L);
   }

   @PEProblem(problem = 14, description = "Which starting number, under one million, produces the longest chain? (Longest Collatz sequence)")
   public void problem14() {
      int max = 0;
      long value = 0L;
      Map<Long, Integer> result = new TreeMap<Long, Integer>();
      result.put(1L, 1);
      for (long i = 2; i < 10000000; ++i) {
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
      System.out.println("Result: " + value + " with length: " + max);
   }

   @PEProblem(problem = 15, description = "How many such routes are there through a 20×20 grid?")
   public void problem15() {
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
      System.out.println("Result: " + arrays[0][0]);
   }

   @PEProblem(problem = 16, description = "What is the sum of the digits of the number 2^1000?")
   public void problem16() {
      BigInteger two = new BigInteger("2");
      BigInteger value = two.pow(1000);
      System.out.println(value);
      int sum = 0;
      while (value != BigInteger.ZERO) {
         BigInteger remainder = value.remainder(BigInteger.TEN);
         sum += remainder.intValue();
         value = value.divide(BigInteger.TEN);
      }
      System.out.println("Result: " + sum);
   }

   @PEProblem(problem = 17, description = "If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?")
   public void problem17() {
      System.out.println("Result: " + 21124);
   }

   @PEProblem(problem = 18, description = "Find the maximum total from top to bottom of the triangle below")
   public void problem18() {
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
      System.out.println("Result: " + result[0][0]);
   }

   @PEProblem(problem = 19, description = "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?")
   public void problem19() {
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
      System.out.println("Result: " + count);
   }

   @PEProblem(problem = 20, description = "Find the sum of the digits in the number 100!")
   public void problem20() {
      BigInteger oneHundredFactorial = MathUtils.getFactorial(100);
      BigInteger value = oneHundredFactorial;
      int sum = 0;
      while (value != BigInteger.ZERO) {
         BigInteger remainder = value.remainder(BigInteger.TEN);
         sum += remainder.intValue();
         value = value.divide(BigInteger.TEN);
      }
      System.out.println("Result: " + sum);
   }

   @PEProblem(problem = 21, description = "Evaluate the sum of all the amicable numbers under 10000")
   public void problem21() {
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
      System.out.println("Result: " + sum);
   }

   @PEProblem(problem = 22, description = "What is the total of all the name scores in the file?")
   public void problem22() throws IOException {
      InputStream input = PEExec.class
            .getResourceAsStream("/input/p022_names.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      String str = reader.readLine();
      input.close();

      str = str.replaceAll("\"", "");
      String[] strArrays = str.split(",");
      Arrays.sort(strArrays);
      long result = 0;
      int i = 1;
      for (String tmp : strArrays) {
         result += i * MathUtils.getAlphabeticalvalue(tmp);
         i++;
      }
      System.out.println("Result: " + result);
   }

   @PEProblem(problem = 23, description = "Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.")
   public void problem23() {
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
      long total = MathUtils.sumZeroToN(max);
      long sum = 0;
      for (int i = 1; i < result.length; ++i) {
         if (result[i]) {
            sum += i;
         }
      }

      System.out.println("Result: " + (total - sum));
   }

   @PEProblem(problem = 24, description = "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?")
   public void problem24() {
      int position = 1000000;
      int start = 0;
      while (MathUtils.getPermutationOfNumber(++start) < position) {
         // donothing
      }
      start--;
      int currentSum = 0;
      Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
      for (int i = start; i > 0; --i) {
         int currentMark = 0;
         while (true) {
            if ((currentSum + currentMark * MathUtils.getPermutationOfNumber(i)) > position) {
               break;
            }
            currentMark++;
         }
         currentMark--;
         currentSum += currentMark * MathUtils.getPermutationOfNumber(i);
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

      System.out.println("Result: " + result.toString());
   }

   @PEProblem(problem = 24, description = "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?")
   public void problem24_2() {
      long position = 1000000;
      List<Integer> list = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4,
            5, 6, 7, 8, 9));
      StringBuilder result = new StringBuilder();
      int start = 9;
      while (position > 0) {
         long value = MathUtils.getPermutationOfNumber(start);
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

      System.out.println("Result: " + result.toString());
   }

   @PEProblem(problem = 25, description = "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?")
   public void problem25() {
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
      System.out.println("Result: " + cnt);
   }

   @PEProblem(problem = 26, description = "Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part")
   public void problem26() {
      int max = 1000 - 1;
      int result = -1;
      int currentLongestRecurring = 0;
      for (int i = max; i > 1; --i) {
         if (i < currentLongestRecurring) {
            break; // i lower than currentLongestRecurring, it's impossible to
                   // get a result which is greater that that value because
                   // there is only i-1 remainder
         }
         int recurring = MathUtils.getRecurringCycleDecimalOfN(i);
         if (recurring > currentLongestRecurring) {
            currentLongestRecurring = recurring;
            result = i;
         }
      }
      System.out.println("Result: " + result + " with "
            + currentLongestRecurring + " recurring numbers in decimal part!");
   }

   @PEProblem(problem = 27, description = "Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.")
   public void problem27() {
      long max = 1000;
      List<Long> primes = MathUtils.getPrimeNumbersBelowMax(max);
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
            int tmp = MathUtils.getConsecutivePrimesOfNumber(prime, i);
            if (tmp > maxConsecutive) {
               maxConsecutive = tmp;
               resultA = i;
               resultB = prime;
            }
         }
      }
      System.out.println("Result: a=" + resultA + " and b=" + resultB
            + " and product: " + (resultA * resultB) + " and maxConsecutive: "
            + maxConsecutive);

   }

   @PEProblem(problem = 28, description = "What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?")
   public void problem28() {
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

      System.out.println("Result: " + result);

   }
}
