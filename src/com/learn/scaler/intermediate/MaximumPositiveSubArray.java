/*
 * Problem Description
	Given an array of integers A, of size N.
	Return the maximum size subarray of A having only non-negative elements. If there are more 
	than one such subarray, return the one having the smallest starting index in A.
	NOTE: It is guaranteed that an answer always exists.
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumPositiveSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(5, 6, -1, 7, 8);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		System.out.println(solve(list));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = i; j < A.size(); j++) {
				if (A.get(j) > 0) {
					temp.add(A.get(j));
				} else
					break;
			}
			if (temp.size() > result.size())
				result = temp;
		}
		return result;
	}
}
