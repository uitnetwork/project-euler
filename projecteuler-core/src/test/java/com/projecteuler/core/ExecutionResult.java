package com.projecteuler.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExecutionResult implements Comparable<ExecutionResult> {

   private long executionTime;

   private String methodName;

   @Override
   public int compareTo(ExecutionResult other) {
      int result = (int) (this.executionTime - other.executionTime);
      if (result == 0) {
         result = this.methodName.compareTo(other.methodName);
      }
      return result;
   }

}
