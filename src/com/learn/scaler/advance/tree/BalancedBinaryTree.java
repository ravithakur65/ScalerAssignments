package com.learn.scaler.advance.tree;
/*
 * Balanced Binary Tree
 * Problem Description
	Given a root of binary tree A, determine if it is height-balanced.
	A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	
	Problem Constraints
	1 <= size of tree <= 100000
	
	Input Format
	First and only argument is the root of the tree A.
	
	Output Format
	Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
	
	Example Input
	Input 1:
	    1
	   / \
	  2   3

	Input 2:
	 
	       1
	      /
	     2
	    /
	   3
	
	
	Example Output
	Output 1:
	1

	Output 2:
	0
	
	Example Explanation
	Explanation 1:
	It is a complete binary tree.

	Explanation 2:
	Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
	Difference = 2 > 1.
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 	1
		   / \
		  2   3
		*/
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		System.out.println(isBalanced(tree));
	}

	/**
	 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode(int x) { val = x; left=null; right=null; } }
	 */
	static boolean flag = false;

	public static int isBalanced(TreeNode A) {
		// res variable is dummy
		countHight(A);
		return flag ? 0 : 1;
	}

	public static int countHight(TreeNode x) {
		if (x == null)
			return -1;
		int left = countHight(x.left) + 1;
		int right = countHight(x.right) + 1;
		if (Math.abs(left - right) > 1)
			flag = true;
		return Math.max(left, right);
	}

	
	//Another solution
	public int isBalancedTree(TreeNode A) {
		return isTreeBalanced(A);
	}

	int isTreeBalanced(TreeNode A) {
		if (A == null)
			return 1;
		if (Math.abs(height(A.left) - height(A.right)) > 1)
			return 0;
		return ((isTreeBalanced(A.left) & isTreeBalanced(A.right)) == 1) ? 1 : 0;
	}

	// compute height for each node
	int height(TreeNode A) {
		if (A == null)
			return 0;
		return 1 + Math.max(height(A.left), height(A.right));
	}
}
