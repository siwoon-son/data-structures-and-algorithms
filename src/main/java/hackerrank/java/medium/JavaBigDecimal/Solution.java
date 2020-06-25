package hackerrank.java.medium.JavaBigDecimal;

import java.math.BigDecimal;
import java.util.*;

// https://www.hackerrank.com/challenges/java-bigdecimal/problem
class Solution {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        // my code.
        Arrays.sort(s, 0, n, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // String args are converted to BigDecimal, and sorted in descending order.
                return (new BigDecimal(s2)).compareTo(new BigDecimal(s1));
            }
        });
        // end.
        
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}