package hackerrank.algorithms.easy.SmartNumber;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isSmartNumber(int num) {
        // num이 홀수 개의 인수를 가지면, 이는 smart number라고 한다.
        // 주어진 num이 smart number인지 판별하도록 소스코드를 수정한다.

        // 홀수 개의 인수는 제곱수만 가능하다.
        // 제곱수는 제곱근으로 나누어 떨어진다.
        // 이미 기존 코드에서 제곱근을 계산한다.
        // 하지만, int로 casting되어 소수점 이하가 버려진다.
        // 따라서, 제곱수가 아닌데도 num이 smart number로 판별될 수 있다.
        // 예를 들어, 2의 제곱근은 1.414지만, 소수점 이하가 버려져 1이되고, 이는 num을 나눌 수 있다.

        // 이를 개선하여, 소수점 이하가 버려지는지 확인하도록,
        // 계산된 제곱근의 제곱과 num이 같은지 비교한다.
        // 만약 제곱과 num이 같으면, 이는 제곱수이므로 num은 smart number다.
        int val = (int) Math.sqrt(num);
        // if (num / val == 1)
        if(val * val == num)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for(int i = 0; i < test_cases; i++){
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if(ans){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}



