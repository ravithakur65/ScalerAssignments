package com.learn.scaler.intermediate.recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem Description
	Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
	A sudoku puzzle,
	
	and its solution numbers marked in red.
	
	Problem Constraints
	N = 9
	Input Format
	First argument is an array of array of characters representing the Sudoku puzzle.
	
	Output Format
	Modify the given input to the required answer.
	
	Example Input
	Input 1:
	A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
	
	Example Output
	Output 1:
	[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
	
	
	Example Explanation
	Explanation 1:
	
	Look at the diagrams given in the question.
 */
public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void solveSudoku(char[][] A) {

		Set<String> row = new HashSet<>();
		Set<String> column = new HashSet<>();
		Set<String> grid = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != '.') {
					row.add("row: " + i + " num " + A[i][j]);
					column.add("column " + j + " num " + A[i][j]);
					grid.add("grid " + i / 3 + " " + j / 3 + " num " + A[i][j]);
				}

			}
		}

		helper(A, row, column, grid, 0, 0);
	}

	private boolean helper(char[][] A, Set<String> row, Set<String> column, Set<String> grid, int i, int j) {
		if (i == 9) {
			return true;
		}

		boolean flag = false;
		if (A[i][j] != '.') {
			if (j == 8) {
				flag = helper(A, row, column, grid, i + 1, 0);
			} else {
				flag = helper(A, row, column, grid, i, j + 1);
			}
			if (flag) {
				return true;
			}
		} else {

			for (int num = 1; num <= 9; num++) {

				if (!row.contains("row: " + i + " num " + num) && !column.contains("column " + j + " num " + num)
						&& !grid.contains("grid " + i / 3 + " " + j / 3 + " num " + num)) {

					A[i][j] = (char) (num + '0');
					row.add("row: " + i + " num " + A[i][j]);
					column.add("column " + j + " num " + A[i][j]);
					grid.add("grid " + i / 3 + " " + j / 3 + " num " + A[i][j]);

					if (j == 8) {
						flag = helper(A, row, column, grid, i + 1, 0);
					} else {
						flag = helper(A, row, column, grid, i, j + 1);
					}

					if (flag) {
						return true;
					}
					row.remove("row: " + i + " num " + A[i][j]);
					column.remove("column " + j + " num " + A[i][j]);
					grid.remove("grid " + i / 3 + " " + j / 3 + " num " + A[i][j]);
					A[i][j] = '.';
				}

			}
		}

		return false;

	}
}
