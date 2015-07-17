package com.projecteuler.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.projecteuler.annotation.PEProblem;
import com.projecteuler.core.PEExec;

public class Main {

   private static final long CURRENT_PROBLEM = 4;

   public static void main(String[] args) throws IllegalAccessException,
         IllegalArgumentException, InvocationTargetException,
         InstantiationException {
      Class<PEExec> peExec = PEExec.class;
      List<Method> methods = new ArrayList<Method>();
      for (Method method : peExec.getMethods()) {
         PEProblem annotation = method.getAnnotation(PEProblem.class);
         if (annotation != null && annotation.problem() == CURRENT_PROBLEM) {
            methods.add(method);
         }
      }

      System.out.println("There are " + methods.size()
            + " solutions for problem " + CURRENT_PROBLEM);
      PEExec instance = peExec.newInstance();
      for (Method method : methods) {
         System.out.println("Executing " + method.getName() + " for problem "
               + CURRENT_PROBLEM);
         long start = System.currentTimeMillis();

         method.invoke(instance);

         long end = System.currentTimeMillis();
         System.out.println("Finished problem " + CURRENT_PROBLEM + " using "
               + method.getName() + " in " + (end - start) + " miliseconds");
      }
   }
}
