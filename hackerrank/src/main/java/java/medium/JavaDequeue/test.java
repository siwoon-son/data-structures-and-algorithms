package java.medium.JavaDequeue;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        // my code
        Set<Integer> set = new HashSet<Integer>();
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            // windows is full.
            if (deque.size() == m) {
                if (set.size() > maxNum) maxNum = set.size();
                int el = deque.remove();
                // If the removed number not exists in deque,
                // it is also removed from set.
                if (!deque.contains(el)) set.remove(el);
            }
        }
        // end

        System.out.println(maxNum);
    }
}



