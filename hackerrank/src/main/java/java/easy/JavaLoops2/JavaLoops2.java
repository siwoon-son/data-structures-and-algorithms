package java.easy.JavaLoops2;

import java.util.*;

// https://www.hackerrank.com/challenges/java-loops/problem
class JavaLoops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int[] pow = new int[15];
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int prev = a + pow(0, pow)*b;
            System.out.print(prev);
            for (int j=1; j<n; j++) {
                prev += pow(j, pow)*b;
                System.out.print(" " + prev);
            }
            System.out.println();
        }
        in.close();
    }
    private static int pow(int exp, int[] pow) {
        if (exp == 0) return 1;
        if (pow[exp] == 0) return 2*pow(exp-1, pow);
        return pow[exp];
    }
}
