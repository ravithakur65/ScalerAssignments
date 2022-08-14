package com.learn.scaler.advance;

/*
 * Problem Description
	Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
	
	Problem Constraints
	1 <= N <= 1000000
	1 <= A[i] <= 1000000

	Input Format
	First and only argument is an array of non-negative integers of size N.
	
	Output Format
	Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.
	
	Example Input
	Input 1:
	A = [1, 3, 2, 4, 5]

	Input 2:
	A = [1, 2, 3, 4, 5]
	
	Example Output
	Output 1:
	[1, 2]

	Output 2:
	[-1]
	
	
	Example Explanation
	Explanation 1:
	If we sort the sub-array A1, A2, then the whole array A gets sorted.

	Explanation 2:
	A is already sorted.
 */
public class MaximumUnsortedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 2, 4, 5};
		int[] result = solve(numbers);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
	}

	private static int[] solve(int[] A) {
		int n = A.length;
		int i = 0;
		int j = n - 1;
		//find the index from left to right where sorting fail
		while (i < n - 1 && A[i] <= A[i + 1])
			i++;
		//find the index from right to left where sorting fail
		while (j > 0 && A[j] >= A[j - 1])
			j--;
		//if the i is equal to the array size hence array is already sorted, no need to check subArray size
		if (i == n - 1)
			return new int[] { -1 };
		//find the minimum and maximum elements in the unsorted subArray [i,j] from i to j
		int max = A[i + 1];
		int min = A[i + 1];
		for (int k = i; k <= j; k++) {
			max = Math.max(A[k], max);
			min = Math.min(A[k], min);
		}
		int left = 0;
		int right = n - 1;
		//from 0 to i, find the first index where the element is greater than to the minimum
		while (left <= i && A[left] <= min)
			left++;
		//from n-1 to j, find the first index where the element is less than  to the maximum
		while (right >= j && A[right] >= max)
			right--;
		//return the index
		return new int[] { left, right };
	}
}
