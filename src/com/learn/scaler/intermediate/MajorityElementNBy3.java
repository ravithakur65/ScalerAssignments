package com.learn.scaler.intermediate;

import java.util.Arrays;
import java.util.List;

public class MajorityElementNBy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(2, 2, 2, 3, 4, 5, 7);
		System.out.println(majorityElement(list));
	}

	public static int majorityElement(final List<Integer> A) {
		int count1 = 0, count2 = 0;

		// take the integers as the maximum
		// value of integer hoping the integer
		// would not be present in the array
		int first = Integer.MIN_VALUE;
		int second = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {

			// if this element is previously
			// seen, increment count1.
			if (first == A.get(i))
				count1++;

			// if this element is previously
			// seen, increment count2.
			else if (second == A.get(i))
				count2++;

			else if (count1 == 0) {
				count1++;
				first = A.get(i);
			}

			else if (count2 == 0) {
				count2++;
				second = A.get(i);
			}

			// if current element is different
			// from both the previously seen
			// variables, decrement both the
			// counts.
			else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		// Again traverse the array and
		// find the actual counts.
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == first)
				count1++;

			else if (A.get(i) == second)
				count2++;
		}

		if (count1 > A.size() / 3)
			return first;

		if (count2 > A.size() / 3)
			return second;

		return -1;
	}

}
