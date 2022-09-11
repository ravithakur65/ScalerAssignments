package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Problem Description
	Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
	Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
	
	Problem Constraints
	1 <= |A| <= 105
	
	Example Input
	Input 1:
	A = [7, 1, 3, 4, 1, 7]

	Input 2:
	A = [1, 1]
	
	Example Output

	Output 1:
	 3

	Output 2:
	 1
	
	Example Explanation
	Explanation 1:
	Here we have 2 options:
	1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
	2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
	Therefore the minimum possible distance is 3. 

	Explanation 2:
	Only possibility is choosing A[1] and A[2].

 */
public class ShaggyAndDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(7, 1, 3, 4, 1, 7);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
	}

	public static int solve(ArrayList<Integer> A) {
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

}
