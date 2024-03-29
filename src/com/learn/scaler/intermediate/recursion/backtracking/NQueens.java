package com.learn.scaler.intermediate.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem Description
	The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each other.
	
	Given an integer A, return all distinct solutions to the n-queens puzzle.
	
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
	The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
	
	
	Problem Constraints
	1 <= A <= 10
	
	
	
	Input Format
	First argument is an integer n denoting the size of chessboard
	
	
	
	Output Format
	Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
	
	
	
	Example Input
	Input 1:
	
	A = 4
	Input 2:
	
	A = 1
	
	
	Example Output
	Output 1:
	
	[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
	Output 1:
	
	[
	 [Q]
	]
	
	
	Example Explanation
	Explanation 1:
	
	There exist only two distinct solutions to the 4-queens puzzle:
	Explanation 1:
	
	There exist only one distinct solutions to the 1-queens puzzle:
 */
public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Set<Integer> colSet = new HashSet<>();
	private Set<Integer> diag1 = new HashSet<>();
	private Set<Integer> diag2 = new HashSet<>();

	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		dfs(result, new ArrayList<Integer>(), 0, n);
		return result;
	}

	private void dfs(ArrayList<ArrayList<String>> result, List<Integer> list, int row, int n) {
		if (row == n) {
			ArrayList<String> tempList = new ArrayList<>();
			for (int x : list) {
				char[] arr = new char[n];
				Arrays.fill(arr, '.');
				arr[x] = 'Q';
				tempList.add(new String(arr));
			}
			result.add(tempList);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (colSet.contains(col) || diag1.contains(row + col) || diag2.contains(row - col))
				continue;

			// do
			list.add(col);
			colSet.add(col);
			diag1.add(row + col);
			diag2.add(row - col);

			// call
			dfs(result, list, row + 1, n);

			// undo
			list.remove(list.size() - 1);
			colSet.remove(col);
			diag1.remove(row + col);
			diag2.remove(row - col);

		}
	}
}
