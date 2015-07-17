package com.projecteuler.core;

import static com.projecteuler.util.MathUtils.sumMultiplesOfANumberBelowMax;

import com.projecteuler.annotation.PEProblem;

public class PEExec {

   @PEProblem(problem = 1, description = "Find the sum of all the multiples of 3 or 5 below 1000")
   public void problem1() {
      long max = 1000;
      long anwser = sumMultiplesOfANumberBelowMax(3, max)
            + sumMultiplesOfANumberBelowMax(5, max)
            - sumMultiplesOfANumberBelowMax(15, max);
      
      System.out.println("Anwser: "+anwser);
   }

}
