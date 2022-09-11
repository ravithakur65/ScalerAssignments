package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * Problem Description
	Given an unsorted integer array A of size N.
	Find the length of the longest set of consecutive elements from array A.
	
	Problem Constraints
	1 <= N <= 106
	-106 <= A[i] <= 106
	
	Example Input
	Input 1:
	A = [100, 4, 200, 1, 3, 2]

	Input 2:
	A = [2, 1]
	
	Example Output
	Output 1:
	 4

	Output 2:
	 2
	
	Example Explanation
	Explanation 1:
	 The set of consecutive elements will be [1, 2, 3, 4].

	Explanation 2:
	 The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(100, 4, 200, 1, 3, 2);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.addAll(list);
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(list));
		//System.out.println(longestConsecutive(arrList));
		System.out.println(findLongestConsicutive(num));
	}

	public static int longestConsecutive(final List<Integer> A) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int n = A.size();
		for (int i = 0; i < n; i++) {
			hs.add(A.get(i));
		}
		int ans = 0;
		for (Integer value : hs) {
			if (hs.contains(value - 1)) {
				continue;
			} else {
				int count = 1;
				int curValue = value;
				while (true) {
					if (hs.contains(curValue + 1)) {
						count++;
						curValue++;
					} else {
						break;
					}
				}
				ans = Math.max(ans, count);
			}
		}
		return ans;
	}

	public static int longestConsecutive(ArrayList<Integer> A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// <element, index>
		int n = A.size(), min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(A.get(i))) {
				int index = map.get(A.get(i));// return index
				// difference=(i-index)
				min = Math.min(min, (i - index));
				// update index
				map.put(A.get(i), i);
			} else {
				map.put(A.get(i), i);
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}

	private static int findLongestConsicutive(int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			hs.add(A[i]);
		}
		int long_length = 0;
		for (int i = 0; i < n; i++) {
			if (!hs.contains(A[i] - 1)) {
				int num = A[i];
				while (hs.contains(num)) {
					num++;
				}
				if (long_length < num - A[i]) {
					long_length = num - A[i];
				}
			}
		}
		return long_length;
	}

}
