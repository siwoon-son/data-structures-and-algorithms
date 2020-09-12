package java.easy.JavaExceptionHandlingTryCatch;

import java.util.*;

// https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
public class JavaExceptionHandlingTryCatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x/y);
        } catch (ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } catch (InputMismatchException ime) {
            System.out.println("java.util.InputMismatchException");
        }
    }
}
