package com.projecteuler.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.projecteuler.annotation.PEProblem;
import com.projecteuler.core.PEExec;

public class Main {

   public static void main(String[] args) throws IllegalAccessException,
         IllegalArgumentException, InvocationTargetException,
         InstantiationException {

      if(args.length != 1) {
         throw new RuntimeException("The class required on parameter as a number euler challenge");
      }

      int challengeNumber = Integer.valueOf(args[0]);
      Class<PEExec> peExec = PEExec.class;
      List<Method> methods = new ArrayList<Method>();
      for (Method method : peExec.getMethods()) {
         PEProblem annotation = method.getAnnotation(PEProblem.class);
         if (annotation != null && annotation.problem() == challengeNumber) {
            methods.add(method);
         }
      }
      System.out.println("===================================================================");
      System.out.println("===================================================================\n\n");
      System.out.println("There are " + methods.size()
            + " solutions for problem " + challengeNumber);
      PEExec instance = peExec.newInstance();
      for (Method method : methods) {
         System.out.println("Executing " + method.getName() + " for problem "
               + challengeNumber);
         long start = System.currentTimeMillis();

         method.invoke(instance);

         long end = System.currentTimeMillis();
         System.out.println("Finished problem " + challengeNumber + " using "
               + method.getName() + " in " + (end - start) + " miliseconds");
      }

      System.out.println("\n\n===================================================================");
      System.out.println("===================================================================");
   }
}
