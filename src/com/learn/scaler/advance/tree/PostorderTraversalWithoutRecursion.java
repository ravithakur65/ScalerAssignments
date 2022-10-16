package com.learn.scaler.advance.tree;
/*
 * Problem Description
	Given a binary tree, return the Postorder traversal of its nodes values.
	NOTE: Using recursion is not allowed.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First and only argument is root node of the binary tree, A.
	
	Output Format
	Return an integer array denoting the Postorder traversal of the given binary tree.
	
	Example Input
	Input 1:
	
	   1
	    \
	     2
	    /
	   3
	Input 2:
	
	   1
	  / \
	 6   2
	    /
	   3
	
	
	Example Output
	Output 1:
	 [3, 2, 1]

	Output 2:
	 [6, 3, 2, 1]
	
	Example Explanation
	Explanation 1:
	 The Preoder Traversal of the given tree is [3, 2, 1].

	Explanation 2:
	 The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversalWithoutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		System.out.println(postorderTraversal(tree));
	}

	public static ArrayList<Integer> postorderTraversal(TreeNode A) {

		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();

		if (A == null) {
			return result;
		}

		TreeNode current = A;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				result.add(current.val);
				current = current.right;
			}

			current = stack.pop();
			current = current.left;
		}

		Collections.reverse(result);
		return result;
	}
	
	public static void inOrderTraversal(TreeNode node) {
		if(node == null)
				return;
		inOrderTraversal(node.left);
		System.out.print(node.val+" ");
		inOrderTraversal(node.right);
	}
}
