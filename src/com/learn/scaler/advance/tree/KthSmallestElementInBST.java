package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
	
	Problem Constraints
	1 <= Number of nodes in binary tree <= 100000
	0 <= node values <= 10^9
	
	Input Format
	First and only argument is head of the binary tree A.
	
	Output Format
	Return an integer, representing the Bth element.
	
	Example Input
	Input 1:
	 
	            2
	          /   \
	         1    3
	B = 2

	Input 2:
	            3
	           /
	          2
	         /
	        1
	B = 1
	
	Example Output
	Output 1:
	 2

	Output 2:
	 1
	
	Example Explanation
	Explanation 1:
	2nd element is 2.

	Explanation 2:
	1st element is 1.
 */
public class KthSmallestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(2);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(3);
		
		int B = 2;
		System.out.println(kthsmallest(tree, 2));
	}

	public static int kthsmallest(TreeNode root, int B) {
		int count = 0;
		while (root != null) {
			TreeNode left = root.left;
			if (left == null) {
				count++;
				if (count == B) {
					return root.val;
				}
				root = root.right;
			} else {
				while (left.right != null && left.right != root) {
					left = left.right;
				}
				if (left.right == null) {
					left.right = root;
					root = root.left;
				} else if (left.right == root) {
					count++;
					if (count == B)
						return root.val;
					root = root.right;
					left.right = null;
				}
			}
		}
		return -1;
	}
}
