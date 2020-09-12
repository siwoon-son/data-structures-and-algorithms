package datastructures.medium.Waiter;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        List<Integer>[] Bs = new ArrayList[q];
        List<Integer> A = new ArrayList<>();
        for (int n: number) {
            A.add(0, n);
        }

        List<Integer> primes = new ArrayList<>();
        for (int i=0; i<q; i++) {
            Bs[i] = new ArrayList<Integer>();
            int prime = nextPrime(primes);
            for (int j=0; j<A.size(); j++) {
                int plate = A.get(j);
                if (plate % prime == 0) {
                    Bs[i].add(0, plate);
                    A.remove(j--);
                }
            }
            Collections.reverse(A);
        }

        int[] rearrange = new int[number.length];
        int i=0;
        for (List<Integer> B: Bs) {
            for (Integer plate: B) {
                rearrange[i++] = plate;
            }
        }
        for (Integer plate: A) {
            rearrange[i++] = plate;
        }
        return rearrange;
    }
    static int nextPrime(List<Integer> primes) {
        if (primes.isEmpty()) {
            primes.add(2);
            return 2;
        }
        int next = primes.get(primes.size()-1) + 1;
        for (int i=0; i<primes.size(); i++) {
            if (next % primes.get(i) == 0) {
                next++;
                i=-1;
            }
        }
        primes.add(next);
        return next;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
