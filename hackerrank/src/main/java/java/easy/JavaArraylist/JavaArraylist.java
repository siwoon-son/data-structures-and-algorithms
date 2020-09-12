package java.easy.JavaArraylist;

import java.util.*;

// https://www.hackerrank.com/challenges/java-arraylist/problem
public class JavaArraylist {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        int n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            int d = scanner.nextInt();
            List<Integer> row = new ArrayList<Integer>();
            for (int j=0; j<d; j++) {
                row.add(scanner.nextInt());
            }
            data.add(row);
        }

        int q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            List<Integer> row = data.get(x-1);
            if (y > row.size()) System.out.println("ERROR!");
            else System.out.println(row.get(y-1));
        }
    }
}
