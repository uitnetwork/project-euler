package com.projecteuler.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtils {

   public static final int[] mergeOrder(int[]... arrays) {
      Set<Integer> sets = new HashSet<Integer>();
      for (int i = 0; i < arrays.length; ++i) {
         List<Integer> list = Arrays.stream(arrays[i]).boxed()
               .collect(Collectors.toList());
         sets.addAll(list);
      }
      return sets.stream().mapToInt(Integer::intValue).sorted().toArray();
   }

   public static final boolean isDuplicated(long... numbers) {
      boolean result = false;
      Set<Long> longSet = new HashSet<Long>();
      for (long number : numbers) {
         if (longSet.contains(number)) {
            result = true;
            break;
         }
         longSet.add(number);
      }
      return result;
   }

   public static final int[] arrayContainsNumber(int number, int[]... arrays) {
      int[] result = new int[arrays.length];
      int count = 0;
      for (int i = 0; i < arrays.length; ++i) {
         if (Arrays.binarySearch(arrays[i], number) >= 0) {
            result[count++] = i;
         }
      }
      return Arrays.copyOf(result, count);
   }

   public static final int[] indexOfNumber(int number, int[]... arrays) {
      int[] result = new int[arrays.length];
      int count = 0;
      int index=0;
      for (int i = 0; i < arrays.length; ++i) {
         if ((index=Arrays.binarySearch(arrays[i], number)) >= 0) {
            result[count++] = index;
         }
      }

      return Arrays.copyOf(result, count);
   }

}
