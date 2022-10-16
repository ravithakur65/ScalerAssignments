package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
	Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
	Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

	NOTE:
	In the array, the NULL/None child is denoted by -1.
	For more clarification check the Example Input.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	Only argument is a A denoting the root node of a Binary Tree.
	
	Output Format
	Return an integer array denoting the Level Order Traversal of the given Binary Tree.
	
	Example Input
	Input 1:
	
	           1
	         /   \
	        2     3
	       / \
	      4   5
	Input 2:
	
	            1
	          /   \
	         2     3
	        / \     \
	       4   5     6
	
	
	Example Output
	Output 1:
	 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

	Output 2:
	 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
	
	Example Explanation
	Explanation 1:
	 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
	 Since 3, 4 and 5 each has both NULL child we had represented that using -1.

	Explanation 2:
	 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
	 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class SerializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> solve(TreeNode A) {
		if (A == null)
			return new ArrayList();

		// Define que and response list
		Queue<TreeNode> que = new LinkedList();
		ArrayList<Integer> resList = new ArrayList();

		que.add(A);

		while (que.size() != 0) {
			TreeNode temp = que.remove();

			// if temp is null that means no node is present insert -1 to ans
			if (temp == null) {
				resList.add(-1);
				continue;
			}
			// add current node value to result and add left and right children to Q
			resList.add(temp.val);
			que.add(temp.left);
			que.add(temp.right);
		}
		return resList;
	}
}
