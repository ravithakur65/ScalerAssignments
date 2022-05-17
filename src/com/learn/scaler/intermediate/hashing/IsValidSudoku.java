package com.learn.scaler.intermediate.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * List<String> list = Arrays.asList("....5..1.", ".4.3.....", ".....3..1",
		 * "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....",
		 * "..4......");
		 */
		List<String> list = Arrays.asList("..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........." );
		System.out.println(isValidSudoku(list));
	}

	public static int isValidSudoku(final List<String> A) {


		// iterate all the rows and check for duplicate
		for (int row = 0; row < A.size(); row++) {
			Set<Character> set = new HashSet<Character>();
			for (int col = 0; col < A.size(); col++) {
				if (A.get(row).charAt(col) != '.') {
					if (!set.add(A.get(row).charAt(col)))
						return 0;
				}
			}
		}
		// iterate all the cols and check for duplicate
		for (int col = 0; col < A.size(); col++) {
			Set<Character> set = new HashSet<Character>();
			for (int row = 0; row < A.size(); row++) {
				if (A.get(row).charAt(col) != '.') {
					if (!set.add(A.get(row).charAt(col)))
						return 0;
				}
			}
		}
		// iterate all the boxes and check for duplicate
		/*
		 * Starting point for each 3x3 matrix
		 * (0,0) (0,3) (0,6)	
		 * (3,0) (3,3) (3,6)
		 * (6,0) (6,3) (6,6)
		 */
		int[] ele = { 0, 3, 6 };
		for (int l = 0; l < 3; l++) {
			for (int r = 0; r < 3; r++) {
				int box_r = ele[l];
				int box_c = ele[r];
				Set<Character> set = new HashSet<Character>();
				for (int x = box_r; x < box_r + 3; x++) {
					for (int y = box_c; y < box_c + 3; y++) {
						if (A.get(x).charAt(y) != '.') {
							if (!set.add(A.get(x).charAt(y)))
								return 0;
						}
					}
				}
			}
		}
		return 1; 

	}

}
