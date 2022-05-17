/*
 * Problem Description
	The Fibonacci numbers are the numbers in the following integer sequence.
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
	In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
	Fn = Fn-1 + Fn-2
	Given a number A, find and return the Ath Fibonacci Number.
	Given that F0 = 0 and F1 = 1.

	Problem Constraints
	0 <= A <= 20
	
	Input 1:
	 A = 2
	
	Input 2:
	 A = 9
	
	 Explanation 1:
	 f(2) = f(1) + f(0) = 1
	
	Explanation 2:
	 f(9) = f(8) + f(7) = 21 + 13  = 34
 */
package com.learn.scaler.intermediate.recursion;

public class FindFibonacciII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAthFibonacci(9));
	}
	 public static int findAthFibonacci(int A) {
	        if(A==0)
	            return 0;
	        if(A==1)
	            return 1;
	        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
	    }
}
