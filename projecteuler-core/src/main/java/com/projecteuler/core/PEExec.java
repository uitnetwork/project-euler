package com.projecteuler.core;

import static com.projecteuler.util.MathUtils.getLargestPrimeFactor;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN;
import static com.projecteuler.util.MathUtils.getSmallestCommonMultipleFrom1ToN_2;
import static com.projecteuler.util.MathUtils.isPalindromeNumber;
import static com.projecteuler.util.MathUtils.sumMultiplesOfANumberBelowMax;
import static com.projecteuler.util.MathUtils.sumSquareZeroToN;
import static com.projecteuler.util.MathUtils.sumZeroToN;

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
      System.out.println("Result for 10001: "+MathUtils.getnthPrimeNumber(10001));
   }
}
