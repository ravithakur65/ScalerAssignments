package com.learn.scaler.advance;

import java.util.List;

/*
 * Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

	NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
	
	Example:
	
	A : [2 1 4 3 2]
	k : 3
	
	Answer : 2
	Constraints :
	
	1 <= number of elements in the price list <= 1000000
	1 <= k <= number of elements in the price list
 */
public class KthPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Approach: Using Binary Search //Search Space: Min of Array to Max on Array
	// (Kth Price can be a number between these two) //Condition : For every mid,
	// check number of elements equal to it in the array and number of elements less than it
	// Lowest rank that this mid can have = number of elements less than it +1
	// (Calling this lowRange)
	// Highest rank that this mid can have = number of elements less than it +
	// Number of element equal to (Calling this highRange) it
	// When to go left : When B is less than lowRange
	// When to go right : When B is outside lowRange or highRange OR when B is
	// within the range but there aren't any elements equal to mid in the array

	public int solve(final List<Integer> A, int B) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int N = A.size();
		for (int i = 0; i < N; i++) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}
		int l = min;
		int h = max;
		int ans = min;
		while (l <= h) {
			int m = (l + h) / 2;
			int less = countless(A, m);
			int equal = counteq(A, m);
			int lowRange = less + 1;
			int highRange = less + equal;
			if (B >= lowRange && B <= highRange) {
				if (equal > 0) {
					ans = m;
					break;
				} else {
					l = m + 1;
				}
			}
			if (B < lowRange) {
				h = m - 1;
			}
			if (B > highRange) {
				l = m + 1;
			}
		}
		return ans;
	}

	public int countless(final List<Integer> A, int n) {
		int N = A.size();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (A.get(i) < n) {
				count++;
			}
		}
		return count;
	}

	public int counteq(final List<Integer> A, int n) {
		int N = A.size();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (A.get(i) == n) {
				count++;
			}
		}
		return count;
	}

}
