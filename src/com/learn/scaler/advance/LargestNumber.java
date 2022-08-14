package com.learn.scaler.advance;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Problem Description
	Given an array A of non-negative integers, arrange them such that they form the largest number.
	
	Note: The result may be very large, so you need to return a string instead of an integer.
	Problem Constraints
	1 <= len(A) <= 100000
	0 <= A[i] <= 2*109
	Example Input
	Input 1:
	
	 A = [3, 30, 34, 5, 9]
	Input 2:
	
	 A = [2, 3, 9, 0]
	
	
	Example Output
	Output 1:
	
	 "9534330"
	Output 2:
	
	 "9320"
	
	
	Example Explanation
	Explanation 1:
	
	Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
	Explanation 2:
	
	Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(num));

	}

	public static String largestNumber(final int[] A) {

		String[] strArray = new String[A.length];

		// converting integer array to array of string
		for (int i = 0; i < A.length; i++) {
			strArray[i] = Integer.toString(A[i]);
		}

		Arrays.sort(strArray, new Comparator<String>() {
			public int compare(String a, String b) {
				String o1 = a + b;
				String o2 = b + a;
				return o2.compareTo(o1);
			}
		});

		if (strArray[0].equals("0"))
			return "0"; 
		// Otherwise it would return multiple zeros (equal to the length of given
		// array); but the requirement of
		//test case is to just return a single zero if the answer is zero

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strArray.length; i++) {
			sb.append(strArray[i]);
		}
		return sb.toString();
	}
}
