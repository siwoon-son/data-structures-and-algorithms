package hackerrank.java.easy.JavaPrimalityTest;

import java.math.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-primality-test/problem
public class JavaPrimalityTest {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger i = scanner.nextBigInteger();
        System.out.println(i.isProbablePrime(1) ? "prime" : "not prime");
        scanner.close();
    }
}
