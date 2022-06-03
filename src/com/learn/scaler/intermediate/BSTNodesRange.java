package com.learn.scaler.intermediate;

public class BSTNodesRange {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(15);
		TreeNode node2 = new TreeNode(15);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(15);
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(15);
		TreeNode node8 = new TreeNode(15);
		System.out.println(solve(node,12, 20));
	}

	public static int solve(TreeNode A, int B, int C) {
		int count = 0;
		if (A == null)
			return 0;

		int l = solve(A.left, B, C);
		if (A.val >= B && A.val <= C)
			count++;
		int r = solve(A.right, B, C);

		return count;
	}
}

//Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}