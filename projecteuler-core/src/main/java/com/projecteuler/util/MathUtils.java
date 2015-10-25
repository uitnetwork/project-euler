package com.projecteuler.util;

import static java.util.stream.LongStream.rangeClosed;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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

   public static final boolean isPalindromeNumber(int number, int base) {
      int reversed = 0;
      int k = number;

      while (k > 0) {
         reversed = base * reversed + k % base;
         k /= base;
      }
      return number == reversed;
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

   public static final boolean isPalindromeBinary(int value) {
      String binary = Integer.toBinaryString(value);
      String reverse = new StringBuilder(binary).reverse().toString();
      return binary.equals(reverse);
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

   // 1^2+2^2+.....n^2
   public static long sumSquareZeroToN(long n) {
      return n * (n + 1) * (2 * n + 1) / 6;
   }

   public static long getNthPrimeNumber(int n) {
      if (n == 1)
         return 2;
      int position = n - 2; // skip 2;
      OptionalLong result = LongStream.iterate(3, l -> l + 2)
            .filter(MathUtils::isPrime).skip(position).findFirst();
      return result.getAsLong();
   }

   public static long sumPrimeNumbersBelow(int n) {
      long result = 2;
      for (int i = 3; i < n; i = i + 2) {
         if (MathUtils.isPrime(i)) {
            result += i;
         }
      }
      return result;
   }

   public static int countNumberOfDivisors(long number) {
      int count = 2; // include 1 and itself
      for (long i = 2; i < number / 2; ++i) {
         if (number % i == 0) {
            // System.out.print(i+" ");
            count++;
         }
      }
      return count;
   }

   public static final long countNumberOfDivisors_2(long number) {
      Map<Long, Integer> primeForm = calculatePrimeForm(number);
      long result = 1;
      for (Integer value : primeForm.values()) {
         result *= (value + 1);
      }
      System.out.println(number + " is " + result);
      return result;
   }

   public static final Map<Long, Integer> calculatePrimeForm(long number) {
      Map<Long, Integer> result = new HashMap<Long, Integer>();
      long start = 2;
      while (start <= number) {
         while (number % start == 0) {
            number /= start;
            if (result.containsKey(start)) {
               result.put(start, result.get(start) + 1);
            } else {
               result.put(start, 1);
            }
         }
         ++start;
      }
      return result;
   }

   public static final List<Long> getProperDivisors(long number) {
      List<Long> result = new ArrayList<Long>();
      if (number <= 1)
         return result;
      result.add(1L);

      long sqrtOfNumber = (long) Math.sqrt(number);
      if (sqrtOfNumber * sqrtOfNumber == number) {
         // add sqrtOfNumber only one
         result.add(sqrtOfNumber);
         sqrtOfNumber--;
      }
      long start = 2;
      while (start <= sqrtOfNumber) {
         if (number % start == 0) {
            result.add(start);
            result.add(number / start);
         }
         ++start;
      }
      return result;
   }

   public static final long getSumOfProperDivisors(long number) {
      List<Long> properDivisors = getProperDivisors(number);
      long result = 0;
      for (Long divisor : properDivisors) {
         result += divisor;
      }
      return result;
   }

   public static final BigInteger getFactorial(int number) {
      BigInteger fact = BigInteger.valueOf(1);
      for (int i = 1; i <= number; i++)
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
         factorials[i] = getFactorial(i).intValueExact();
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

   public static void main(String[] args) {
      System.out.println(isPandigitalNumberIncludeZero(1023456789));
      System.out.println(isPandigitalNumberIncludeZero(123456789));
   }
}
