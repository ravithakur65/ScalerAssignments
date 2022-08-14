package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.

Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000

Example Input
Input 1:
A = [1, 2] 

Input 2:
A = [1]

Example Output
Output 1:
 1 

Output 2:
 0


Example Explanation
Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1 

Explanation 2:
Only 1 subsequence of 1 element is formed.
 */
public class SumTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
	}

	// sort the Array
	// 1 2 3 4 5
	// each subsequence each max element will be present in 2^n times
	// Ex: in 1 2 3 4 5 sequence 5 will be present in 2^4 times as it is max
	// 4 will be present in 2^3 times as it is max
	// 1 will present as min element in 2^5 subsequnces
	// sum of all the subsequnce max-min is the ans applying mod
	public static int solve(ArrayList<Integer> A) {
		int mod = 1000000007;
		Collections.sort(A);
		int n = A.size();
		long max = 0;
		long min = 0;
		for (int i = 0; i < n; i++) {
			// number * no of subsequences the number exists in
			max = ((max + (long) A.get(n - i - 1) * pow(2, n - i - 1, mod)) % mod); // total max calculation
			min = ((min + (long) A.get(i) * pow(2, n - i - 1, mod)) % mod); // total min calculation
		}
		return (int) (max - min + mod) % mod; // (a-b)%m = (a%m - b%m + m)%m
	}

	static long pow(int n, int p, int mod) {

		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		long pow = 1;

		pow = (pow % mod * pow(n, p / 2, mod)) % mod;
		pow = (pow % mod * pow % mod) % mod;
		if (p % 2 == 1) {
			pow = (n % mod * pow % mod) % mod;
		}
		return pow;

	}
}
