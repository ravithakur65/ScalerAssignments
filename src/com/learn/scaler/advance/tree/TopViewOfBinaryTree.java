package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
	Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
	The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
	Return the nodes in any order.
	
	Problem Constraints
	1 <= Number of nodes in binary tree <= 100000
	0 <= node values <= 10^9
	
	Input Format
	First and only argument is head of the binary tree A.
	
	Output Format
	Return an array, representing the top view of the binary tree.
	
	Example Input
	Input 1:
	 
	            1
	          /   \
	         2    3
	        / \  / \
	       4   5 6  7
	      /
	     8 

	Input 2:
	            1
	           /  \
	          2    3
	           \
	            4
	             \
	              5
	
	
	Example Output
	Output 1:
	 [1, 2, 4, 8, 3, 7]

	Output 2:
	 [1, 2, 3]
	
	Example Explanation
	Explanation 1:
	Top view is described.

	Explanation 2:
	Top view is described.
 */
public class TopViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
					1
		          /   \
		         2     3
		        / \   / \
		       4   5  6  7
		      /
		     8 
     */
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.left.left = new TreeNode(4);
		tree.left.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(5);
		tree.right = new TreeNode(3);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(7);
		
		System.out.println(solve(tree));
		
	}

	public static ArrayList<Integer> solve(TreeNode A) {
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();

		leftQueue.add(A.left);
		rightQueue.add(A.right);

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(A.val);

		// first process all the leftNodes.
		while (!leftQueue.isEmpty()) {
			TreeNode node = leftQueue.poll();

			if (node == null)
				break;

			leftQueue.add(node.left);
			arr.add(node.val);
		}
		// then process all the right.
		while (!rightQueue.isEmpty()) {
			TreeNode node = rightQueue.poll();

			if (node == null)
				break;

			rightQueue.add(node.right);
			arr.add(node.val);
		}

		return arr;
	}
}
