package com.projecteuler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.ObjLongConsumer;
import java.util.stream.LongStream;

import org.springframework.util.Assert;

public class MathUtils {

   /**
    * Return the sum from 0(zero) to n
    * 
    * @param
    * @return sum to n
    */
   public static final long sumToN(long n) {
      validateZeroOrPositive(n);

      return n * (n + 1) / 2;
   }

   // 1^2+2^2+.....n^2
   public static long sumSquaresToN(long n) {
      validateZeroOrPositive(n);

      return n * (n + 1) * (2 * n + 1) / 6;
   }

   public static final long getLargestPrimeFactor(long number) {
      validateZeroOrPositive(number);

      long result = 1;
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
   public static boolean isPalindromeNumber(long number) {
      validateZeroOrPositive(number);

      if (number < 0)
         return false;
      int div = 1;
      while (number / div >= 10) {
         div *= 10;
      }

      while (number != 0) {
         long left = number / div;
         long right = number % 10;
         if (left != right)
            return false;
         number = (number % div) / 10;
         div /= 100;
      }
      return true;
   }

   public static final boolean isPalindromeBiginteger(BigInteger bigInteger) {
      String origin = bigInteger.toString();
      String reverse = (new StringBuilder(origin)).reverse().toString();
      return origin.equals(reverse);
   }

   public static final boolean isPalindromeNumberInBase(long number, int base) {
      validateZeroOrPositive(number);
      validateZeroOrPositive(base);

      long reverseNumber = 0;
      long remainder = number;

      while (remainder > 0) {
         reverseNumber = base * reverseNumber + remainder % base;
         remainder /= base;
      }
      return number == reverseNumber;
   }

   public static final long reverseNumber(long number) {
      validateZeroOrPositive(number);

      long reverseNumber = 0;
      while (number > 0) {
         reverseNumber = reverseNumber * 10 + number % 10;
         number /= 10;
      }
      return reverseNumber;
   }

   public static final BigInteger reverseBigInteger(BigInteger bigInteger) {
      String origin = bigInteger.toString();
      String reverse = (new StringBuilder(origin)).reverse().toString();
      return new BigInteger(reverse);
   }

   public static long gcd(long number1, long number2) {
      validateZeroOrPositive(number1);
      validateZeroOrPositive(number2);

      if (number1 == 0)
         return number2;
      while (number2 != 0) {
         number1 %= number2;
         number1 ^= number2;
         number2 ^= number1;
         number1 ^= number2;
         // if (a > b)
         // a = a - b;
         // else
         // b = b - a;
      }
      return number1;
   }

   public static final long lcd(long number1, long number2) {
      validateZeroOrPositive(number1);
      validateZeroOrPositive(number2);

      return number1 / gcd(number1, number2) * number2; // number1*number2 may >
                                                        // Long.MAX_VALUE
   }

   public static final long lcdToN(long n) {
      validateZeroOrPositive(n);

      long result = 1;
      for (long i = 2; i <= n; ++i) {
         result = lcd(result, i);
      }
      return result;
   }

   public static final long lcdToNUsingPrime(long n) {
      validateZeroOrPositive(n);

      long[] primes = PrimeUtils.getPrimeNumberArrayBelowMax(n);
      long result = 1;
      for (long l : primes) {
         long power = (long) (Math.log(n) / Math.log(l));
         result *= (long) Math.pow(l, power);
      }
      return result;
   }

   @SuppressWarnings("unused")
   // for reference only
   private static int __countNumberOfDivisors(long number) {
      int count = 2; // include 1 and itself
      for (long i = 2; i < number / 2; ++i) {
         if (number % i == 0) {
            count++;
         }
      }
      return count;
   }

   public static final long countNumberOfDivisors(long number) {
      validateZeroOrPositive(number);

      long result = 1;

      long start = 2;
      int count;
      while (start <= number) {
         count = 0;
         while (number % start == 0) {
            number /= start;
            count++;
         }
         if (count > 0) {
            result *= (count + 1);
         }
         ++start;
      }
      return result;
   }

   public static final long[] getAllDivisors(long number) {
      validateZeroOrPositive(number);

      long sqrtOfNumber = (long) Math.sqrt(number);
      long[] result = LongStream.rangeClosed(1, sqrtOfNumber)
            .filter(l -> number % l == 0).flatMap(l -> {
               long remainder = number / l;
               if (remainder == l) {
                  return LongStream.of(l);
               } else {
                  return LongStream.of(l, remainder);
               }
            }).toArray();

      Arrays.sort(result);
      return result;
   }

   public static final long[] getProperDivisors(long number) {
      validateZeroOrPositive(number);

      long[] allDivisors = getAllDivisors(number);
      long[] result = Arrays.copyOf(allDivisors, allDivisors.length - 1);
      return result;
   }

   public static final long getSumOfProperDivisors(long number) {
      validateZeroOrPositive(number);

      long[] properDivisors = getProperDivisors(number);
      return LongStream.of(properDivisors).sum();
   }

   public static final BigInteger getFactorialBigInteger(long number) {
      validateZeroOrPositive(number);

      BigInteger fact = BigInteger.valueOf(1);
      for (long i = 2; i <= number; i++)
         fact = fact.multiply(BigInteger.valueOf(i));
      return fact;
   }

   public static final long getFactorial(long number) {
      validateZeroOrPositive(number);

      if (number == 0) {
         return 1;
      }

      return LongStream.rangeClosed(1, number).reduce(1, Math::multiplyExact);
   }

   /**
    * Return the total of each character in the String
    * 
    * @param sr
    * @return
    */
   public static final int getAlphabeticalValue(String str) {
      Assert.notNull(str, "Input string must be not null");

      int result = 0;
      for (int i = 0; i < str.length(); ++i) {
         result += str.charAt(i) - ('A' - 1);
      }
      return result;
   }

   public static final boolean isAbundantNumber(long number) {
      validateZeroOrPositive(number);

      return getSumOfProperDivisors(number) > number;
   }

   /**
    * return the number of recurring digits in decimal fraction part of 1/n
    * 
    * @param number
    * @return
    */
   // TODO: refactor
   public static final int getNumberOfRecurringDigitsInDecimalFractionPart(
         int number) {
      validateZeroOrPositive(number);

      List<Integer> tracking = new ArrayList<Integer>();
      boolean[] arrays = new boolean[number * 10];
      int start = 1;

      do {
         if (arrays[start]) {
            int index = tracking.indexOf(start);
            return tracking.size() - index;
         } else {
            tracking.add(start);
            arrays[start] = true;
         }

         int value = start / number;
         if (value > 0) {
            start %= number;
         }
         start *= 10;
      } while (start != 0);

      return 0;
   }

   /**
    * Return true if the number passed is pandigital (does not support zero)
    * TODO: support zero
    * 
    * @param number
    * @return
    */
   public static boolean isPandigitalNumber(long number) {
      long digits = 0;
      int count = 0;
      long tmp;

      while (number > 0) {
         tmp = digits;
         digits = digits | 1 << (long) ((number % 10) - 1); // using bit, if
                                                            // number
         // the same the return
         // value will be different
         // each time
         if (tmp == digits) {
            return false;
         }

         count++;
         number /= 10;
      }
      return digits == (1 << count) - 1;
   }

   /**
    * Return true if the number passed is pandigital (do support zero) TODO:
    * support zero
    * 
    * @param number
    * @return
    */
   public static final boolean isPandigitalNumberIncludeZero(long number) {
      if (number < 1023456789 || number > 9876543210l) {
         return false;
      }
      boolean[] result = new boolean[10];
      while (number > 0) {
         int digit = (int) (number % 10);
         number /= 10;
         if (!result[digit]) {
            result[digit] = true;
         } else {
            // already true meaning it already occurs before
            return false;
         }
      }
      return true;
   }

   // TODO: should be refactor + unit test
   public static final long[] getListOfPandigitalNumbersIncludeZero() {
      long[] result = LongStream.rangeClosed(1023456789, 9876543210l)
            .filter(MathUtils::isPandigitalNumberIncludeZero).toArray();
      return result;
   }

   // TODO: should be refactor + unit test
   public static final long[] getListOfPandigitalNumbers() {
      long[] result = LongStream.rangeClosed(123456789, 987654321)
            .filter(MathUtils::isPandigitalNumber).toArray();
      return result;
   }

   // TODO: should be refactor + unit test
   public static final List<Long> getProductOfPandigital(long number) {
      List<Long> result = new ArrayList<>();
      int end = 10000;
      long suffix = number % end;
      long remain = number / end;
      int start = 10;
      while (remain > start) {
         long operand1 = remain / start;
         long operand2 = remain % start;
         if (operand1 * operand2 == suffix) {
            System.out.println(suffix + " in " + number);
            result.add(suffix);
         }
         start *= 10;
      }
      return result;
   }

   public static final boolean hasEvenDigit(long number) {
      validateZeroOrPositive(number);

      boolean hasEvenDigit = false;
      while (number > 0) {
         long digit = number % 10;
         if (digit % 2 == 0) {
            hasEvenDigit = true;
            break;
         }
         number /= 10;
      }
      return hasEvenDigit;
   }

   // TODO: should be refactor + unit test
   public static Set<Long> getAllPermutationsOfNumber(long value) {
      Set<String> allPermutations = getAllPermutationsOfString(value + "");
      ObjLongConsumer<Set<Long>> consumer = (s, l) -> {
         s.add(l);
      };
      Set<Long> result = allPermutations.stream().mapToLong(Long::valueOf)
            .collect(HashSet<Long>::new, consumer, null);
      return result;
   }

   private static Set<String> getAllPermutationsOfString(String value) {
      return getAllPermutationsOfString("", value);
   }

   private static Set<String> getAllPermutationsOfString(String prefix,
         String value) {
      Set<String> result = new HashSet<String>();
      if (value.length() <= 1) {
         result.add(prefix + value);
      } else {
         int length = value.length();
         for (int i = 0; i < length; ++i) {
            StringBuilder builder = new StringBuilder(value);
            builder.deleteCharAt(i);
            result.addAll(getAllPermutationsOfString(prefix + value.charAt(i),
                  builder.toString()));
         }
      }
      return result;
   }

   public static Set<Long> getCircularNumbers(long value) {
      Set<Long> result = new HashSet<Long>();
      int digitLength = (int) (Math.log10(value) + 1);
      int[] digits = new int[digitLength];
      int temp = digitLength;
      while (value > 0) {
         digits[--temp] = (int) value % 10;
         value /= 10;
      }
      int count = 0;
      while (count < digitLength) {
         int begin = count;
         long total = 0;
         for (int i = 0; i < digitLength; ++i) {
            int part = digits[(begin + i) % digitLength]
                  * (int) Math.pow(10, digitLength - 1 - i);
            total += part;
         }
         result.add(total);
         count++;
      }

      return result;
   }

   /**
    * Return true if the number is also a prime after removing digit left to
    * right and also right to left
    * 
    * @param number
    * @return
    */
   public static final boolean isTruncatablePrime(long number) {
      validateZeroOrPositive(number);

      int start = 10;
      while (start < number) {
         // left to right
         long left = number % start;
         if (!PrimeUtils.isPrime(left)) {
            return false;
         }
         // right to left
         long right = number / start;
         if (!PrimeUtils.isPrime(right)) {
            return false;
         }
         start *= 10;
      }

      return true;
   }

   public static final boolean isPentagonalNumber(long number) {
      double n = (1 + Math.sqrt(1 + 24 * number)) / 6;
      return n == (long) n;
   }

   public static final boolean isHexagonalNumber(long number) {
      double n = (1 + Math.sqrt(1 + 8 * number)) / 4;
      return n == (long) n;
   }

   public static final boolean sameDigits6Times(long number) {
      long[] checkNumbers = { number * 2, number * 3, number * 4, number * 5,
            number * 6 };
      boolean[] validates = new boolean[10];
      int length = 0;
      long num = number;
      while (num > 0) {
         int digit = (int) num % 10;
         num /= 10;
         validates[digit] = true;
         length++;
      }
      for (long l : checkNumbers) {
         int currentLength = 0;
         while (l > 0) {
            int digit = (int) l % 10;
            l /= 10;
            if (!validates[digit]) {
               return false;
            }
            currentLength++;
         }
         if (currentLength != length) {
            return false;
         }
      }
      return true;
   }

   public static final int getExponentOf10(long number) {
      return (int) Math.log10(number);
   }

   // TODO. Need refactor + unit test
   public static final boolean isCombinationGreaterThan(int n, int r, int power) {
      double result = 0;
      int limit = n - r;
      for (int i = n; i > limit; --i) {
         result += Math.log10(i);
      }
      for (int i = r; i > 0; --i) {
         result -= Math.log10(i);
      }
      return result > 6;
   }

   public static final long getDigitalSum(BigInteger bigInteger) {
      if (bigInteger.mod(BigInteger.TEN) == BigInteger.ZERO) {
         return 1;
      }
      return bigInteger.toString().chars().map(i -> i - '0').sum();
   }

   public static final int compareNumberOfDigits(BigInteger bigInteger1,
         BigInteger bigInteger2) {
      return bigInteger1.toString().length() - bigInteger2.toString().length();
   }

   private static final void validateZeroOrPositive(long number) {
      Assert.isTrue(number >= 0, "n should be zero or positive");
   }
}
