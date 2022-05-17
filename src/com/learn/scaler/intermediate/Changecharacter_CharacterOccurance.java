/*
 * Problem Description

	Given a string A of size N consisting of lowercase alphabets.
	You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
	Find the minimum number of distinct characters in the resulting string.

	Example Input
	A = "abcabbccd"
	B = 3
	
	Example Explanation:
	We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
	So the minimum number of distinct character will be 2.
 */
package com.learn.scaler.intermediate;

import java.util.Arrays;

public class Changecharacter_CharacterOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abcabbccd", 3));
	}
	public static int solve(String A, int B) {
        int[] alphabets = new int[26];
        for(int i=0;i<A.length();i++){
            alphabets[A.charAt(i)-'a']++;
        }
        Arrays.sort(alphabets);
        int count = 0 ;
        int ans = 0;
        for(int i=0;i<26;i++) {
        	if(alphabets[i]!=0) {
	        	count+=alphabets[i];
	        	if(count>B)
	        		ans++;
        	}
        }
        
        return ans;
    }
}
