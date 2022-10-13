package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given the inorder and postorder traversal of a tree, construct the binary tree.
	NOTE: You may assume that duplicates do not exist in the tree.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First argument is an integer array A denoting the inorder traversal of the tree.
	Second argument is an integer array B denoting the postorder traversal of the tree.
	
	Output Format
	Return the root node of the binary tree.
	
	Example Input
	Input 1:
	 A = [2, 1, 3]
	 B = [2, 3, 1]

	Input 2:
	 A = [6, 1, 3, 2]
	 B = [6, 3, 2, 1]
	
	
	Example Output
	Output 1:
	
	   1
	  / \
	 2   3

	Output 2:
	   1  
	  / \
	 6   2
	    /
	   3
	
	Example Explanation
	Explanation 1:
	
	 Create the binary tree and return the root node of the tree.
	 
	 Reference: https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ConstructBinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inorder = new ArrayList<>();
		ArrayList<Integer> postorder = new ArrayList<>();
		inorder.addAll(Arrays.asList(1,2,3));
		postorder.addAll(Arrays.asList(2,1,3));
		TreeNode result = buildTreeAnotherMethod(inorder, postorder);
		inOrder(result);
		System.out.println();
		postOrder(result);
	}

	public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		return buildBinaryTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
	}

	/*
	 * Recursive function to construct binary of size n from Inorder traversal in[]
	 * and Postorder traversal post[]. Initial values of inStrt and inEnd should be
	 * 0 and n -1. The function doesn't do any error checking for cases where
	 * inorder and postorder do not form a tree
	 */
	private static TreeNode buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inStrt,
			int inEnd, int postStrt, int postEnd) {
		// Base case
		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Postorder traversal using postIndex and decrement
		 * postIndex
		 */
		TreeNode node = new TreeNode(postorder.get(postEnd));

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return node;
		int iIndex = search(inorder, inStrt, inEnd, node.val);

		/*
		 * Using index in Inorder traversal, construct left and right subtrees
		 */
		node.left = buildBinaryTree(inorder, postorder, inStrt, iIndex - 1, postStrt, postStrt - inStrt + iIndex - 1);
		node.right = buildBinaryTree(inorder, postorder, iIndex + 1, inEnd, postEnd - inEnd + iIndex, postEnd - 1);

		return node;
	}

	/*
	 * Function to find index of value in arr[start...end] The function assumes that
	 * value is postsent in in[]
	 */
	static int search(ArrayList<Integer> arr, int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr.get(i) == value)
				break;
		}
		return i;
	}

	// Different approach to build the binary tree
	private static int index;

	public static TreeNode buildTreeAnotherMethod(ArrayList<Integer> A, ArrayList<Integer> B) {
		if (A == null || B == null || A.size() != B.size()) {
			return null;
		}
		index = A.size() - 1;
		return buildBTree(A, B, 0, index);
	}

	private static TreeNode buildBTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int left, int right) {
		if (index < 0 || left > right) {
			return null;
		}

		TreeNode root = new TreeNode(postorder.get(index));

		for (int i = left; i <= right; i++) {
			if (Objects.equals(postorder.get(index), inorder.get(i))) {
				index--;
				root.right = buildBTree(inorder, postorder, i + 1, right);
				root.left = buildBTree(inorder, postorder, left, i - 1);
				break;
			}
		}
		return root;
	}
	
	/* This function is here just to test  */
    static void inOrder(TreeNode node)
    {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    /* This function is here just to test  */
    static void postOrder(TreeNode node)
    {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
}
