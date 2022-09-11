package com.learn.scaler.advance;

/*
 * Problem Description
	Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
	Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
	
	Problem Constraints
	1 <= N <= 106
	
	Input Format
	The only argument given is a string A.

	Output Format
	Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.
	
	Example Input

	Input 1:
	 A = "abc"

	Input 2:
	 A = "bb"
	
	Example Output
	Output 1:
	 2

	Output 2:
	 0
	
	Example Explanation
	Explanation 1:
	 Insert 'b' at beginning, string becomes: "babc".
	 Insert 'c' at beginning, string becomes: "cbabc".

	Explanation 2:
	 There is no need to insert any character at the beginning as the string is already a palindrome.
 */
public class MakeStringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abc"));
	}

	public static int solve(String A) {
		StringBuilder sb = new StringBuilder(A);
		sb.reverse();
		String palin = A + "$" + sb;
		int[] lps = new int[palin.length()];
		createLps(palin, lps);

		return A.length() - lps[lps.length - 1];
	}

	static void createLps(String A, int[] lps) {
		int i = 1, j = 0;
		while (i < A.length()) {
			if (A.charAt(i) == A.charAt(j)) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j > 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}
}
