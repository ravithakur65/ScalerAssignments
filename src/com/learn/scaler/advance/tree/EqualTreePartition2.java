package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
	
	Problem Constraints
	1 <= size of tree <= 100000
	0 <= value of node <= 109
	
	Input Format
	First and only argument is head of tree A.
	
	Output Format
	Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
	
	Example Input
	Input 1:
	
	 
	                5
	               /  \
	              3    7
	             / \  / \
	            4  6  5  6
	Input 2:
	
	 
	                1
	               / \
	              2   10
	                  / \
	                 20  2
	
	
	Example Output
	Output 1:
	 1

	Output 2:
	 0
	
	Example Explanation
	Explanation 1:
	 Remove edge between 5(root node) and 7: 
	        Tree 1 =                                               Tree 2 =
	                        5                                                     7
	                       /                                                     / \
	                      3                                                     5   6    
	                     / \
	                    4   6
	        Sum of Tree 1 = Sum of Tree 2 = 18
	Explanation 2:
	
	 The given Tree cannot be partitioned.
 */
public class EqualTreePartition2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				TreeNode tree = new TreeNode(5);
				tree.left = new TreeNode(3);
				tree.right = new TreeNode(7);
				tree.left.left = new TreeNode(4);
				tree.left.right = new TreeNode(6);
				tree.right.left = new TreeNode(5);
				tree.right.right = new TreeNode(6);
				System.out.println(solve(tree));
	}

	static int possible = 0;

	public static int solve(TreeNode A) {
		int totSum = findTotalSum(A);
		isPossible(A, totSum);
		return possible;
	}

	public static int findTotalSum(TreeNode A) {
		if (A == null) {
			return 0;
		}
		return A.val + findTotalSum(A.right) + findTotalSum(A.left);
	}

	public static boolean isPossible(TreeNode root, int totalSum) {
		if (root == null) {
			return false;
		}
		int leftSum = findTotalSum(root.left);
		int rightSum = findTotalSum(root.right);
		if (leftSum * 2 == totalSum || rightSum * 2 == totalSum) {
			possible = 1;
			return true;
		} else {
			return isPossible(root.left, totalSum) || isPossible(root.right, totalSum);
		}
	}
}
