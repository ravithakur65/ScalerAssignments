package com.learn.scaler.advance;

import java.util.ArrayList;

/*
 * Problem Description
	The gray code is a binary numeral system where two successive values differ in only one bit.
	
	Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
	
	A gray code sequence must begin with 0.
	
	Problem Constraints
	1 <= A <= 16
	Example Input
	Input 1:
	
	A = 2
	Input 1:
	
	A = 1
	
	Example Output
	output 1:
	
	[0, 1, 3, 2]
	output 2:
	
	[0, 1]
	
	Example Explanation
	Explanation 1:
	
	for A = 2 the gray code sequence is:
	    00 - 0
	    01 - 1
	    11 - 3
	    10 - 2
	So, return [0,1,3,2].
	Explanation 1:
	
	for A = 1 the gray code sequence is:
	    00 - 0
	    01 - 1
	So, return [0, 1].
 */
public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(grayCode(2));
		//System.out.println(grayCodeAnotherSol(2));
		System.out.println(grayCodeWithExtraVar(2));
	}

	static int num = 0;
	public static ArrayList<Integer> grayCodeWithExtraVar(int a) {
		ArrayList<Integer> res = new ArrayList<>();
		computeGrayCode(res, a);
		return res;
	}

	public static void computeGrayCode(ArrayList<Integer> res, int a) {
		if (a == 0) {
			res.add(num);
			return;
		}
		computeGrayCode(res, a - 1);
		num = num ^ (1 << (a - 1));
		computeGrayCode(res, a - 1);
	}

	/*
	 * Another solution
	 */
	public static ArrayList<Integer> grayCodeAnotherSol(int a) {
		ArrayList<String> binaryGrayCode = binaryGrayCode(a);
		ArrayList<Integer> result = new ArrayList<>();
		for (String i : binaryGrayCode) {
			result.add(Integer.parseInt(i, 2));
		}
		return result;
	}
	private static ArrayList<String> binaryGrayCode(int a) {
		ArrayList<String> result = new ArrayList<>();

		// base Condition

		if (a == 1) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("0");
			baseResult.add("1");
			return baseResult;
		}

		ArrayList<String> recursiveResult = binaryGrayCode(a - 1);

		// Adding 0 in ascending order

		for (int i = 0; i < recursiveResult.size(); i++) {
			result.add("0" + recursiveResult.get(i));
		}

		// adding 1 in reverse order

		for (int i = recursiveResult.size() - 1; i >= 0; i--) {
			result.add("1" + recursiveResult.get(i));
		}

		return result;
	}

	/*
	 * Logic ==> Each ith element is xor of element and element/2 and first element
	 * is 0 for int A we will get total 2^A element and range of element always be
	 * [0, 2^A];
	 */
	public static ArrayList<Integer> grayCode(int A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int p = 0;
		return solve(res, A, p);
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> res, int A, int element) {
		if (res.size() == (1 << A))
			return res;

		res.add((element ^ (element >> 1)));

		return solve(res, A, element + 1);
	}
}
