package com.projecteuler.core;

import static com.projecteuler.core.PeResultDictionary.currentChallenge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.projecteuler.annotation.PEProblem;

public class PEExecTest {

   private static Map<Integer, List<Method>> peExecMap = new HashMap<Integer, List<Method>>();

   PEExec instance = new PEExec();

   @BeforeClass
   public static void init() {

      Class<PEExec> peExec = PEExec.class;
      for (Method method : peExec.getMethods()) {
         PEProblem annotation = method.getAnnotation(PEProblem.class);
         if (annotation != null) {
            int challengeNumber = annotation.problem();
            if (!peExecMap.containsKey(challengeNumber)) {
               List<Method> methods = new ArrayList<Method>();
               methods.add(method);
               peExecMap.put(challengeNumber, methods);
            } else {
               peExecMap.get(challengeNumber).add(method);
            }
         }
      }
   }

   @Test
   public void test() throws IllegalAccessException, IllegalArgumentException,
         InvocationTargetException {
      int currentChallenge = currentChallenge();
      for (int i = 1; i <= currentChallenge; ++i) {
         executeThenVerifyChallenge(i);
      }
   }

   private void executeThenVerifyChallenge(int challengeNumber)
         throws IllegalAccessException, IllegalArgumentException,
         InvocationTargetException {
      long result = PeResultDictionary.getResult(challengeNumber);

      for (Method method : peExecMap.get(challengeNumber)) {

         PeResult peResult = (PeResult) method.invoke(instance);

         Assert.assertEquals("Solution for challenge number " + challengeNumber
               + " with name " + method.getName()
               + " does not work as expected.", result, peResult.getResult());
      }

   }

}
