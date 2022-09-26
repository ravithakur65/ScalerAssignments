package com.learn.scaler.advance;

/*
 * Flatten a linked list
	Solved
	character backgroundcharacter
	Stuck somewhere?
	Ask for help from a TA and get it resolved.
	Get help from TA.
	Problem Description
	Given a linked list where every node represents a linked list and contains two pointers of its type:
	
	Pointer to next node in the main list (right pointer)
	Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
	You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
	
	
	Problem Constraints
	1 <= Total nodes in the list <= 100000
	1 <= Value of node <= 109
	
	
	Input Format
	The only argument given is head pointer of the doubly linked list.
	
	Output Format
	Return the head pointer of the Flattened list.
	
	Example Input
	Input 1:
	   3 -> 4 -> 20 -> 20 ->30
	   |    |    |     |    |
	   7    11   22    20   31
	   |               |    |
	   7               28   39
	   |               |
	   8               39

	Input 2:
	   2 -> 4 
	   |    |       
	   7    11    
	   |            
	   7
	
	
	Example Output
	Output 1:
	 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 

	Output 2:
	 2 -> 4 -> 7 -> 7 -> 11
	
	Example Explanation
	Explanation 1:
	
	 The return linked list is the flatten sorted list.
 */
public class FlattenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 12
			5
			4 3 7 7 8 
			2 4 11 
			2 20 22 
			4 20 20 28 39 
			3 30 31 39 
			5
		 */
	}

	ListNode flatten(ListNode root) {
		if (root == null || root.right == null) {
			return root;
		}
		ListNode midBefore = findMidBefore(root);
		ListNode secondHalf = midBefore.right;
		midBefore.right = null;
		ListNode h1 = flatten(root);
		ListNode h2 = flatten(secondHalf);
		return merge(h1, h2);
	}

	ListNode findMidBefore(ListNode A) {
		ListNode slow = A;
		ListNode fast = A;
		while (fast.right != null && fast.right.right != null) {
			fast = fast.right.right;
			slow = slow.right;
		}
		return slow;
	}

	ListNode merge(ListNode A, ListNode B) {
		ListNode curr1 = A;
		ListNode curr2 = B;
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				res.down = curr1;
				curr1 = curr1.down;
				res = res.down;
			} else {
				res.down = curr2;
				curr2 = curr2.down;
				res = res.down;
			}
		}
		if (curr1 != null) {
			res.down = curr1;
		}
		if (curr2 != null) {
			res.down = curr2;
		}
		return dummy.down;
	}
}

class ListNode {
	int val;
	ListNode right, down;

	ListNode(int x) {
		val = x;
		right = down = null;
	}
}
