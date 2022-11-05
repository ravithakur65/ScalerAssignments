package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
	
	Problem Constraints
	1 <= length of the array <= 100000
	0 <= A[i] <= 109
	
	Input Format
	The only argument given is the integer array A.
	
	Output Format
	Return an integer denoting the maximum result of A[i] XOR A[j].
	
	Example Input
	Input 1:
	 A = [1, 2, 3, 4, 5]

	Input 2:
	 A = [5, 17, 100, 11]
	
	
	Example Output
	Output 1:
	 7

	Output 2:
	 117
	
	Example Explanation
	Explanation 1:
	 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

	Explanation 2:
	 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */
public class MaximumXORUsingTries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numb = {6, 10, 9, 3, 10, 3, 4, 1, 5, 5, 1, 9, 6, 1, 8, 2, 5, 4, 6, 9, 6};
		System.out.println(solve(numb));
	}

	// TRIE NODE STRUCTURE AND CONSTRUCTOR//
	static class Node {
		Node[] children;

		Node() {
			this.children = new Node[2];
		}
	}

	static Node root = new Node();

	public static int addNumAndReturnMaxXor(Node root, int num) {
		// STEP 1: ADD THE NUMBER//
		Node curr = root;
		// INSERTING FROM MSB//
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (curr.children[bit] == null) {
				curr.children[bit] = new Node();
			}
			curr = curr.children[bit];
		}
		// STEP 2: FIND ITS MAX XOR, BY CONSIDERING THE NUMBERS OF OPPOSITE BIT//
		int xor = 0;
		curr = root;
		// CHECKING FROM MSB//
		for (int i = 31; i >= 0; i--) {
			int bit = ((num >> i) & 1) ^ 1;
			if (curr.children[bit] != null) {
				// FOUND OPPOSITE BIT, ADD TO ANS//
				xor += (1 << i);
				curr = curr.children[bit];
			} else {
				curr = curr.children[bit ^ 1];
			}
		}
		return xor;
	}

	public static int solve(int[] A) {
		int maxXor = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int xor = addNumAndReturnMaxXor(root, A[i]);
			maxXor = Math.max(xor, maxXor);
		}
		return maxXor;
	}
}
/*
 * public int solve(int[] A) { int max = Integer.MIN_VALUE; for (int i = 0; i <
 * A.length; i++) { for (int j = i + 1; j < A.length; j++) { int temp = A[i] ^
 * A[j]; if (temp> max) max = temp; } } return max; }
 */
