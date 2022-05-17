package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		/*
		 * List<String> list = Arrays.asList("aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaa");
		 */
		// List<String> list = Arrays.asList("abcd", "abcd", "efgh");
		/*
		 * List<String> list =
		 * Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "bbbbbbbbb", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 */
		List<String> list = Arrays.asList("ABCD");
		ArrayList<String> strArr = new ArrayList<>();
		strArr.addAll(list);
		//System.out.println(longestCommonPrefix(strArr));
		System.out.println(anotherSolution(strArr));
	}
	//TC: Optimized solution : O(NlogN)
	//SC: O(1)
	public static String anotherSolution(ArrayList<String> A) {
		// sort the array first
		Collections.sort(A);
		int len = Integer.MAX_VALUE;
		//find minimum length of the String
		for(String str: A) {
			len = Math.min(len, str.length());
		}
		// Iterate the loop till the min length of the string
		for(int i=0;i<len;i++) {
			//compare the chars of first and last String then return then sub-string from 0 to i
			if(A.get(0).charAt(i)!=A.get(A.size()-1).charAt(i)) 
				return A.get(0).substring(0, i);
		}
		//if there is only one String in the list then return that
		return A.get(0).substring(0, len);
	}

	//TC: O(N^2)
	//SC: O(1)
	public static String longestCommonPrefix(ArrayList<String> A) {
		if (A.size() == 1)
			return A.get(0);
		StringBuilder result = new StringBuilder();
		int length = findMinSizeString(A);
		for (int i = 0; i < length; i++) {
			boolean match = true;
			int j = 0;
			for ( ;j < A.size() - 1; j++) {
				if (A.get(j).charAt(i) != A.get(j + 1).charAt(i)) {
					match = false;
					break;
				}
			}
			if (match)
				result.append(A.get(j-1).charAt(i));
			else
				break;
		}
		return result.toString();
	}

	public static int findMinSizeString(ArrayList<String> A) {
		int size = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			size = Math.min(size, A.get(i).length());
		}
		return size;

	}
	
	
}
