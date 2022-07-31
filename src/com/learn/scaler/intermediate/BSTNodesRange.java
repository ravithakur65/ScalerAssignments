package com.learn.scaler.intermediate;

public class BSTNodesRange {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		TreeNode node12 = new TreeNode(12);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node14 = new TreeNode(14);
		TreeNode node16 = new TreeNode(16);
		TreeNode node27 = new TreeNode(27);
		TreeNode node8 = new TreeNode(8);
		
		root.left = node12;
		root.right = node20;
		node12.left = node10;
		node12.right = node14;
		node10.left = node8;
		
		node20.left = node16;
		node20.right = node27;
		System.out.println(solve(root,12, 20));
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