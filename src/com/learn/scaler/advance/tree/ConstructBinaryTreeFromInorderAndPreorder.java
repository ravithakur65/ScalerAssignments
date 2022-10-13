package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Description
	Given preorder and inorder traversal of a tree, construct the binary tree.
	NOTE: You may assume that duplicates do not exist in the tree.
	
	Problem Constraints
	1 <= number of nodes <= 105
	
	Input Format
	First argument is an integer array A denoting the preorder traversal of the tree.
	Second argument is an integer array B denoting the inorder traversal of the tree.
	
	Output Format
	Return the root node of the binary tree.
	
	Example Input
	Input 1:
	 A = [1, 2, 3]
	 B = [2, 1, 3]

	Input 2:
	 A = [1, 6, 2, 3]
	 B = [6, 1, 3, 2]
	
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
 */
public class ConstructBinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inorder = new ArrayList<>();
		ArrayList<Integer> postorder = new ArrayList<>();
		inorder.addAll(Arrays.asList(1,2,3));
		postorder.addAll(Arrays.asList(2,1,3));
		TreeNode result = buildTree(inorder, postorder);
		System.out.print("Inorder: ");
		inOrder(result);
		System.out.println();
		System.out.print("PreOrder: ");
		preOrder(result);
	}
	private static Map<Integer, Integer> map;
    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        map = new HashMap<>();
        for(int i = 0; i < B.size(); i++) {
            map.put(B.get(i), i);
        }
        return buildTree(A, B, 0, B.size()-1, 0, A.size()-1);
    }

    private static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int Sin, int Ein, int Spre, int Epre) {
        if(Sin > Ein) 
            return null;
        TreeNode root = new TreeNode(A.get(Spre));
        int index = map.get(A.get(Spre));
        int x = index - 1;
        int sizeLST = x - Sin + 1;
        root.left = buildTree(A, B, Sin, x, Spre+1, sizeLST + Spre);
        root.right = buildTree(A, B, index+1, Ein, Spre+1 + sizeLST, Epre);

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
    static void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
