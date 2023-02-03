package com.learn.scaler.advance.linkedlist;

/*
 * Problem Description
    Given a sorted linked list, delete all duplicates such that each element appears only once.

    Problem Constraints
    0 <= length of linked list <= 106

    Input Format
    First argument is the head pointer of the linked list.

    Output Format
    Return the head pointer of the linked list after removing all duplicates.

    Example Input
    Input 1:
    1->1->2

    Input 2:
    1->1->2->3->3

    Example Output
    Output 1:
    1->2

    Output 2:
    1->2->3

    Example Explanation
    Explanation 1:

    Each element appear only once in 1->2.
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(2);
        A.next.next.next.next = new ListNode(3);
        A.next.next.next.next.next = new ListNode(3);
        A.next.next.next.next.next.next = new ListNode(4);
        A.next.next.next.next.next.next.next = new ListNode(4);
        A.next.next.next.next.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(8);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(8);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(10);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(10);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        A.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
       
        ListNode temp = new RemoveDuplicatesfromSortedList().deleteDuplicates(A);
       for (temp = A; temp != null; temp = temp.next) {
            System.out.print(temp.val + " ");
        }
    }

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null && A.next == null)
            return A;
        ListNode temp = A;

        while (temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return A;
    }

}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}