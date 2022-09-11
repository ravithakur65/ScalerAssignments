package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * Problem Description
	Given an array A of N integers.
	Find the largest continuous sequence in a array which sums to zero.
	
	Problem Constraints
	1 <= N <= 106
	-107 <= A[i] <= 107

	Input Format
	Single argument which is an integer array A.
	
	Output Format
	Return an array denoting the longest continuous sequence with total sum of zero.
	NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
	
	Example Input
	A = [1,2,-2,4,-4]
	
	Example Output
	[2,-2,4,-4]
	
	Example Explanation
	[2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestContSeqZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,-2,4,-4));
		System.out.println(lszero(list));
	}

	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();// result array
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		Long prefixArray = 0l;
		// currentLen -> current length where length of subarray is 0
		// actualLen -> actual length of longest subarray having sum 0 found till i
		// start end -> index of start and end of longest subarray found
		int currentLen = 0, actualLen = -1, start = 0, end = 0;
		int listSize = A.size(); // length of given Array

		for (int i = 0; i < listSize; i++) {
			prefixArray += A.get(i);// virtual prefix array
			if (prefixArray == 0) {
				// if at some point prefixarray becomes 0,
				// that subarray begins from 0th index
				start = 0;
				actualLen = i;// length would be i-0=i
				end = i;
			}
			if (hm.containsKey(prefixArray)) {
				// if duplicate element found
				// calculate current length and compare with longest length
				// before current length
				currentLen = i - hm.get(prefixArray) - 1;
				if (currentLen > actualLen) {
					start = hm.get(prefixArray) + 1;
					actualLen = currentLen;
					end = currentLen + start;
				}
			} else {
				hm.put(prefixArray, i);
				// else add the value to HashMap along with index
			}
		}
		// if length not updated, mean no subarray with 0 sum exist
		if (actualLen == -1)
			return result;

		// else add the element from start to end index in the result array
		for (int i = start; i <= end; i++) {
			result.add(A.get(i));
		}
		return result;
	}
}
