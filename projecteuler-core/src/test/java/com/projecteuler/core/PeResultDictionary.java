package com.projecteuler.core;

import java.util.HashMap;
import java.util.Map;

public class PeResultDictionary {

   private static final Map<Integer, Long> RESULT_DICTIONARY = new HashMap<Integer, Long>();

   static {
      RESULT_DICTIONARY.put(1, 233168L);
      RESULT_DICTIONARY.put(2, 4613732L);
      RESULT_DICTIONARY.put(3, 6857L);
      RESULT_DICTIONARY.put(4, 906609L);
      RESULT_DICTIONARY.put(5, 232792560L);
      RESULT_DICTIONARY.put(6, 25164150L);
      RESULT_DICTIONARY.put(7, 104743L);
      RESULT_DICTIONARY.put(8, 23514624000L);
      RESULT_DICTIONARY.put(9, 31875000L);
      RESULT_DICTIONARY.put(10, 142913828922L);
      RESULT_DICTIONARY.put(11, 70600674L);
      RESULT_DICTIONARY.put(12, 76576500L);
      RESULT_DICTIONARY.put(13, 5537376230L);
      RESULT_DICTIONARY.put(14, 837799L);
      RESULT_DICTIONARY.put(15, 137846528820L);
      RESULT_DICTIONARY.put(16, 1366L);
      RESULT_DICTIONARY.put(17, 21124L);
      RESULT_DICTIONARY.put(18, 1074L);
      RESULT_DICTIONARY.put(19, 171L);
      RESULT_DICTIONARY.put(20, 648L);
      RESULT_DICTIONARY.put(21, 31626L);
      RESULT_DICTIONARY.put(22, 871198282L);
      RESULT_DICTIONARY.put(23, 4179871L);
      RESULT_DICTIONARY.put(24, 2783915460L);
      RESULT_DICTIONARY.put(25, 4782L);
      RESULT_DICTIONARY.put(26, 983L);
      RESULT_DICTIONARY.put(27, -59231L);
      RESULT_DICTIONARY.put(28, 669171001L);
      RESULT_DICTIONARY.put(29, 9183L);
      RESULT_DICTIONARY.put(30, 443839L);
      RESULT_DICTIONARY.put(31, 73682L);
      RESULT_DICTIONARY.put(32, 45228L);
      RESULT_DICTIONARY.put(33, 100L);
      RESULT_DICTIONARY.put(34, 40730L);
      RESULT_DICTIONARY.put(35, 55L);
      RESULT_DICTIONARY.put(36, 872187L);
      RESULT_DICTIONARY.put(37, 748317L);
      RESULT_DICTIONARY.put(38, 932718654L);
      RESULT_DICTIONARY.put(39, 840L);
      RESULT_DICTIONARY.put(40, 210L);
      RESULT_DICTIONARY.put(41, 7652413L);
      RESULT_DICTIONARY.put(42, 162L);
      RESULT_DICTIONARY.put(43, 16695334890L);
      RESULT_DICTIONARY.put(44, 5482660L);
      RESULT_DICTIONARY.put(45, 1533776805L);
      RESULT_DICTIONARY.put(46, 5777L);
      RESULT_DICTIONARY.put(47, 134043L);
      RESULT_DICTIONARY.put(48, 9110846700L);
      RESULT_DICTIONARY.put(49, 296962999629L);
      RESULT_DICTIONARY.put(50, 997651L);
      RESULT_DICTIONARY.put(51, 121313L);
      RESULT_DICTIONARY.put(52, 142857L);
      RESULT_DICTIONARY.put(53, 4075L);
      RESULT_DICTIONARY.put(54, 376L);
      RESULT_DICTIONARY.put(55, 249L);
      RESULT_DICTIONARY.put(56, 972L);
      RESULT_DICTIONARY.put(57, 153L);
      RESULT_DICTIONARY.put(58, 26241L);
      RESULT_DICTIONARY.put(59, 107359L);
      RESULT_DICTIONARY.put(60, 26033L);
      RESULT_DICTIONARY.put(61, 28684L);
   }

   public static final long getResult(Integer challengeNumber) {
      return RESULT_DICTIONARY.get(challengeNumber);
   }

   public static final int currentChallenge() {
      return RESULT_DICTIONARY.size();
   }

}
