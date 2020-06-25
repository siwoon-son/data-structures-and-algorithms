package hackerrank.algorithms.easy.BigSorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Map<String, Integer> count = new HashMap<>();
        for (String s: unsorted) {
            Integer c = count.get(s);
            if (c == null) {
                c = 0;
            }
            count.put(s, ++c);
        }
        List<String> keys = new ArrayList(count.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                for (int i=0; i<o1.length(); i++) {
                    if (o1.charAt(i) > o2.charAt(i)) return 1;
                    if (o1.charAt(i) < o2.charAt(i)) return -1;
                }
                return 0;
            }
        });

        String[] sorted = new String[unsorted.length];
        int i = 0;
        for (String key: keys) {
            int c = count.get(key);
            for (int j=0; j<c; j++) {
                sorted[i++] = key;
            }
        }

        return sorted;


//        Arrays.sort(unsorted, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() > o2.length()) return 1;
//                if (o1.length() < o2.length()) return -1;
//
////                int len = o1.length();
////                for (int i=0; i<len; i++) {
////                    if (o1.charAt(i) > o2.charAt(i)) return 1;
////                    if (o1.charAt(i) < o2.charAt(i)) return -1;
////                }
//                return o1.compareTo(o2);
//            }
//        });
//
//        return unsorted;

//        List<BigInteger> bigIntegers = new ArrayList<>();
//        for (String s: unsorted) {
//            bigIntegers.add(new BigInteger(s));
//        }
//        Collections.sort(bigIntegers);
//
//        String[] sorted = new String[unsorted.length];
//        for (int i=0; i<sorted.length; i++) {
//            sorted[i] = bigIntegers.get(i).toString();
//        }
//
//        return sorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
