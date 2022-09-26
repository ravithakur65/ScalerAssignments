package com.learn.scaler.advance;

import java.util.ArrayList;

/*
 * Problem Description
	Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
	NOTE: All the A integers will fit in 32-bit integers.
	
	Problem Constraints
	1 <= A <= 29500
	
	Input Format
	The only argument given is integer A.
	
	Output Format
	Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
	
	Example Input
	Input 1:
	 A = 3

	Input 2:
	 A = 7
	
	Example Output
	Output 1:
	 [1, 2, 3]

	Output 2:
	 [1, 2, 3, 11, 12, 13, 21]
	
	Example Explanation
	Explanation 1:
	 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

	Explanation 2:
	 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
public class N_IntegersContainingOnly123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> solve(int A) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		res.add(2);
		res.add(3);
		int idx = 0;
		while (res.size() < A) {
			int prefix = res.get(idx);
			idx++;
			res.add(prefix * 10 + 1);
			res.add(prefix * 10 + 2);
			res.add(prefix * 10 + 3);
		}

		while (res.size() > A) {
			res.remove(res.size() - 1);
		}

		return res;
	}
}
