package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("hello", "scaler", "interviewbit");
		String B = "adhbcfegskjlponmirqtxwuvzy";
		//List<String> list = Arrays.asList("fine", "none", "no");
		//String B = "qwertyuiopasdfghjklzxcvbnm";
		ArrayList<String> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(solve(arrList, B));
	}

	public static int solve(ArrayList<String> A, String B) {

		for (int i = 0; i < A.size() - 1; i++) {
			String word1 = A.get(i);
			String word2 = A.get(i + 1);
			if (word1.length() > word2.length())
				return 0;
			int minLen = Math.min(word1.length(), word2.length());
			for (int j = 0; j < minLen; j++) {
				if(word1.charAt(j)!=word2.charAt(j)) {
					if (B.indexOf(word1.charAt(j)) > B.indexOf(word2.charAt(j)))
						return 0;
					else
						break;
				}
			}
		}
		return 1;
	}
}
