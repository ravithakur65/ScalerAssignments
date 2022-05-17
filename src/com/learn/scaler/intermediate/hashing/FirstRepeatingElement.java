/*
 * Problem Description
	Given an integer array A of size N, find the first repeating element in it.
	We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
	If there is no repeating element, return -1.
	Problem Constraints
	1 <= N <= 105
	1 <= A[i] <= 109

	Input 1:
	 A = [10, 5, 3, 4, 3, 5, 6]
	 A = [6, 10, 5, 4, 9, 120]
	 Output: 
	 5
	 -1
	 
	 5 is the first element that repeats
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(6, 10, 5, 4, 9, 120);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
	}

	public static int solve(ArrayList<Integer> A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(A.get(i))) {
				int temp = map.get(A.get(i));
				map.put(A.get(i), ++temp);
			} else
				map.put(A.get(i), 1);
		}

		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(A.get(i)) && map.get(A.get(i)) > 1)
				return A.get(i);
		}
		return -1;
	}
}
