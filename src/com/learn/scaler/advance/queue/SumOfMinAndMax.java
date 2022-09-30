package com.learn.scaler.advance.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * Problem Description
	Given an array A of both positive and negative integers.
	Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
	NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
	
	Problem Constraints
	1 <= size of array A <= 105
	-109 <= A[i] <= 109
	1 <= B <= size of array
	
	Input Format
	The first argument denotes the integer array A.
	The second argument denotes the value B
	
	Output Format
	Return an integer that denotes the required value.
	
	Example Input
	Input 1:
	 A = [2, 5, -1, 7, -3, -1, -2]
	 B = 4

	Input 2:
	 A = [2, -1, 3]
	 B = 2
	
	Example Output
	Output 1:
	 18

	Output 2:
	 3
	
	Example Explanation
	Explanation 1:
	 Subarrays of size 4 are : 
	    [2, 5, -1, 7],   min + max = -1 + 7 = 6
	    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
	    [-1, 7, -3, -1], min + max = -3 + 7 = 4
	    [7, -3, -1, -2], min + max = -3 + 7 = 4   
	    Sum of all min & max = 6 + 4 + 4 + 4 = 18 

	Explanation 2:
	 Subarrays of size 2 are : 
	    [2, -1],   min + max = -1 + 2 = 1
	    [-1, 3],   min + max = -1 + 3 = 2
	    Sum of all min & max = 1 + 2 = 3
 */
public class SumOfMinAndMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
		int B = 4;
		System.out.println(solve(list, B));
	}

	public static int solve(ArrayList<Integer> A, int B) {
		long m = 1000000007;
		Deque<Integer> min_deque = new ArrayDeque<Integer>();
		Deque<Integer> max_deque = new ArrayDeque<Integer>();

		for (int i = 0; i < B; i++) {
			while (!min_deque.isEmpty() && A.get(i) <= A.get(min_deque.peekLast()))
				min_deque.pollLast();

			min_deque.offer(i);

			while (!max_deque.isEmpty() && A.get(i) >= A.get(max_deque.peekLast()))
				max_deque.pollLast();

			max_deque.offer(i);
		}

		long res = A.get(min_deque.peek()) + A.get(max_deque.peek());

		for (int i = B; i < A.size(); i++) {
			if (i - B == min_deque.peek())
				min_deque.poll();
			if (i - B == max_deque.peek())
				max_deque.poll();

			while (!min_deque.isEmpty() && A.get(i) <= A.get(min_deque.peekLast()))
				min_deque.pollLast();

			min_deque.offer(i);

			while (!max_deque.isEmpty() && A.get(i) >= A.get(max_deque.peekLast()))
				max_deque.pollLast();

			max_deque.offer(i);

			res = (0L + res + A.get(min_deque.peek()) + A.get(max_deque.peek())) % m;
			if (res < 0)
				res += m;
		}

		return (int) res;
	}
}
