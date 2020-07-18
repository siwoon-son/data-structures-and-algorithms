package hackerrank.algorithms.easy.XORStrings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            // 대입연산자(=)를 비교연산자(==)로 수정
            if(s.charAt(i) == t.charAt(i))
                // 대입연산자(=)를 복합연산자(+=)로 수정
                res += "0";
            else
                // 대입연산자(=)를 복합연산자(+=)로 수정
                res += "1";
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));

    }

}



