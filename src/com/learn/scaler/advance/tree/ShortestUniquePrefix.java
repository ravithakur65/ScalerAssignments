package com.learn.scaler.advance.tree;

/*
 * Problem Description
	Given a list of N words, find the shortest unique prefix to represent each word in the list.
	NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
	
	Problem Constraints
	1 <= Sum of length of all words <= 106
	
	Input Format
	First and only argument is a string array of size N.
	
	Output Format
	Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
	
	Example Input
	Input 1:
	 A = ["zebra", "dog", "duck", "dove"]

	Input 2:
	A = ["apple", "ball", "cat"]
	
	Example Output
	Output 1:
	 ["z", "dog", "du", "dov"]

	Output 2:
	 ["a", "b", "c"]
	
	
	Example Explanation
	Explanation 1:
	 Shortest unique prefix of each word is:
	 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
	 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
	 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
	 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
	 
	Explanation 2:
	 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */
public class ShortestUniquePrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// TRIE NODE CLASS AND CONSTRUCTOR, CONTAINS FREQUENCY OF THE NODE//
	public class Node {
		Node[] children;
		int freq;

		Node() {
			this.children = new Node[26];
			this.freq = 0;
		}
	}

	Node root = new Node();

//ADDING WORDS TO DICTIONARY//
	public void addWord(Node root, String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			int charInt = word.charAt(i) - 'a';
			if (curr.children[charInt] == null) {
				curr.children[charInt] = new Node();
			}
//INCREASING FREQUENCY HERE//
			curr.children[charInt].freq++;
			curr = curr.children[charInt];
		}
	}

//FINDING UNIQUE PREFIXES//
//TRAVERSING TRIE AND APPENDING STRINGBUILDER,STOP WHEN FIND NODE WHOSE FREQUENCY == 1//
	public String findUniquePrefix(Node root, String word) {
		Node curr = root;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			int charInt = word.charAt(i) - 'a';
			ans.append(word.charAt(i));
			if (curr.children[charInt].freq == 1) {
				break;
			}
			curr = curr.children[charInt];
		}
		return ans.toString();
	}

	public String[] prefix(String[] A) {
		for (int i = 0; i < A.length; i++) {
			addWord(root, A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = findUniquePrefix(root, A[i]);
		}
		return A;
	}
}
