package com.learn.scaler.advance.heap;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Description
	You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
	
	There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
	There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
	The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.
	
	Return 1 if the array is special else return 0.
	
	NOTE:
	
	For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
	For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
	
	
	Problem Constraints
	1 <= N <= 1000000.
	A[i] is in the range of a signed 32-bit integer.
	
	
	
	Input Format
	The first and only argument is an integer array A.
	
	
	
	Output Format
	Return 1 if the given array is special else return 0.
	
	
	
	Example Input
	Input 1:
	
	 A = [4, 6, 8, 4]
	Input 2:
	
	 A = [2, 7, 3, 1]
	
	
	Example Output
	Output 1:
	
	 1
	Output 2:
	
	 0
	
	
	Example Explanation
	Explantion 1:
	
	 Here, 6 is equal to the median of [8, 4].
	Explanation 2:
	
	 No element satisfies any condition.
 */
public class SpecialMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(2147483647, -2147483648, 0 ));
		System.out.println(solve(list));
	}

	public static int solve(ArrayList<Integer> A) {
		// find PS
		ArrayList<Integer> prefixSum = new ArrayList<Integer>();
		int sum = 0;
		for (int temp : A) {
			sum += temp;
			prefixSum.add(sum);
		}
		int size = A.size();
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				leftSum = prefixSum.get(i - 1);
				if (leftSum / i == A.get(i))
					return 1;
			}
			if (i < size - 1) {
				rightSum = prefixSum.get(size - 1) - prefixSum.get(i);
				if (rightSum / (size - 1 - i) == A.get(i))
					return 1;
			}

		}

		return 0;
	}
}
