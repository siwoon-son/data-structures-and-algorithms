package java.medium.JavaMD5;

import java.util.*;
import java.security.*;

// https://www.hackerrank.com/challenges/java-md5/problem
public class Solution {

    public static void main(String[] args) {
        // my code
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(md5(s));
        // end
    }

    // my code
    public static String md5(String str) {
        String MD5 = "";
        try{    
            MessageDigest md = MessageDigest.getInstance("MD5");     
            md.update(str.getBytes());     
            byte byteData[] = md.digest();    
            StringBuffer sb = new StringBuffer();     
            for(int i = 0 ; i < byteData.length ; i++){    
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));    
            }
            MD5 = sb.toString();
        }catch(NoSuchAlgorithmException e){    
            e.printStackTrace();     
            MD5 = null;     
        }    
        return MD5;    
    }
    // end
}
