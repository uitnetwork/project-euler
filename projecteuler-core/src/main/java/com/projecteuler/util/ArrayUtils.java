package com.projecteuler.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtils {

   public static final long[] mergeOrder(long[]... arrays) {
      Set<Long> sets = new HashSet<Long>();
      for (int i = 0; i < arrays.length; ++i) {
         List<Long> list = Arrays.stream(arrays[i]).boxed()
               .collect(Collectors.toList());
         sets.addAll(list);
      }
      return sets.stream().mapToLong(Long::intValue).sorted().toArray();
   }

}
