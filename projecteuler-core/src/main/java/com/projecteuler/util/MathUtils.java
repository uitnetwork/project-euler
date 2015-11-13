package com.projecteuler.util;

import static java.util.stream.LongStream.rangeClosed;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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

      long[] primes = getPrimeNumberArrayBelowMax(n);
      long result = 1;
      for (long l : primes) {
         long power = (long) (Math.log(n) / Math.log(l));
         result *= (long) Math.pow(l, power);
      }
      return result;
   }

   // TODO: need refacter using sieve
   public static long[] getPrimeNumberArrayBelowMax(long max) {
      return rangeClosed(2, max).filter(MathUtils::isPrime).toArray();
   }

   // TODO: need refacter using sieve
   public static List<Long> getPrimeNumberListBelowMax(long max) {
      Supplier<List<Long>> supplier = ArrayList<Long>::new;
      ObjLongConsumer<List<Long>> longConsumer = (list, l) -> list.add(l);
      return rangeClosed(2, max).filter(MathUtils::isPrime).collect(supplier,
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
            .filter(MathUtils::isPrime)
            .limit(n - 1)
            .collect(ArrayList<Long>::new,
                  (ArrayList<Long> list, long l) -> list.add(l), null);
      result.addAll(primeNumbers);
      return result;
   }

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
   public static long getNthPrimeNumber(int n) {
      if (n == 1)
         return 2;
      int position = n - 2; // skip 2;
      OptionalLong result = LongStream.iterate(3, l -> l + 2)
            .filter(MathUtils::isPrime).skip(position).findFirst();
      return result.getAsLong();
   }

   // TODO: need refacter using sieve
   public static long sumPrimeNumbersBelow(int n) {
      long result = 2;
      for (int i = 3; i < n; i = i + 2) {
         if (MathUtils.isPrime(i)) {
            result += i;
         }
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
      long[] allDivisors = getAllDivisors(number);
      long[] result = Arrays.copyOf(allDivisors, allDivisors.length - 1);
      return result;
   }

   public static final long getSumOfProperDivisors(long number) {
      long[] properDivisors = getProperDivisors(number);
      return LongStream.of(properDivisors).sum();
   }

   public static final BigInteger getBigIntegerFactorial(long number) {
      BigInteger fact = BigInteger.valueOf(1);
      for (long i = 2; i <= number; i++)
         fact = fact.multiply(BigInteger.valueOf(i));
      return fact;
   }

   public static final long getPermutationOfNumber(int number) {
      if (number == 0)
         return 1;
      return LongStream.rangeClosed(1, number).reduce(1, Math::multiplyExact);
   }

   public static final int getAlphabeticalvalue(String str) {
      int result = 0;
      for (int i = 0; i < str.length(); ++i) {
         result += str.charAt(i) - ('A' - 1);
      }
      return result;
   }

   public static final boolean isAbundantNumber(long number) {
      return getSumOfProperDivisors(number) > number;
   }

   public static final int getRecurringCycleDecimalOfN(int n) {
      List<Integer> tracking = new ArrayList<Integer>();
      boolean[] arrays = new boolean[n * 10];
      int start = 1;

      do {
         if (arrays[start]) {
            int index = tracking.indexOf(start);
            return tracking.size() - index;
         } else {
            tracking.add(start);
            arrays[start] = true;
         }

         int value = start / n;
         if (value > 0) {
            start %= n;
         }
         start *= 10;
      } while (start != 0);
      return 0;
   }

   public static final int getConsecutivePrimesOfNumber(long a, long b) {
      int count = 0;
      for (int i = 0;; i++) {
         long value = i * i + a * i + b;
         if (value < 0)
            value *= -1;
         if (MathUtils.isPrime(value)) {
            count++;
         } else {
            break;
         }
      }
      return count;
   }

   public static final int calculatePossibleCoins(int[] possibleCoins, int total) {
      Arrays.sort(possibleCoins); // make sure in order
      int possibleLength = possibleCoins.length;
      int[][] result = new int[total + 1][possibleLength + 1];

      // one ly one way to split if total is 0
      for (int i = 1; i <= possibleLength; ++i) {
         result[0][i] = 1;
      }

      // only one way to split the money using only 1 cent
      for (int i = 0; i <= total; ++i) {
         result[i][1] = 1;
      }

      for (int i = 1; i <= total; ++i) {
         for (int j = 2; j <= possibleLength; ++j) {
            int newMoney = i - possibleCoins[j - 1];
            if (newMoney < 0) {
               result[i][j] = result[i][j - 1];
            } else {
               result[i][j] = result[i][j - 1] + result[newMoney][j];
            }
         }
      }

      for (int i = 0; i <= total; ++i) {
         for (int j = 0; j <= possibleLength; ++j) {
            System.out.print(result[i][j]);
            System.out.print("   ");
         }
         System.out.println();
      }

      return result[total][possibleLength];
   }

   // assume the input will be valid as check will make the method not
   // performance
   public static final boolean isPandigitalNumber(int number) {
      if (number < 123456789 || number > 987654321) {
         return false;
      }
      boolean[] result = new boolean[10];
      while (number > 0) {
         int digit = number % 10;
         number /= 10;
         if (digit == 0) {
            return false;
         }
         if (!result[digit]) {
            result[digit] = true;
         } else {
            // already true meaning it already occurs before
            return false;
         }
      }
      return true;
   }

   // more performance and correct for number which has n < 9 digits
   public static boolean isPandigitalNumber2(int n) {
      int digits = 0;
      int count = 0;
      int tmp;

      while (n > 0) {
         tmp = digits;
         digits = digits | 1 << (int) ((n % 10) - 1); // using bit, if number
                                                      // the same the return
                                                      // value will be different
                                                      // each time
         if (tmp == digits) {
            return false;
         }

         count++;
         n /= 10;
      }
      return digits == (1 << count) - 1;
   }

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

   public static final List<Long> getListOfPandigitalNumbersIncludeZero() {
      List<Long> result = LongStream
            .rangeClosed(1023456789, 9876543210l)
            .filter(MathUtils::isPandigitalNumberIncludeZero)
            .collect(ArrayList::new,
                  (ArrayList<Long> list, long n) -> list.add(n), null);
      return result;
   }

   public static final List<Integer> getListOfPandigitalNumbers() {
      List<Integer> result = IntStream
            .rangeClosed(123456789, 987654321)
            .filter(MathUtils::isPandigitalNumber)
            .collect(ArrayList::new,
                  (ArrayList<Integer> list, int n) -> list.add(n), null);
      return result;
   }

   public static final List<Integer> getProductOfPandigital(int number) {
      List<Integer> result = new ArrayList<>();
      int end = 10000;
      int suffix = number % end;
      int remain = number / end;
      int start = 10;
      while (remain > start) {
         int operand1 = remain / start;
         int operand2 = remain % start;
         if (operand1 * operand2 == suffix) {
            System.out.println(suffix + " in " + number);
            result.add(suffix);
         }
         start *= 10;
      }
      return result;
   }

   public static final long sumOfNumberHasEqualFactorialOFDigits() {
      int[] factorials = new int[10];
      for (int i = 0; i < factorials.length; ++i) {
         factorials[i] = getBigIntegerFactorial(i).intValueExact();
      }
      long sum = 0;
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
            System.out.println("i is " + i);
            sum += temp;
         }
      }

      return sum;
   }

   public static final boolean containEvenDigit(long value) {
      String str = value + "";
      return str.indexOf('0') > -1 || str.indexOf('2') > -1
            || str.indexOf('4') > -1 || str.indexOf('6') > -1
            || str.indexOf('8') > -1;
   }

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

   public static int createPalindrome(int input, int b, boolean isOdd) {
      int n = input;
      int palin = input;
      if (isOdd) {
         n /= b;
      }

      while (n > 0) {
         palin = palin * b + (n % b);
         n /= b;
      }

      System.out.println("Input: " + input + " return: " + palin);
      return palin;
   }

   public static final boolean isTruncatable(long value) {
      int start = 10;
      while (start < value) {
         // left to right
         long left = value % start;
         if (!isPrime(left)) {
            return false;
         }
         // right to left
         long right = value / start;
         if (!isPrime(right)) {
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

   public static final int getPower(long l) {
      return (int) Math.log10(l);
   }

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
      long result = 0;
      String bigIntegerString = bigInteger.toString();
      for (int i = 0; i < bigIntegerString.length(); ++i) {
         result = result + (bigIntegerString.charAt(i) - '0');
      }
      return result;
   }

   public static final long getDigitalSumByStream(BigInteger bigInteger) {
      if (bigInteger.mod(BigInteger.TEN) == BigInteger.ZERO) {
         return 1;
      }
      return bigInteger.toString().chars().map(i -> i - '0').sum();

   }

   public static final int compareDigits(long l1, long l2) {
      int digit1 = 0;
      int digit2 = 0;
      while (l1 > 0) {
         digit1++;
         l1 /= 10;
      }
      while (l2 > 0) {
         digit2++;
         l2 /= 10;
      }
      return digit1 - digit2;
   }

   public static final int compareDigits(BigInteger bigInteger1,
         BigInteger bigInteger2) {
      return bigInteger1.toString().length() - bigInteger2.toString().length();
   }

   public static void main(String[] args) {
      System.out.println(compareDigits(123, 123456));
      System.out.println(compareDigits(123, 999));
   }

   private static final void validateZeroOrPositive(long number) {
      Assert.isTrue(number >= 0, "n should be zero or positive");
   }
}
