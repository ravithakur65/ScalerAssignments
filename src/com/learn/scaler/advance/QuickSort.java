package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array A, sort the array using QuickSort.
 * Problem Constraints
	1 <= |A| <= 105
	1 <= A[i] <= 109

	Example Input
	Input 1:
	A = [1, 4, 10, 2, 1, 5]

	Input 2:
	A = [3, 7, 1]
	
	
	Example Output
	
	Output 1:
	 [1, 1, 2, 4, 5, 10]

	Output 2:
	 [1, 3, 7]
	
	
	Example Explanation

	Explanation 1:
 	Return the sorted array.
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 4, 10, 2, 1, 5);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(list);
		System.out.println(solve(arrList));
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		quickSort(A, 0, A.size() - 1);
		return A;
	}

	private static void quickSort(ArrayList<Integer> A, int s, int e) {

		if (s >= e) {
			return;
		}

		// generate indx range from which random pivot is needed
		int max = s + 1;
		int min = e;
		int range = max - min + 1;
		// get random pivot
		int RandomPivot = (int) (Math.random() * range) + min;
		// swap A[s]&A[RandomPivot]
		int temp = A.get(s);
		A.set(s, A.get(RandomPivot));
		A.set(RandomPivot, temp);

		int pivot = partition(A, s, e);
		quickSort(A, s, pivot - 1);
		quickSort(A, pivot + 1, e);
	}

	private static int partition(ArrayList<Integer> A, int s, int e) {
		int l = s + 1;
		int r = e;

		while (l <= r) {
			if (A.get(l) <= A.get(s)) {
				l++;
			} else if (A.get(r) > A.get(s)) {
				r--;
			} else {
				// swap A[l]&A[r]
				int temp = A.get(l);
				A.set(l, A.get(r));
				A.set(r, temp);
				l++;
				r--;
			}
		}
		// swap A[s]&A[r]
		int temp = A.get(s);
		A.set(s, A.get(r));
		A.set(r, temp);

		return r;
	}

}
