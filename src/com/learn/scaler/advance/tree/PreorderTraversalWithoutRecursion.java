package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given a binary tree, return the preorder traversal of its nodes values.
	NOTE: Using recursion is not allowed.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First and only argument is root node of the binary tree, A.
	
	Output Format
	Return an integer array denoting the preorder traversal of the given binary tree.
	
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
	 [1, 2, 3]

	Output 2:
	 [1, 6, 2, 3]
	
	Example Explanation
	Explanation 1:
	 The Preoder Traversal of the given tree is [1, 2, 3].
	Explanation 2:
	
	 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversalWithoutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(6);
		tree.right = new TreeNode(2);
		tree.right.left = new TreeNode(3);
		System.out.println(preorderTraversal(tree));
	}

	/*
	 * 1. If root is null , simply return. 2. else , create an empty stack and push
	 * root node into it. 3. Check if the Stack is non-empty . If so, pop the
	 * element from the stack and print it. 4. Now, Check if the right child of
	 * popped element is available or not . if available then push it into stack. 5.
	 * Similarly , Check for the left child . If available then push it into the
	 * stack. 6. Now , continue step 3 ,4,5 until stack becomes empty . 7. If Stack
	 * becomes empty then stop.
	 */
	public static ArrayList<Integer> preorderTraversal(TreeNode A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = A;
		stack.push(currentNode);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop(); // removing the top element from stack.
			result.add(temp.val);
			if (temp.right != null)
				stack.push(temp.right); // inserting into stack
			if (temp.left != null)
				stack.push(temp.left); // inserting into stack
		}

		return result;
	}
}
