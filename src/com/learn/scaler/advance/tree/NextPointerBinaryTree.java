package com.learn.scaler.advance.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*
 * Problem Description
	Given a binary tree,
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	Initially, all next pointers are set to NULL.
	Assume perfect binary tree and try to solve this in constant extra space.
	
	
	Problem Constraints
	1 <= Number of nodes in binary tree <= 100000
	0 <= node values <= 10^9
	
	Input Format
	First and only argument is head of the binary tree A.
	
	Output Format
	Return the head of the binary tree after the changes are made.
	
	Example Input
	Input 1:
	 
	     1
	    /  \
	   2    3

	Input 2:

	        1
	       /  \
	      2    5
	     / \  / \
	    3  4  6  7
	
	
	Example Output
	Output 1:
	 
	        1 -> NULL
	       /  \
	      2 -> 3 -> NULL

	Output 2:
	         1 -> NULL
	       /  \
	      2 -> 5 -> NULL
	     / \  / \
	    3->4->6->7 -> NULL
	
	
	Example Explanation
	Explanation 1:
	Next pointers are set as given in the output.

	Explanation 2:
	Next pointers are set as given in the output.
 */
public class NextPointerBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode tree = new TreeLinkNode(1);
		tree.left = new TreeLinkNode(2);
		tree.right = new TreeLinkNode(3);
		connect(tree);
		connectNodes(tree);
	}

	public static void connectNodes(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList();
		queue.add(root);
		queue.add(null);
		while (queue.size() > 1) {
			TreeLinkNode node = queue.poll();
			if (Objects.isNull(node)) {
				queue.add(null);
			} else {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				node.next = queue.peek();
			}
		}
	}

	public static void connect(TreeLinkNode root) {
		join(root, null);
	}

	public static void join(TreeLinkNode cur, TreeLinkNode parent) {
		if (cur == null)
			return;
		if (parent != null && cur == parent.left) {
			cur.next = parent.right;
		}
		if (parent != null && cur == parent.right) {
			if (parent.next != null)
				cur.next = parent.next.left;
		}
		join(cur.left, cur);
		join(cur.right, cur);
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}