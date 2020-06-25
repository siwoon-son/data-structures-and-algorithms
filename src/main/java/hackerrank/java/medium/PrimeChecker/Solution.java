package hackerrank.java.medium.PrimeChecker;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

import static java.lang.System.in;

// https://www.hackerrank.com/challenges/prime-checker/problem
// my code
class Prime {
    public void checkPrime(int... args) {
        List<Integer> primes = new ArrayList<Integer>();
        for (int arg: args) {
            if (arg <= 1) continue;
            boolean isPrime = true;
            for (int i=2; i*i<=arg; i++) {
                if (arg % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(arg);
        }

        for (int i: primes)
            System.out.print(i + " ");
        System.out.println();
    }
}
// end

public class Solution {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

