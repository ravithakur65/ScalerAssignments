package com.learn.scaler.advance;
/*
 * Problem Description
	You are given an array of N integers, A1, A2, .... AN.
	Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
	
	Problem Constraints
	1 <= N <= 100000
	-109 <= A[i] <= 109
	
	Input Format
	First argument is an integer array A of size N.
	
	Output Format
	Return an integer denoting the maximum value of f(i, j).
	
	Example Input
	Input 1:
	A = [1, 3, -1]

	Input 2:
	A = [2]
	
	Example Output
	Output 1:
	5

	Output 2:
	0
	
	Example Explanation
	Explanation 1:
	f(1, 1) = f(2, 2) = f(3, 3) = 0
	f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
	f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
	f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
	So, we return 5.

	Explanation 2:
	Only possibility is i = 1 and j = 1. That gives answer = 0.
 */
public class MaximumArrayDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 3, -1};
		System.out.println(maxArr(num));
	}

	public static int maxArr(int[] A) {
		// Expalnation :
		// We have to find |A[i] - A[j]| + |i - j|
		// for mod we can get four possiblities (+, +) , (+ , -), (- , +), (-, -)

		// So we can write the above as
		// (A[i] - A[j]) + (i - j) => (A[i] + i) - (A[j] + j)
		// (A[i] - A[j]) - (i - j) => (A[i] - i) - (A[j] - j)
		// -(A[i] - A[j]) + (i - j) => -(A[i] - i) + (A[j] - j)
		// -(A[i] - A[j]) - (i - j) => -(A[i] + i) + (A[j] + j)
		// So from the above we can see that we have to find only four pair
		// A = A[i] + i = maxForI
		// B = A[i] - i = minForI
		// C = A[j] + j = maxForJ
		// D = A[j] - j = minForJ

		int maxForI = Integer.MIN_VALUE;
		int maxForJ = Integer.MIN_VALUE;
		int minForI = Integer.MAX_VALUE;
		int minForJ = Integer.MAX_VALUE;

		for (int k = 0; k < A.length; k++) {
			maxForI = Math.max(maxForI, A[k] + k);
			minForI = Math.min(minForI, A[k] + k);
			maxForJ = Math.max(maxForJ, A[k] - k);
			minForJ = Math.min(minForJ, A[k] - k);
		}
		return Math.max(maxForI - minForI, maxForJ - minForJ);
	}
}
