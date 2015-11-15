package com.projecteuler.util;

import java.util.Arrays;

public class CoinUtils {
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

}
