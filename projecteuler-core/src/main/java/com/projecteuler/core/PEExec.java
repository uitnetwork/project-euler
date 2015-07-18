package com.projecteuler.core;

import static com.projecteuler.util.MathUtils.getLargestPrimeFactor;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN_2;
import static com.projecteuler.util.MathUtils.isPalindromeNumber;
import static com.projecteuler.util.MathUtils.sumMultiplesOfANumberBelowMax;
import static com.projecteuler.util.MathUtils.sumSquareZeroToN;
import static com.projecteuler.util.MathUtils.sumZeroToN;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.ToLongFunction;
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
            + MathUtils.getnthPrimeNumber(10001));
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
}
