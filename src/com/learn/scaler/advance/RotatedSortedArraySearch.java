package com.learn.scaler.advance;

/*
 * Problem Description
Given a sorted array of integers A of size N and an integer B. Array A is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index otherwise, return -1. You may assume no duplicate exists in the array.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are distinct.

Example Input
Input 1:
A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4 

Input 2:
A = [1]
B = 1

Example Output
Output 1:
 0 

Output 2:
 0

Example Explanation

Explanation 1:
Target 4 is found at index 0 in A. 

Explanation 2:
Target 1 is found at index 0 in A.


 */
public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4, 5, 6, 7, 0, 1, 2, 3};
		System.out.println("At Index: "+binarySearchSolution(num, 5));
	}

	public int search(final int[] A, int B) {
		int start = 0;
		int end = A.length;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (A[mid] == B)
				return mid;
			else if (A[mid] < B) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;
	}

	public static int binarySearchSolution(final int[] A, int B) {
		int ind = -1;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] < A[i]) {
				ind = i;
			}
		}
		int a = binarySearch(A, 0, ind, B);
		if (a == -1) {
			return binarySearch(A, ind + 1, A.length - 1, B);
		}
		return a;
	}

	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}
}
