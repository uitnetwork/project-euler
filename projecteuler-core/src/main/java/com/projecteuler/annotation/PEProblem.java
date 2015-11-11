package com.projecteuler.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PEProblem {

   int problem();

   String description() default "";

}
