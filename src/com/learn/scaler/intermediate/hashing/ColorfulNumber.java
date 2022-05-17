/*
 * Problem Description
	Given a number A, find if it is COLORFUL number or not.
	If number A is a COLORFUL number return 1 else, return 0.
	What is a COLORFUL Number:
	A number can be broken into different contiguous sub-subsequence parts. 
	Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
	And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 
	 Problem Constraints
		1 <= A <= 2 * 109
	
	Input 1:
	 A = 23

	Input 2:
	 A = 236

	 Explanation 1:
	 Possible Sub-sequences: [2, 3, 23] where
	 2 -> 2 
	 3 -> 3
	 23 -> 6  (product of digits)
	 This number is a COLORFUL number since product of every digit of a sub-sequence are different. 

	Explanation 2:
	 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
	 2 -> 2 
	 3 -> 3
	 6 -> 6
	 23 -> 6  (product of digits)
	 36 -> 18  (product of digits)
	 236 -> 36  (product of digits)
	 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same. 
 */
package com.learn.scaler.intermediate.hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(colorful(236));
	}
	 public static int colorful(int A) {
	        Set<Integer> set = new HashSet<>();
	        int temp=A,product=1;

	        while(A>0){
	            int rem = temp%10;
	            product=product*rem;
	            if(set.contains(product)){
	                return 0;
	            }
	            set.add(product);
	            temp/=10;
	            if(temp==0){
	                A/=10;
	                temp=A;
	                product=1;
	            }
	        }
	        return 1;
	        
	    }
}
