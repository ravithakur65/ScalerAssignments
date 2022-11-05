package com.learn.scaler.intermediate.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Problem Description
	Given an integer array A of size N denoting collection of numbers , return all possible permutations.
	NOTE:
	No two entries in the permutation sequence should be the same.
	For the purpose of this problem, assume that all the numbers in the collection are unique.
	Return the answer in any order
	WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
	Example : next_permutations in C++ / itertools.permutations in python.
	If you do, we will disqualify your submission retroactively and give you penalty points.
	
	Problem Constraints
	1 <= N <= 9
	
	Input Format
	Only argument is an integer array A of size N.
	
	Output Format
	Return a 2-D array denoting all possible permutation of the array.
	
	Example Input
	A = [1, 2, 3]
	
	Example Output
	[ [1, 2, 3]
	  [1, 3, 2]
	  [2, 1, 3] 
	  [2, 3, 1] 
	  [3, 1, 2] 
	  [3, 2, 1] ]
	
	Example Explanation
	All the possible permutation of array [1, 2, 3].
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3));
		System.out.println(permute(list));
	}

	static ArrayList<ArrayList<Integer>> result;

	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		result = new ArrayList<>();
		ArrayList<Integer> smallList = A;
		generateList(0, A.size(), A, smallList);
		return result;
	}

	public static void generateList(int i, int n, ArrayList<Integer> A, ArrayList<Integer> smallList) {
		if (i == n) {
			result.add(new ArrayList<>(smallList));
			return;
		}
		for (int j = i; j < n; j++) {
			// do
			Collections.swap(smallList, j, i);
			// Recur
			generateList(i + 1, n, A, smallList);
			// undo
			Collections.swap(smallList, j, i);
		}
	}
}
