package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Problem Description
	Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
	If the given array contains a sub-array with sum zero return 1, else return 0.
	
	Problem Constraints
	1 <= |A| <= 100000
	-10^9 <= A[i] <= 10^9
	Example Input
	Input 1:
	 A = [1, 2, 3, 4, 5]

	Input 2:
	 A = [-1, 1]
	
	Example Output
	Output 1:
	 0

	Output 2:
	 1

 */
public class SubArrayWith0Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
	}
	/*
	 * Logic: 1) If summation of elements from any subarray(p,q) is zero that means
	 * sum of subarray(0, p - 1) == sum of subarray(0, q); 2) That is
	 * sum(subarray(p,q)) = sum(subarray(0,q)) - sum(subarray(0, p - 1)) Since
	 * sum(subarray(p,q)) should be zero then sum(subarray(0,q)) = sum(subarray(0,
	 * p))
	 */

	public static int solve(ArrayList<Integer> A) {
		HashSet<Long> set = new HashSet<>();
		int N = A.size();
		long sum = 0;
		set.add(sum);
		for (int i = 0; i < N; i++) {
			sum += A.get(i);
			if (set.contains(sum)) {
				return 1;
			} else {
				set.add(sum);
			}
		}

		return 0;
	}
}
