package com.projecteuler.com.projecteuler.triangle;

/**
 * Created by ninhdoan on 7/1/16.
 */
public class Triangle {

   private final int a;
   private final int b;
   private final int c;
   private boolean isValid;
   private boolean isRightAngled;
   private boolean isIsosceles;
   private boolean isEquilateral;
   private TriangleType type = TriangleType.NOT_VALID;

   public Triangle(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;

      checkValid();
      if (isValid) {
         type = TriangleType.NORMAL;
         checkRightAngled();
         checkIsosceles();
         checkEquilateral();
         checkType();
      }
   }

   public static void main(String[] args) {

      System.out.println((new Triangle(3, 4, 5)).getType());
      System.out.println((new Triangle(1, 1, 1)).getType());
      System.out.println((new Triangle(1, 1, 10)).getType());
      System.out.println((new Triangle(5, 12, 13)).getType());
      System.out.println((new Triangle(3, 3, 5)).getType());

   }

   public TriangleType getType() {
      return this.type;
   }

   private void checkValid() {
      isValid = !(a <= 0 || b <= 0 || c <= 0 || a > b + c || b > a + c || c > a + b);
   }

   private void checkRightAngled() {
      isRightAngled = (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a);
   }

   private void checkIsosceles() {
      isIsosceles = (a == b) || (b == c) || a == c;
   }

   private void checkEquilateral() {
      isEquilateral = (a == b) && (b == c);
   }

   private void checkType() {
      if (isIsosceles) {
         type = TriangleType.ISOSCELES;
      }

      if (isRightAngled) {
         type = TriangleType.RIGHT_ANGLED;
      }

      if (isIsosceles && isRightAngled) {
         type = TriangleType.RIGHT_ANGLED_ISOCELES;
      }

      if (isEquilateral) {
         type = TriangleType.EQUILATERAL;
      }
   }

   public enum TriangleType {
      NOT_VALID,
      NORMAL,
      RIGHT_ANGLED,
      ISOSCELES,
      RIGHT_ANGLED_ISOCELES,
      EQUILATERAL
   }

}

