package hackerrank.java.medium.JavaRegex;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-regex/problem
class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

// my code
class MyRegex {
    public String pattern = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?:\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
}
// end