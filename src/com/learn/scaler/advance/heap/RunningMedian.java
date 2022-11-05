package com.learn.scaler.advance.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Problem Description
	Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
	Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
	
	Find and return the array C.
	
	NOTE:
	
	If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
	If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
	
	
	Problem Constraints
	1 <= length of the array <= 100000
	1 <= A[i] <= 109
	
	
	
	Input Format
	The only argument given is the integer array A.
	
	
	
	Output Format
	Return an integer array C, C[i] denotes the median of the first i elements.
	
	
	
	Example Input
	Input 1:
	
	 A = [1, 2, 5, 4, 3]
	Input 2:
	
	 A = [5, 17, 100, 11]
	
	
	Example Output
	Output 1:
	
	 [1, 1, 2, 2, 3]
	Output 2:
	
	 [5, 5, 17, 11]
	
	
	Example Explanation
	Explanation 1:
	
	 stream          median
	 [1]             1
	 [1, 2]          1
	 [1, 2, 5]       2
	 [1, 2, 5, 4]    2
	 [1, 2, 5, 4, 3] 3
	Explanation 2:
	
	 stream          median
	 [5]              5
	 [5, 17]          5
	 [5, 17, 100]     17
	 [5, 17, 100, 11] 11
 */
public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> num = new ArrayList<>();
		num.addAll(Arrays.asList(5, 17, 100, 11));
		System.out.println(solve(num));
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minheap = new PriorityQueue<>();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		ans.add(A.get(0));
		maxheap.add(A.get(0));

		for (int i = 1; i < A.size(); i++) {

			if (A.get(i) > maxheap.peek()) {
				minheap.add(A.get(i));
			} else {
				maxheap.add(A.get(i));
			}

			int size1 = maxheap.size();
			int size2 = minheap.size();

			if (size1 - size2 > 1) {
				int ele = maxheap.poll();
				minheap.add(ele);
			} else if (size1 - size2 < 0) {
				int ele = minheap.poll();
				maxheap.add(ele);
			}

			ans.add(maxheap.peek());
		}

		return ans;
	}

}
