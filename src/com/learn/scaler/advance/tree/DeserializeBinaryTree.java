package com.learn.scaler.advance.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
	You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
	You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

	NOTE:
	In the array, the NULL/None child is denoted by -1.
	For more clarification check the Example Input.
	
	Problem Constraints
	1 <= number of nodes <= 105
	-1 <= A[i] <= 105
	
	Input Format
	Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
	
	Output Format
	Return the root node of the Binary Tree.
	
	Example Input
	Input 1:
	 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

	Input 2:
	 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
	
	Example Output
	Output 1:
	
	           1
	         /   \
	        2     3
	       / \
	      4   5

	Output 2:
	            1
	          /   \
	         2     3
	        / \ .   \
	       4   5 .   6
	
	
	Example Explanation
	Explanation 1:
	 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
	 Since 3, 4 and 5 each has both NULL child we had represented that using -1.

	Explanation 2:
	 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
	 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class DeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
		inOrderTraversal(solve(list));
	}

	public static TreeNode solve(ArrayList<Integer> A) {
		TreeNode root = new TreeNode(A.get(0));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i = 1;
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (A.get(i) != -1) {
				temp.left = new TreeNode(A.get(i));
				q.add(temp.left);
			}
			i++;
			if (A.get(i) != -1) {
				temp.right = new TreeNode(A.get(i));
				q.add(temp.right);
			}
			i++;
		}
		return root;
	}
	
	public static void inOrderTraversal(TreeNode node) {
		if(node == null)
				return;
		inOrderTraversal(node.left);
		System.out.print(node.val+" ");
		inOrderTraversal(node.right);
	}
}
