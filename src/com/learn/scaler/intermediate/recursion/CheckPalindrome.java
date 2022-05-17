/*
 * Problem Description
	Write a recursive function that checks whether string A is a palindrome or Not.
	Return 1 if the string A is a palindrome, else return 0.
	
	Note: A palindrome is a string that's the same when read forward and backward.
	Problem Constraints
	1 <= A <= 50000
	
	String A consists only of lowercase letters.
	Input 1:
	 A = "naman"

	Input 2:
	 A = "strings"

	 Explanation 1:
	 "naman" is a palindomic string, so return 1.

	Explanation 2:
	 "strings" is not a palindrome, so return 0.
 */
package com.learn.scaler.intermediate.recursion;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("naman"));
	}
	 public static int solve(String A) {
	        return isPalindrome(A,0,A.length()-1);
	    }

	    public static int isPalindrome(String A, int s, int e){
	        if(s>e)
	            return 1;

	        if(A.charAt(s)==A.charAt(e)){
	            return isPalindrome(A,++s,--e);
	        }
	        return 0;
	    }
}
