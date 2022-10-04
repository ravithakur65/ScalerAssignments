package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Description

	Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
	
	Problem Constraints
	1 <= number of nodes <= 100000
	
	Input Format
	First and only argument is an integer array denoting the preorder traversal of binary tree.
	
	Output Format
	Return a string "YES" if true else "NO".
	
	Example Input
	Input 1:
	 A : [4, 10, 5, 8]

	Input 2:
	 A : [1, 5, 6, 4]
	
	Example Output
	Output 1:
	 "YES"

	Output 2:
	 "NO"
	
	Example Explanation
	Explanation 1:
	 The possible BST is:
	            4
	             \
	             10
	             /
	             5
	              \
	              8
	Explanation 2:
	
	 There is no possible BST which have the above preorder traversal.
 */
public class CheckForBSTWithOneChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(new ArrayList<>(Arrays.asList(1, 5, 6, 4))));
	}

	public static String solve(ArrayList<Integer> A) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		TreeNode node = null;
		for (int i = 0; i < A.size(); i++) {
			if (node == null) {
				node = new TreeNode(A.get(i));
			} else if (A.get(i) <= node.val && A.get(i) > min) {
				node.left = new TreeNode(A.get(i));
				max = node.val;
				node = node.left;
			} else if (A.get(i) >= node.val && A.get(i) < max) {
				node.right = new TreeNode(A.get(i));
				min = node.val;
				node = node.right;
			} else
				return "NO";
		}
		return "YES";
	}
}
