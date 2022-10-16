package com.learn.scaler.advance.tree;

public class OddAndEvenLevels {
	public static void main(String[] args) {

	}
	public int solve(TreeNode A) {
		if (A == null)
			return 0;
		return A.val - solve(A.left) - solve(A.right);
	}
}
