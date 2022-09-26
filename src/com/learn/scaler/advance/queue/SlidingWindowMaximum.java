package com.learn.scaler.advance.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Description
	Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
	Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
	Refer to the given example for clarity.
	NOTE: If B > length of the array, return 1 element with the max of the array.
	
	Problem Constraints
	1 <= |A|, B <= 106
	
	Input Format
	The first argument given is the integer array A.
	The second argument given is the integer B.
	
	Output Format
	Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
	
	Example Input
	Input 1:
	 A = [1, 3, -1, -3, 5, 3, 6, 7]
	 B = 3

	Input 2:
	 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
	 B = 6

	Example Output
	Output 1:
	 [3, 3, 5, 5, 6, 7]

	Output 2:
	 [7, 7, 7, 7]
	
	Example Explanation
	Explanation 1:
	
	 Window position     | Max
	 --------------------|-------
	 [1 3 -1] -3 5 3 6 7 | 3
	 1 [3 -1 -3] 5 3 6 7 | 3
	 1 3 [-1 -3 5] 3 6 7 | 5
	 1 3 -1 [-3 5 3] 6 7 | 5
	 1 3 -1 -3 [5 3 6] 7 | 6
	 1 3 -1 -3 5 [3 6 7] | 7

	Explanation 2:
	
	 Window position     | Max
	 --------------------|-------
	 [1 2 3 4 2 7] 1 3 6 | 7
	 1 [2 3 4 2 7 1] 3 6 | 7
	 1 2 [3 4 2 7 1 3] 6 | 7
	 1 2 3 [4 2 7 1 3 6] | 7
	 
	 Solution:
	 1. use a deque
	 2. only allow value less than last element of the deque to insert at last.
	 3. if A[i]>last element of the dequeue, keep removing from last until q.peekLast()>A[i]
	 4. first element or dequeue.peekFirst() will be the maximum element of the window

 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7);
		int B = 3;
		System.out.println(slidingMaximum(list, B));
	}

	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		Deque<Integer> q = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		q.add(A.get(0));
		for (int i = 1; i < B; i++) {
			while (!q.isEmpty() && q.peekLast() <= A.get(i)) {
				q.removeLast();
			}
			q.addLast(A.get(i));
		}
		ans.add(q.peekFirst());
		for (int i = B; i < A.size(); i++) {
			if (q.peekFirst() == A.get(i - B)) {
				q.removeFirst();
			}
			while (!q.isEmpty() && q.peekLast() <= A.get(i)) {
				q.removeLast();
			}
			q.addLast(A.get(i));
			ans.add(q.peekFirst());
		}
		return ans;
	}
}
