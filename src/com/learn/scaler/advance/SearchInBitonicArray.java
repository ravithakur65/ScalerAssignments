package com.learn.scaler.advance;

/*
 * Problem Description
	Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
	NOTE:
	A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
	
	Problem Constraints
	3 <= N <= 105
	1 <= A[i], B <= 108
	Given array always contain a bitonic point.
	Array A always contain distinct elements.
	
	Input Format
	First argument is an integer array A denoting the bitonic sequence.
	Second argument is an integer B.
	
	Output Format
	Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.
	
	Example Input

	Input 1:
	 A = [3, 9, 10, 20, 17, 5, 1]
	 B = 20
	
	Input 2:
	 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
	 B = 30
	
	Example Output
	Output 1:
	 3

	Output 2:
	 -1
	
	Example Explanation
	Explanation 1:
	 B = 20 present in A at index 3

	Explanation 2:
	 B = 30 is not present in A
 */
public class SearchInBitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
		System.out.println(solve(num, 12));
	}

	public static int solve(int[] A, int B) {
		int ind = -1;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] < A[i]) {
				ind = i;
				break;
			}
		}
		int a = binarySearchInc(A, 0, ind, B);
		if (a == -1) {
			return binarySearchDec(A, ind + 1, A.length - 1, B);
		}
		return a;
	}

	static int binarySearchInc(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearchInc(arr, (mid + 1), high, key);
		return binarySearchInc(arr, low, (mid - 1), key);
	}
	static int binarySearchDec(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key < arr[mid])
			return binarySearchDec(arr, (mid + 1), high, key);
		return binarySearchDec(arr, low, (mid - 1), key);
	}

}
