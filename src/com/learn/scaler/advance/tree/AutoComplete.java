package com.learn.scaler.advance.tree;
/*
 * Problem Description
	There is a dictionary A of N words, and ith word has a unique weight Wi.
	Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
	Output the words in decreasing order of their weight.
	NOTE: If there is no word that starts with the given prefix output -1.
	
	Problem Constraints
	1 <= T <= 5
	1 <= N <= 20000
	1 <= M <= 10000
	1 <= Wi <= 106
	1 <= length of any string either in A or B <= 30
	
	Input Format
	First line is an integer T denoting the number of test cases.
	For each test case,
	First line denotes two space seperated integer N and M.
	Second line denotes N space seperated strings denoting the words in dictionary.
	Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
	Fourth line denotes M space seperated integers denoting the prefixes.
	
	Output Format
	For every prefix B[i], print the space seperated output on a new line.
	
	NOTE: After every output there should be a space.
	
	Example Input
	Input 1:
	 1
	 6 3
	 abcd aecd abaa abef acdcc acbcc
	 2 1 3 4 6 5
	 ab abc a

	Input 2:
	 1
	 5 3
	 aaaa aacd abaa abaa aadcc
	 3 4 1 2 6 
	 aa aba abc
	
	
	Example Output
	Output 1:
	 abef abaa abcd 
	 abcd 
	 acdcc acbcc abef abaa abcd 

	Output 2:
	 aadcc aacd aaaa 
	 abaa abaa 
	 -1 
	
	
	Example Explanation
	Explanation 1:
	 For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
	 For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
	 For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
	 Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.

	Explanation 2:
	 For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
	 For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
	 For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


class TrieNode {
	char ch;
	HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
	ArrayList<Integer> index = new ArrayList();
	boolean isEnd = false;

	TrieNode(char x) {
		ch = x;
	}
}

public class AutoComplete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // T denoting the number of test cases
		for (int i = 0; i < T; i++) { // Loop to T tast cases
			int N = sc.nextInt();
			int M = sc.nextInt();
			String A[] = new String[N]; // for words
			for (int j = 0; j < N; j++) {
				A[j] = sc.next();
			}
			int W[][] = new int[N][2]; // take 2d array for weight and its index
			for (int j = 0; j < N; j++) { // we are doing this for easy acess of word using weight index
				W[j][0] = j;
				W[j][1] = sc.nextInt();
			}
			String B[] = new String[M]; // for prefixes
			for (int j = 0; j < M; j++) {
				B[j] = sc.next();
			}
			Arrays.sort(W, (a, b) -> Integer.compare(b[1], a[1])); // sort the 2d array in des order on basis of weight
			TrieNode root = new TrieNode(' ');
			for (int j = 0; j < N; j++) {
				insert(root, A[W[j][0]], W[j][0]); // this put word into trie and also index of that word till 5 of max
													// wieght words at evry node
			}
			for (int j = 0; j < M; j++) { // iterate over trie by prefixes and check
				TrieNode temp = check(B[j], root);
				if (temp == null) {
					System.out.print(-1 + " ");
				} else {
					for (int k = 0; k < temp.index.size(); k++) {
						System.out.print(A[temp.index.get(k)] + " ");
					}
				}
				System.out.println();
			}

		}
	}

	public static void insert(TrieNode root, String word, int idx) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!temp.child.containsKey(ch)) {
				temp.child.put(ch, new TrieNode(ch));
			}
			temp = temp.child.get(ch);
			if (temp.index.size() < 5) {
				temp.index.add(idx); // add the index of word
			}
		}
		temp.isEnd = true;
		return;
	}

	public static TrieNode check(String word, TrieNode root) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!temp.child.containsKey(ch)) {
				return null; // prefix does not exist
			}
			temp = temp.child.get(ch);
		}
		return temp;
	}
}
