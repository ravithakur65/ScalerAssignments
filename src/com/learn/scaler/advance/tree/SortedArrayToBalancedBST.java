package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
	Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	
	Problem Constraints
	1 <= length of array <= 100000
	
	Input Format
	First argument is an integer array A.
	
	Output Format
	Return a root node of the Binary Search Tree.
	
	Example Input
	Input 1:
	 A : [1, 2, 3]

	Input 2:
	 A : [1, 2, 3, 5, 10]
	
	Example Output
	Output 1:
	
	      2
	    /   \
	   1     3

	Output 2:
	
	      3
	    /   \
	   2     5
	  /       \
	 1         10
	
	
	Example Explanation
	Explanation 1:
	
	 You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  /*
			  3
		    /   \
		   2     5
		  /       \
		 1         10
	*/
		
		int[] arr = {1, 2, 3, 5, 10};
		
		visitTree(sortedArrayToBST(arr));
	}

	public static TreeNode sortedArrayToBST(final int[] A) {
		if (A.length < 2)
			return new TreeNode(A[0]);

		TreeNode root = construct(A, 0, A.length - 1);
		return root;
	}

	static TreeNode construct(int[] A, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;

		TreeNode newNode = new TreeNode(A[mid]);
		newNode.left = construct(A, start, mid - 1);
		newNode.right = construct(A, mid + 1, end);
		return newNode;
	}
	
	private static void visitTree(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.val+" ");
		visitTree(node.left);
		visitTree(node.right);
	}
}
