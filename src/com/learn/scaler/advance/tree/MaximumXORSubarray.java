package com.learn.scaler.advance.tree;

import java.util.HashMap;

/*
 * Problem Description
	Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
	NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.
	
	Problem Constraints
	1 <= N <= 100000
	0 <= A[i] <= 109
	
	Input Format
	First and only argument is an integer array A.
	
	Output Format
	Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.
	
	Example Input
	Input 1:
	 A = [1, 4, 3]

	Input 2:
	 A = [8]
	
	Example Output
	Output 1:
	 [2, 3]

	Output 2:
	 [1, 1]
	
	Example Explanation
	Explanation 1:
	 There are 6 possible subarrays of A:
	 subarray            XOR value
	 [1]                     1
	 [4]                     4
	 [3]                     3
	 [1, 4]                  5 (1^4)
	 [4, 3]                  7 (4^3)
	 [1, 4, 3]               6 (1^4^3)
	
	 [4, 3] subarray has maximum XOR value. So, return [2, 3].

	Explanation 2:
	 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1]. 
 */
public class MaximumXORSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numb = {1, 4, 3};
		for(int num : solve(numb))
			System.out.print(num+" ");
	}

	// NODE STRUCTURE AND CONSTRUCTOR//
	static class Node {
		Node[] children;

		Node() {
			this.children = new Node[2];
		}
	}

	static Node root = new Node();

	// ADD NUMBER TO TRIE AND CALCULATE ITS MAX XOR//
	public static int addNumAndReturnMaxXor(Node root, int num) {
		Node curr = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (int) (num >> i) & 1;
			if (curr.children[bit] == null) {
				curr.children[bit] = new Node();
			}
			curr = curr.children[bit];
		}
		int xor = 0;
		curr = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (int) ((num >> i) & 1) ^ 1;
			if (curr.children[bit] != null) {
				xor += (1 << i);
				curr = curr.children[bit];
			} else {
				curr = curr.children[bit ^ 1];
			}
		}
		return xor;
	}

	public static int[] solve(int[] A) {
		int[] prefXor = new int[A.length + 1];
		prefXor[0] = 0;
		for (int i = 1; i < prefXor.length; i++) {
			prefXor[i] = A[i - 1] ^ prefXor[i - 1];
		}
		int maxXor = Integer.MIN_VALUE;
		for (int i = 0; i < prefXor.length; i++) {
			int xor = addNumAndReturnMaxXor(root, prefXor[i]);
			maxXor = Math.max(maxXor, xor);
		}
		// FOUND MAX_XOR, NOW FIND START AND END INDEX OF THE SUBARRAY, SUCH THAT ITS
		// LENGTH AND START ARE MINIMUM//
		HashMap<Integer, Integer> map = new HashMap<>();
		int minLen = Integer.MAX_VALUE;
		int minStart = Integer.MAX_VALUE;
		int minEnd = Integer.MAX_VALUE;
		for (int i = 0; i < prefXor.length; i++) {
			int val = maxXor ^ prefXor[i];
			if (map.containsKey(val)) {
				int start = map.get(val) + 1;
				int end = i;
				int len = end - start + 1;
				if (len < minLen) {
					minLen = len;
					minStart = start;
					minEnd = end;
				} else if (len == minLen && start < minStart) {
					minLen = len;
					minStart = start;
					minEnd = end;
				}
			}
			map.put(prefXor[i], i);
		}
		return new int[] { minStart, minEnd };
	}
}
