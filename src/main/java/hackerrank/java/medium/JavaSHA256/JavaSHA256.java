package hackerrank.java.medium.JavaSHA256;

import java.util.*;
import java.security.*;

// https://www.hackerrank.com/challenges/sha-256/problem
public class JavaSHA256 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // my code
        System.out.println(sha256(s));
        // end
        sc.close();
    }

    // my code
    public static String sha256(String str){
        String SHA = "";     
        try{    
            MessageDigest sh = MessageDigest.getInstance("SHA-256");     
            sh.update(str.getBytes());     
            byte byteData[] = sh.digest();    
            StringBuffer sb = new StringBuffer();     
            for(int i = 0 ; i < byteData.length ; i++){    
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));    
            }    
            SHA = sb.toString();    
                
        }catch(NoSuchAlgorithmException e){    
            e.printStackTrace();     
            SHA = null;     
        }    
        return SHA;    
    }
    // end
}
