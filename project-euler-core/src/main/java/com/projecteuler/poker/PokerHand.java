package com.projecteuler.poker;

import java.util.Arrays;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

   private String pokerHandStr;
   private boolean flush = false;
   private int[] pokerHands = new int[5];
   private int[] pokerCounter = new int[15];
   private int maxSameCardCount = 0;
   private int maxSameCardValue = 0;
   private HandState handState;
   private int fourSameCardValue = -1;
   private int threeSameCardValue = -1;
   private int firstPairCardValue = -1;
   private int secondPairCardvalue = -1;

   public PokerHand(String pokerHandStr) {
      this.pokerHandStr = pokerHandStr;
      initFlush();
      initPokerHandWithOrder();
      initHandState();
   }

   private void initFlush() {
      char firstSuite = pokerHandStr.charAt(suiteIndexes[0]);
      boolean currentFlush=true;
      for (int i = 1; i < suiteIndexes.length; ++i) {
         if (firstSuite != pokerHandStr.charAt(suiteIndexes[i])) {
            currentFlush = false;
            break;
         }
      }
      flush=currentFlush;
   }

   private void initPokerHandWithOrder() {
      for (int i = 0; i < valueIndexes.length; ++i) {
         char value = pokerHandStr.charAt(valueIndexes[i]);
         switch (value) {
         case '2':
            pokerHands[i] = 2;
            if (maxSameCardCount < (++pokerCounter[2])) {
               maxSameCardCount = pokerCounter[2];
               maxSameCardValue = 2;
            }
            break;
         case '3':
            pokerHands[i] = 3;
            if (maxSameCardCount < (++pokerCounter[3])) {
               maxSameCardCount = pokerCounter[3];
               maxSameCardValue = 3;
            }
            break;
         case '4':
            pokerHands[i] = 4;
            if (maxSameCardCount < (++pokerCounter[4])) {
               maxSameCardCount = pokerCounter[4];
               maxSameCardValue = 4;
            }
            break;
         case '5':
            pokerHands[i] = 5;
            if (maxSameCardCount < (++pokerCounter[5])) {
               maxSameCardCount = pokerCounter[5];
               maxSameCardValue = 5;
            }
            break;
         case '6':
            pokerHands[i] = 6;
            if (maxSameCardCount < (++pokerCounter[6])) {
               maxSameCardCount = pokerCounter[6];
               maxSameCardValue = 6;
            }
            break;
         case '7':
            pokerHands[i] = 7;
            if (maxSameCardCount < (++pokerCounter[7])) {
               maxSameCardCount = pokerCounter[7];
               maxSameCardValue = 7;
            }
            break;
         case '8':
            pokerHands[i] = 8;
            if (maxSameCardCount < (++pokerCounter[8])) {
               maxSameCardCount = pokerCounter[8];
               maxSameCardValue = 8;
            }
            break;
         case '9':
            pokerHands[i] = 9;
            if (maxSameCardCount < (++pokerCounter[9])) {
               maxSameCardCount = pokerCounter[9];
               maxSameCardValue = 9;
            }
            break;
         case 'T':
            pokerHands[i] = 10;
            if (maxSameCardCount < (++pokerCounter[10])) {
               maxSameCardCount = pokerCounter[10];
               maxSameCardValue = 10;
            }
            break;
         case 'J':
            pokerHands[i] = 11;
            if (maxSameCardCount < (++pokerCounter[11])) {
               maxSameCardCount = pokerCounter[11];
               maxSameCardValue = 11;
            }
            break;
         case 'Q':
            pokerHands[i] = 12;
            if (maxSameCardCount < (++pokerCounter[12])) {
               maxSameCardCount = pokerCounter[12];
               maxSameCardValue = 12;
            }
            break;
         case 'K':
            pokerHands[i] = 13;
            if (maxSameCardCount < (++pokerCounter[13])) {
               maxSameCardCount = pokerCounter[13];
               maxSameCardValue = 13;
            }
            break;
         case 'A':
            pokerHands[i] = 14;
            if (maxSameCardCount < (++pokerCounter[14])) {
               maxSameCardCount = pokerCounter[14];
               maxSameCardValue = 14;
            }
            break;
         default:
            throw new RuntimeException("Should not come here.");
         }
      }

      Arrays.sort(pokerHands);
      // special case when 1, 2, 3, 4, 5 happens, should change 14 (ACE) back to
      // 1
      if (pokerHands[0] == 2 && pokerHands[1] == 3 && pokerHands[2] == 4
            && pokerHands[3] == 5 && pokerHands[4] == 14) {
         System.out.println("Re-arrage");
         pokerHands[4] = 1;
         pokerCounter[1] = pokerCounter[14];
         pokerCounter[14] = 0;
         Arrays.sort(pokerHands);
      }
   }

   private void initHandState() {
      if (maxSameCardCount > 1) { // init when there is at least 2 cards have
                                  // the
         // same value
         if (maxSameCardCount == 4) {
            handState = HandState.FOUR_OF_A_KIND;
            fourSameCardValue = maxSameCardValue;
         } else if (maxSameCardCount == 3) {
            boolean isFullHouse = false;
            for (int i = 0; i < pokerCounter.length; ++i) {
               if (pokerCounter[i] == 2) {
                  isFullHouse = true;
                  break;
               }
            }
            if (isFullHouse) {
               handState = HandState.FULL_HOUSE;
            } else {
               handState = HandState.THEREE_OF_A_KIND;
            }
            threeSameCardValue = maxSameCardValue;
         } else {
            int pairCount = 0;
            for (int i = 0; i < pokerCounter.length; ++i) {
               if (pokerCounter[i] == 2) {
                  pairCount++;
                  if (pairCount == 1) {
                     firstPairCardValue = i;
                  } else if (pairCount == 2) {
                     secondPairCardvalue = i;
                     break;
                  }
               }
            }
            if (pairCount == 2) {
               handState = HandState.TWO_PAIR;
            } else {
               handState = HandState.ONE_PAIR;
            }
         }

      } else {
         if (pokerHands[0] + 1 == pokerHands[1]
               && pokerHands[1] + 1 == pokerHands[2]
               && pokerHands[2] + 1 == pokerHands[3]
               && pokerHands[3] + 1 == pokerHands[4]) {
            if (flush) {
               if (pokerHands[4] == 14) {
                  handState = HandState.ROYAL_FLUSH;
               } else {
                  handState = HandState.STRAIGHT_FLUSH;
               }
            } else {
               handState = HandState.STRAIGHT;
            }

         } else {
            if (flush) {
               handState = HandState.FLUSH;
            } else {
               handState = HandState.HIGH_CARD;
            }
         }
      }

   }

   private static final int[] suiteIndexes = { 1, 4, 7, 10, 13 };
   private static final int[] valueIndexes = { 0, 3, 6, 9, 12 };

   public static enum HandState {
      HIGH_CARD, ONE_PAIR, TWO_PAIR, THEREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
   }

   @Override
   public int compareTo(PokerHand other) {

      if (this.handState.ordinal() < other.handState.ordinal()) {
         return -1;
      }
      if (this.handState.ordinal() > other.handState.ordinal()) {
         return 1;
      }
      // only check this when we have the same handState
      int result = 0; // mean equal
      switch (handState) {
      case HIGH_CARD:
         for (int i = this.pokerHands.length - 1; i >= 0; --i) {
            if (this.pokerHands[i] > other.pokerHands[i]) {
               result = 1;
               break;
            }
            if (this.pokerHands[i] < other.pokerHands[i]) {
               result = -1;
               break;
            }
         }
         break;
      case ONE_PAIR:
         if (this.firstPairCardValue > other.firstPairCardValue) {
            result = 1;
         } else if (this.firstPairCardValue < other.firstPairCardValue) {
            result = -1;
         } else {
            // same pair, so which one have the first larger card will win
            for (int i = this.pokerHands.length - 1; i >= 0; --i) {
               if (this.pokerHands[i] > other.pokerHands[i]) {
                  result = 1;
                  break;
               }
               if (this.pokerHands[i] < other.pokerHands[i]) {
                  result = -1;
                  break;
               }
            }
         }
         break;
      case TWO_PAIR:
         if (this.secondPairCardvalue > other.secondPairCardvalue) {
            result = 1;
         } else if (this.secondPairCardvalue < other.secondPairCardvalue) {
            result = -1;
         } else {
            if (this.firstPairCardValue > other.firstPairCardValue) {
               result = 1;
            } else if (this.firstPairCardValue < other.firstPairCardValue) {
               result = -1;
            } else {
               // same two pair, so which one have the first larger card will
               // win
               for (int i = this.pokerHands.length - 1; i >= 0; --i) {
                  if (this.pokerHands[i] > other.pokerHands[i]) {
                     result = 1;
                     break;
                  }
                  if (this.pokerHands[i] < other.pokerHands[i]) {
                     result = -1;
                     break;
                  }
               }
            }
         }
         break;
      case THEREE_OF_A_KIND:
         if (this.threeSameCardValue > other.threeSameCardValue) {
            result = 1;
         } else {
            result = -1;
         }
         break;
      case STRAIGHT:
         if (this.pokerHands[4] > other.pokerHands[4]) {
            result = 1;
         } else if (this.pokerHands[4] < other.pokerHands[4]) {
            result = -1;
         }
         break;
      case FLUSH:
         for (int i = this.pokerHands.length - 1; i >= 0; --i) {
            if (this.pokerHands[i] > other.pokerHands[i]) {
               result = 1;
               break;
            }
            if (this.pokerHands[i] < other.pokerHands[i]) {
               result = -1;
               break;
            }
         }
         break;
      case FULL_HOUSE:
         if (this.threeSameCardValue > other.threeSameCardValue) {
            result = 1;
         } else {
            result = -1;
         }
         break;
      case FOUR_OF_A_KIND:
         if (this.fourSameCardValue > other.fourSameCardValue) {
            result = 1;
         } else {
            result = -1;
         }
         break;
      case STRAIGHT_FLUSH:
         if (this.pokerHands[4] > other.pokerHands[4]) {
            result = 1;
         } else if (this.pokerHands[4] < other.pokerHands[4]) {
            result = -1;
         }
         break;
      case ROYAL_FLUSH:
         result = 0;
         break;
      }

      return result;
   }

   public static void main(String[] args) {
      List<String> list1 = Arrays.asList("5H 5C 6S 7S KD", "5D 8C 9S JS AC",
            "2D 9C AS AH AC", "4D 6S 9H QH QC", "2H 2D 4C 4D 4S","KS JC QD TH 9S");
      List<String> list2 = Arrays.asList("2C 3S 8S 8D TD", "2C 5C 7D 8S QH",
            "3D 6D 7D TD QD", "3D 6D 7H QD QS", "3C 3D 3S 9S 9D","KD 8D 8C 2D 9C");

      for (int i = 0; i < list1.size(); ++i) {
         PokerHand person1 = new PokerHand(list1.get(i));
         PokerHand person2 = new PokerHand(list2.get(i));
         int result = person1.compareTo(person2);
         if (result == 1) {
            System.out.println("index: " + i + " Person 1 win");
         } else if (result == -1) {
            System.out.println("index: " + i + " Person 2 win");
         } else {
            System.out.println("index: " + i + " SAME DEAL");
         }
      }
      
      System.out.println("KD 3H 6C TH 8S 7S KH 6H 9S AC".substring(0,14));
      System.out.println("KD 3H 6C TH 8S 7S KH 6H 9S AC".substring(15));
   }

}
