package hackerrank.java.easy.JavaEndOfFile;

import java.util.*;

// https://www.hackerrank.com/challenges/java-end-of-file/problem
public class JavaEndOfFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNextLine()) {
            i++;
            String s = sc.nextLine();
            System.out.println(i + " " + s);
        }
        sc.close();
    }
}
