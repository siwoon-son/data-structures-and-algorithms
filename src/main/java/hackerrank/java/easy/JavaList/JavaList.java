package hackerrank.java.easy.JavaList;

import java.util.*;

// https://www.hackerrank.com/challenges/java-list/problem
public class JavaList {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<Integer>();
        int n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            int d = scanner.nextInt();
            data.add(d);
        }

        int q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            String op = scanner.next();
            switch (op) {
                case "Insert":
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    data.add(x, y);
                    break;
                case "Delete":
                    int z = scanner.nextInt();
                    data.remove(z);
                break;
            }
        }

        System.out.print(data.get(0));
        for (int i=1; i<data.size(); i++) {
            System.out.print(" " + data.get(i));
        }
        System.out.println();
    }
}
