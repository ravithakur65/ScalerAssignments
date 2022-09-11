package com.learn.scaler.advance;

/*
 * Problem Description
	Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
	Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
	
	Problem Constraints
	1 <= N, M <= 100000

	Example Input
	Input 1:
	 A = "abba"
	 B = "cdd"

	Input 2:
	 A = "acd"
	 B = "bay"

	Example Output

	Output 1:
	 "abbac"
	
	Output 2:
	 "ab"
	
	Example Explanation

	Explanation 1:
	 We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
	 The lexicographically smallest string will be "abbac".
	
	Explanation 2:
	 We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
	 The lexicographically smallest string will be "ab".
 */
public class SmallestPrefixString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "twvvsl";
		String B = "wtcyawv";
		System.out.println(smallestPrefix(A, B));
		System.out.println(smallestPrefixAnother(A, B));
	}

	public static String smallestPrefix(String A, String B) {
		String ans = "";
		ans += A.charAt(0);
		int i = 1;
		char bval = B.charAt(0);
		while (i < A.length() && A.charAt(i) <= bval) {
			ans += A.charAt(i);
			if (A.charAt(i) == bval)
				return ans;
			i++;
		}
		ans += bval;
		return ans;
	}
	
	public static String smallestPrefixAnother(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A.charAt(0));
        for(int i=1;i<A.length();i++){
            if(A.charAt(i)<B.charAt(0)){
                sb.append(A.charAt(i));
            }else if(A.charAt(i)==B.charAt(0)) {
                    return sb.append(B.charAt(0)).toString();
                }
            else
                break;
        }
        return sb.append(B.charAt(0)).toString();
    }
}
