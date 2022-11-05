package com.learn.scaler.advance.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Description
	Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
	B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
	Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
	
	NOTE:
	You can start buying from time = 0.
	Return your answer modulo 109 + 7.
	
	Problem Constraints
	1 <= N <= 105
	1 <= A[i] <= 109
	0 <= B[i] <= 109
	
	Input Format
	The first argument is an integer array A represents the deadline for buying the cars.
	The second argument is an integer array B represents the profit obtained after buying the cars.
	
	Output Format
	Return an integer denoting the maximum profit you can earn.
	
	Example Input
	Input 1:
	 A = [1, 3, 2, 3, 3]
	 B = [5, 6, 1, 3, 9]

	Input 2:
	 A = [3, 8, 7, 5]
	 B = [3, 1, 7, 19]
	
	Example Output
	Output 1:
	 20

	Output 2:
	 30
	
	Example Explanation
	Explanation 1:
	 At time 0, buy car with profit 5.
	 At time 1, buy car with profit 6.
	 At time 2, buy car with profit 9.
	 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
	 So, total profit that one can earn is 20.

	Explanation 2:
	 At time 0, buy car with profit 3.
	 At time 1, buy car with profit 1.
	 At time 2, buy car with profit 7.
	 At time 3, buy car with profit 19.
	 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
 */
public class FreeCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Using MIN HEAP. TC: O(NLogN) and SC: O(N)
	 */
	public int solve(int[] A, int[] B) {
		Deal[] deals = new Deal[A.length];
		int mod = 1000000007;

		// Create array of objects(Deadline, Profit)
		for (int i = 0; i < A.length; i++) {
			deals[i] = new Deal(A[i], B[i]);
		}

		// Sort based on deadline
		Arrays.sort(deals, (a, b) -> {
			if (a.deadline < b.deadline) {
				return -1;
			} else {
				return 1;
			}
		});

		// We are using min heap as we need less deadline at every step
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		long ans = 0;
		int timer = 0;
		for (Deal deal : deals) {
			if (timer < deal.deadline) {
				timer++;
				minHeap.add(deal.profit);
				ans += deal.profit;
				ans %= mod;
			} else {
				if (deal.profit > minHeap.peek()) {
					int min = minHeap.poll();
					ans -= min;
					ans %= mod;
					minHeap.add(deal.profit);
					ans += deal.profit;
					ans %= mod;
				}
			}
		}
		return (int) (ans % mod);
	}

	static class Deal {
		int deadline;
		int profit;

		Deal(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}
}
