package com.learn.scaler.advance.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Description
	Given an integer array B of size N.
	You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
	NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
	
	Problem Constraints
	1 <= N <= 100000
	1 <= A <= N
	1 <= B[i] <= INT_MAX
	
	Input Format
	The first argument is an integer A.
	The second argument is an integer array B of size N.
	
	Output Format
	Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].
	
	Example Input
	Input 1:
	 A = 4  
	 B = [1 2 3 4 5 6] 

	Input 2:
	 A = 2
	 B = [15, 20, 99, 1]
	
	
	Example Output
	Output 1:
	 [-1, -1, -1, 1, 2, 3]

	Output 2:
	 [-1, 15, 20, 20]
	
	Example Explanation
	Explanation 1:
	 for i <= 3 output should be -1.
	 for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
	 for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
	 for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
	 So, output array is [-1, -1, -1, 1, 2, 3].

	Explanation 2:
	 for i <= 1 output should be -1.
	 for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
	 for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
	 for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
	 So, output array is [-1, 15, 20, 20].
 */
public class AthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> num = new ArrayList<>();
		num.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		int A = 4;
		System.out.println(solve(A, num));
	}

	public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		ArrayList<Integer> answer = new ArrayList<>();
		int i = 0;
		while (i < A - 1) {
			answer.add(-1);
			pQueue.add(B.get(i));
			i++;
		}
		pQueue.add(B.get(i));
		answer.add(pQueue.peek());
		i++;
		while (i < B.size()) {
			int minElementInHeap = pQueue.peek();
			if (B.get(i) > minElementInHeap) {
				pQueue.poll();
				pQueue.add(B.get(i));
				answer.add(pQueue.peek());
			} else {
				answer.add(minElementInHeap);
			}
			i++;
		}
		return answer;
	}
}