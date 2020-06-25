package hackerrank.java.easy.JavaStringReverse;

import java.util.*;

// https://www.hackerrank.com/challenges/java-string-reverse/problem
public class JavaStringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        int s = 0;
        int e = A.length()-1;

        String result = "Yes";
        while (s < e) {
            if (A.charAt(s) != A.charAt(e)) {
                result = "No";
                break;
            }
            s++; e--;
        }
        System.out.println(result);
    }
}



