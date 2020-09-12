package java.easy.JavaSubstringComparisons;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-compare/problem
public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        for (int i=1; i<s.length()-k+1; i++) {
            String cur = s.substring(i, i+k);
            if (smallest.compareTo(cur) > 0) smallest = cur;
            else if (largest.compareTo(cur) < 0) largest = cur;
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}