/*
 * Problem Description
	Write a program to find the factorial of the given number A.
	
	Problem Constraints
	0 <= A <= 12

	Input 1:
	 A = 4
	
	Input 2:
	 A = 1
	
	 Explanation 1:
	 Factorial of 4 = 4 * 3 * 2 * 1 = 24
	Explanation 2:
	 Factorial of 1 = 1
 */
package com.learn.scaler.intermediate.recursion;

public class FindFactorial1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4));
	}
	public static int solve(int A) {
        if(A==0)
            return 1;
        return A*solve(A-1);
    }
}
