package java.easy.JavaStringTokens;

import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens/problem
public class JavaStringTokens {

    public static void main(String[] args) {    
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();        
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] splitted = s.split("[^a-zA-Z]+");
        System.out.println(splitted.length);
        for (String str: splitted)
            System.out.println(str);
        
        scan.close();
    }
}

