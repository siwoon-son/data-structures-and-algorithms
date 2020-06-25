package hackerrank.java.easy.JavaMap;//Complete this code or write your own from scratch
import java.util.*;

// https://www.hackerrank.com/challenges/phone-book/problem
class JavaMap {
    public static void main(String []argh)    {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> dict = new HashMap<String, Integer>();
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            dict.put(name, phone);
        }
        while(in.hasNext())    {
            String s=in.nextLine();
            if (dict.containsKey(s)) System.out.println(s + "=" + dict.get(s));
            else System.out.println("Not found");
        }
    }
}



