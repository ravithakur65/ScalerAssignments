package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given a binary tree, return the inorder traversal of its nodes' values.
	NOTE: Using recursion is not allowed.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First and only argument is root node of the binary tree, A.
	
	Output Format
	Return an integer array denoting the inorder traversal of the given binary tree.
	
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
	 [1, 3, 2]

	Output 2:
	 [6, 1, 3, 2]
	
	Example Explanation
	Explanation 1:
	 The Inorder Traversal of the given tree is [1, 3, 2].

	Explanation 2:
	 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(6);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(tree));
	}
/*
 *  1. Create an empty stack to store nodes. 
	2. Push the root node to the stack. 
	3. Run a loop while the stack is not empty 
	4. Pop the top node from stack. 
	5. Print the popped node. 
	6. Store all the children of popped node onto the stack. We must store children from right to left so that leftmost node is popped first. 
	7. If stack is empty then we are done.
 */
	public static ArrayList<Integer> inorderTraversal(TreeNode A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = A;
		while (currentNode != null || stack.size() > 0) {

			/*
			 * Reach the left most Node of the curr Node
			 */
			while (currentNode != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				stack.push(currentNode);
				currentNode = currentNode.left;
			}

			/* Current must be NULL at this point */
			currentNode = stack.pop();

			result.add(currentNode.val);

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			currentNode = currentNode.right;
		}

		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}
