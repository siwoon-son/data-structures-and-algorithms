package algorithms.medium.Encryption;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int N = s.length();
        double rootN = Math.sqrt(N);
        int ceil = (int) Math.ceil(rootN);
        int floor = (int) rootN;
        if (ceil * floor < N) floor++;

        char[][] arr = new char[floor][ceil];
        for (int i=0; i<floor; i++) {
            for (int j=0; j<ceil; j++) {
                arr[i][j] = (i * ceil + j < N) ?
                    arr[i][j] = s.charAt(i * ceil + j) : ' ';
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int j=0; j<ceil; j++) {
            for (int i=0; i<floor; i++) {
                if (arr[i][j] != ' ')
                    sb.append(arr[i][j]);
            }
            sb.append(' ');
        }

        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        String result = encryption(s);

        System.out.println(result);

        scanner.close();
    }
}
