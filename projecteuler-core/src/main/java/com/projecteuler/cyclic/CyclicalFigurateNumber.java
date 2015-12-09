package com.projecteuler.cyclic;

import lombok.Getter;

public class CyclicalFigurateNumber {

   private int[][] allNumbers;

   @SuppressWarnings("unused")
   private int[] numberIndexes;

   private int[] chosenIndexes;

   private int[] arrayIndexes;

   private int indexLength;
   
   @Getter
   private int result;

   public CyclicalFigurateNumber(int[][] allNumbers, int[] numberIndexes) {
      this.allNumbers = allNumbers;
      this.indexLength = numberIndexes.length;
      this.numberIndexes = numberIndexes;
      chosenIndexes = new int[indexLength];
      arrayIndexes = new int[indexLength];

   }

   public void sumCyclicNumbers(int index) {
      if (index == 6) {
         int arrayIndexStart = arrayIndexes[0];
         int arrayIndexEnd = arrayIndexes[index - 1];
         int start = allNumbers[arrayIndexStart][chosenIndexes[0]] / 100;
         int end = allNumbers[arrayIndexEnd][chosenIndexes[index - 1]] % 100;
         if (start == end) {
            String str = "";
            int sum = 0;
            for (int i = 0; i < chosenIndexes.length; ++i) {
               str += allNumbers[arrayIndexes[i]][chosenIndexes[i]] + ",";
               sum += allNumbers[arrayIndexes[i]][chosenIndexes[i]];
            }
            System.out.println("Found: " + str + " with sum: " + sum);
            result=sum;
         }
         return;
      }

      if (index == 0) {
         arrayIndexes[0] = 0;
         for (int i = 0; i < allNumbers[0].length; ++i) {
            chosenIndexes[0] = i;
            for (int j = 1; j < indexLength; ++j) {
               arrayIndexes[j] = -1;
            }
            sumCyclicNumbers(index + 1);
         }
      } else {
         int previousEnd = allNumbers[arrayIndexes[index - 1]][chosenIndexes[index - 1]] % 100;
         int start = previousEnd * 100;
         int end = start + 99;
         for (int i = 1; i < allNumbers.length; ++i) {
            for (int j = index + 1; j < indexLength; ++j) {
               arrayIndexes[j] = -1;
            }
            boolean existInArray = false;
            for (int k = 0; k < arrayIndexes.length; ++k) {
               if (arrayIndexes[k] == i) {
                  existInArray = true;
                  break;
               }
            }
            if (existInArray) {
               continue; // skip because already have that index
            }

            arrayIndexes[index] = i;

            for (int h = 0; h < allNumbers[i].length; ++h) {
               if (allNumbers[i][h] < start) {
                  continue;
               }
               if (allNumbers[i][h] > end) {
                  break;
               }
               chosenIndexes[index] = h;
               sumCyclicNumbers(index + 1);
            }
         }
      }
   }

   public static void main(String[] args) {
      

   }
}
