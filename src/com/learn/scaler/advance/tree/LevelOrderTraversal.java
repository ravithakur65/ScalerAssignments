package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
	Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First and only argument is root node of the binary tree, A.
	
	Output Format
	Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
	
	Example Input
	Input 1:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7

	Input 2:
	   1
	  / \
	 6   2
	    /
	   3
	
	Example Output
	Output 1:
	
	 [
	   [3],
	   [9, 20],
	   [15, 7]
	 ]

	Output 2:
	
	 [ 
	   [1]
	   [6, 2]
	   [3]
	 ]
	
	
	Example Explanation
	Explanation 1:
	
	 Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		System.out.println(levelOrder(tree));
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		while (!q.isEmpty()) {
			int currentQSize = q.size();
			ArrayList<Integer> level = new ArrayList<>();
			for (int i = 0; i < currentQSize; i++) {
				if (q.peek().left != null) {
					q.add(q.peek().left);
				}
				if (q.peek().right != null) {
					q.add(q.peek().right);
				}
				level.add(q.remove().val);
			}
			result.add(level);
		}
		return result;
	}
}
