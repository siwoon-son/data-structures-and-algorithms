package hackerrank.datastructures.easy.MaximumElement;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        // N개의 질의는 다음과 같은 유형을 갖는다.
        // 1 x --> 스택에 x를 삽입한다.
        // 2   --> 스택에서 마지막 값을 제거한다.
        // 3   --> 스택에서 가장 큰 값을 출력한다.

        Scanner sc = new Scanner(System.in);
        // N을 입력받는다.
        int N = sc.nextInt();

        // x들을 저장할 스택을 생성한다.
        Stack<Integer> stack = new Stack<>();
        // 최대값의 히스토리를 관리할 스택을 생성한다.
        // 이는 질의 2에 대해 최대값이 제거되면, 이전의 최대값을 빠르게 접근하기 위함이다.
        Stack<Integer> max = new Stack<>();

        // N번 질의를 수행항다.
        while (N-- > 0) {
            // 질의를 입력받는다.
            int query = sc.nextInt();
            switch (query) {
                // 질의 1
                case 1:
                    int x = sc.nextInt();
                    // x를 스택에 저장한다.
                    stack.push(x);
                    // 추가된 x가 새로운 최대값이면,
                    if (max.isEmpty() || max.peek() < x)
                        // 최대값 스택에 x를 저장한다.
                        max.push(x);
                    break;
                // 질의 2
                case 2:
                    // 스택에서 값을 제거하다.
                    int last = stack.pop();
                    // 제거한 값이 최대값이었으면,
                    if (max.peek() == last) {
                        // 최대값 스택에서 제거한다.
                        max.pop();
                    }
                    break;
                // 질의 3
                case 3:
                    // 최대값 스택의 최근값이 현재의 최대값이다.
                    System.out.println(max.peek());
                    break;
            }
        }
    }
}