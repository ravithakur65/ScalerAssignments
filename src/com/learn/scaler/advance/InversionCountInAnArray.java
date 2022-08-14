package com.learn.scaler.advance;

/*
 * Problem Description
	Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
	
	Problem Constraints
	1 <= length of the array <= 100000
	
	1 <= A[i] <= 10^9
	Example Input
	Input 1:
	A = [3, 2, 1]

	Input 2:
	A = [1, 2, 3]
	
	Example Output
	Output 1:
	3

	Output 2:
	0
	
	
	Example Explanation
	Explanation 1:
 	All pairs are inversions.
	
	Explanation 2:
 	No inversions.
 */
public class InversionCountInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 2, 3 };
		System.out.println(solve(num));
	}

	//solution 2 O(N^2)
	public static int solve(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					count++;
				}
			}
		}
		return count;
	}

	//O(NlogN)
	public static int solve2(int[] A) {
		return invCount(A, 0, A.length - 1);
	}

	private static int invCount(int[] A, int start, int end) {
		int MOD = 1000000007;
		if (start == end)
			return 0;

		int mid = (start + end) / 2;
		int x = invCount(A, start, mid) % MOD;
		int y = invCount(A, mid + 1, end) % MOD;
		int z = merge(A, start, mid, end) % MOD;
		return (x + y + z) % MOD;
	}

	private static int merge(int[] A, int start, int mid, int end) {
		int count = 0;
		int p1 = start;
		int p2 = mid + 1;
		int p3 = 0;
		int MOD = 1000000007;
		int[] c = new int[end - start + 1];
		while (p1 <= mid && p2 <= end) {
			if (A[p1] <= A[p2]) {
				c[p3] = A[p1];
				p1++;
				p3++;
			} else {
				c[p3] = A[p2];
				p2++;
				p3++;
				// No of elements = mid - p1 +1
				count += (mid - p1 + 1) % MOD;
			}
		}
		while (p1 <= mid) {
			c[p3] = A[p1];
			p1++;
			p3++;
		}

		while (p2 <= end) {
			c[p3] = A[p2];
			p2++;
			p3++;
		}

		p3 = 0;
		for (int i = start; i <= end; i++) {
			A[i] = c[p3];
			p3++;
		}
		return count % MOD;
	}
}
