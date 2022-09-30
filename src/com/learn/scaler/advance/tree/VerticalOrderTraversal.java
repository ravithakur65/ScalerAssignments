package com.learn.scaler.advance.tree;
/*
 * Problem Description
	Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
	NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
	
	
	Problem Constraints
	0 <= number of nodes <= 105
	
	Input Format
	First and only argument is a pointer to the root node of binary tree, A.
	
	Output Format
	Return a 2D array denoting the vertical order traversal of tree as shown.
	
	
	Example Input
	Input 1:
	
	      6
	    /   \
	   3     7
	  / \     \
	 2   5     9
	Input 2:
	
	      1
	    /   \
	   3     7
	  /       \
	 2         9
	
	
	Example Output
	Output 1:
	
	 [
	    [2],
	    [3],
	    [6, 5],
	    [7],
	    [9]
	 ]
	Output 2:
	
	 [
	    [2],
	    [3],
	    [1],
	    [7],
	    [9]
	 ]
	
	
	Example Explanation
	Explanation 1:
	
 First row represent the vertical line 1 and so on.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 
	      6
	    /   \
	   3     7
	  / \     \
	 2   5     9
 */
		
		TreeNode tree = new TreeNode(6);
		tree.left = new TreeNode(3);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(5);
		tree.right = new TreeNode(7);
		tree.right.right = new TreeNode(9);
		System.out.println(verticalOrderTraversal(tree));
		
	}

	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		return traversalVerticalOrder(A);
	}

	static class Pair {
		public TreeNode treeNode;
		public Integer level;

		// constructor
		public Pair(TreeNode treeNode, Integer level) {
			this.treeNode = treeNode;
			this.level = level;
		}
	}

	static HashMap<Integer, ArrayList<Integer>> freqMap = new HashMap();
	static Queue<Pair> que = new LinkedList();
	static int maxl = 0;
	static int minl = 0;

	public static ArrayList<ArrayList<Integer>> traversalVerticalOrder(TreeNode A) {
		// Add root node to Queue
		Pair rootPair = new Pair(A, 0);
		que.add(rootPair);

		while (!que.isEmpty()) {
			Pair tempPair = que.remove();
			TreeNode temp = tempPair.treeNode;
			int level = tempPair.level;

			// update max and min value
			maxl = Math.max(maxl, level);
			minl = Math.min(minl, level);

			// Step 1. insert into HashMap < level , List<Values of TreeNode>>
			if (freqMap.containsKey(level)) {
				// add to existing ArrayList
				ArrayList<Integer> currList = freqMap.get(level);
				currList.add(temp.val);
				freqMap.put(level, currList);
			} else {
				// create new new LinkedList
				ArrayList<Integer> newList = new ArrayList();
				newList.add(temp.val);
				freqMap.put(level, newList);
			}

			// Step 2.Put left level child into Queue
			if (temp.left != null) {
				Pair leftPair = new Pair(temp.left, level - 1);
				que.add(leftPair);
			}

			// Step 3.Put right level child into Queue
			if (temp.right != null) {
				Pair rightPair = new Pair(temp.right, level + 1);
				que.add(rightPair);
			}
		}

		// Iterate frequencyMap starting from minl -->maxl and add to response list
		ArrayList<ArrayList<Integer>> responseList = new ArrayList();
		for (int i = minl; i <= maxl; i++) {
			responseList.add(freqMap.get(i));
		}
		return responseList;
	}
}
