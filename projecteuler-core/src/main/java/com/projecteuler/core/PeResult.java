package com.projecteuler.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class PeResult {

   private long result;

   private String detail;

   public static PeResult from(long result) {
      return from(result, null);
   }

   public static PeResult from(long result, String detail) {
      return new PeResult(result, detail);
   }

}
