package com.learn.scaler.advance;
/*
 * Partition List
	
	Problem Description
	Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
	You should preserve the original relative order of the nodes in each of the two partitions.
	
	Problem Constraints
	1 <= |A| <= 106
	1 <= A[i], B <= 109
	
	Input Format
	The first argument of input contains a pointer to the head to the given linked list.
	The second argument of input contains an integer, B.
	
	Output Format
	Return a pointer to the head of the modified linked list.
	
	
	Example Input
	Input 1:
	
	A = [1, 4, 3, 2, 5, 2]
	B = 3

	Input 2:
	A = [1, 2, 3, 1, 3]
	B = 2
	
	Example Output
	Output 1:
	[1, 2, 2, 4, 3, 5]

	Output 2:
	[1, 1, 2, 3, 3]
	
	Example Explanation
	Explanation 1:
	 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.

	Explanation 2:
	 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.
 */
public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		public ListNode partition(ListNode A, int B) {
			ListNode left = new ListNode(0);
			ListNode lhead = left;
			ListNode right = new ListNode(B);
			ListNode rhead = right;
			ListNode curr = A;
			while (curr != null) {
				if (curr.val < B) {
					left.next = curr;
					curr = curr.next;
					left = left.next;
				} else {
					right.next = curr;
					curr = curr.next;
					right = right.next;
				}
			}

			left.next = null;
			right.next = null;

			if (rhead.next != null) {
				rhead = rhead.next;
			} else
				rhead = null;
			if (lhead.next != null) {
				lhead = lhead.next;
			} else
				lhead = null;

			if (lhead == null)
				return rhead;
			if (rhead == null)
				return lhead;
			left.next = rhead;
			return lhead;
		}
	}
}
