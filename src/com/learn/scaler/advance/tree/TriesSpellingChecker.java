package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Problem Description
	Given an array of words A (dictionary) and another array B (which contain some words).
	You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
	Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
	Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
	NOTE: Try to do this in O(n) time complexity.
	
	Problem Constraints
	1 <= |A| <= 1000
	1 <= sum of all strings in A <= 50000
	1 <= |B| <= 1000
	
	Input Format
	First argument is array of strings A.
	First argument is array of strings B.
	
	Output Format
	Return the binary array of integers according to the given format.
	
	Example Input
	Input 1:
	A = [ "hat", "cat", "rat" ]
	B = [ "cat", "ball" ]

	Input 2:
	A = [ "tape", "bcci" ]
	B = [ "table", "cci" ]
	
	Example Output
	Output 1:
	[1, 0]

	Output 2:
	[0, 0]
	
	
	Example Explanation
	Explanation 1:
	Only "cat" is present in the dictionary.

	Explanation 2:
	None of the words are present in the dictionary.
 */
public class TriesSpellingChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> listA = new ArrayList<>();
		ArrayList<String> listB = new ArrayList<>();
		listA.addAll(Arrays.asList("hat", "cat", "rat"));
		listB.addAll(Arrays.asList("cat", "ball"));
		System.out.println(solve(listA,listB));
	}

	public static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			insertWord(root, A.get(i));
		}
		for (int i = 0; i < B.size(); i++) {
			res.add(searchWord(root, B.get(i)) ? 1 : 0);
		}
		return res;
	}

	// ROOT INITIALIZER//
	static Node root = new Node('/');

//INSERT WORD METHOD//
	public static void insertWord(Node root, String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			int childInt = word.charAt(i) - 'a';
			if (curr.children[childInt] == null) {
				curr.children[childInt] = new Node(word.charAt(i));
			}
			curr = curr.children[childInt];
		}
		curr.isEnd = true;
	}

//SEARCH WORD METHOD//
	public static boolean searchWord(Node root, String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			int childInt = word.charAt(i) - 'a';
			if (curr.children[childInt] == null) {
				return false;
			} else {
				curr = curr.children[childInt];
			}
		}
		return curr.isEnd == true;
	}

}

//TRIE NODE STRUCTURE AND CONSTRUCTOR//
class Node {
	char data;
	Node[] children;
	boolean isEnd;

	Node(char data) {
		this.data = data;
		this.children = new Node[26];
		this.isEnd = false;
	}
}
