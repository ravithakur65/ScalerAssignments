package com.learn.scaler.advance;
/*
 * Problem Description
	On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
	
	Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
	Problem Constraints
	1 <= A <= 20
	
	1 <= B <= 2A - 1
	Example Input
	Input 1:
	
	 A = 2
	 B = 1
	Input 2:
	
	 A = 2
	 B = 2
	
	
	Example Output
	Output 1:
	
	 0
	Output 2:
	
	 1
	
	Example Explanation
	Explanation 1:
	 Row 1: 0
	 Row 2: 01

	Explanation 2:
	 Row 1: 0
	 Row 2: 01
 */
public class FindKthSymbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(3,4));
	}

	public static int solve(int A, int B) {
		if (A == 0 || B == 0) {
			return 0;
		}

		int x;
		if ((B & 1) == 0) { // even or odd
			x = solve(A - 1, B / 2) == 0 ? 1 : 0;
		} else {
			x = solve(A - 1, (B + 1) / 2);
		}
		return x;
	}

}
