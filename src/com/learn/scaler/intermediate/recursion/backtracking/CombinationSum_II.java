package com.learn.scaler.intermediate.recursion.backtracking;
/*
 * Problem Description
	Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
	Each number in A may only be used once in the combination.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	The solution set must not contain duplicate combinations.
	Warning:
	DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

	Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
	
	Problem Constraints
	1 <= N <= 20
	
	Input Format
	First argument is an integer array A denoting the collection of candidate numbers.
	Second argument is an integer which represents the target number.
	
	Output Format
	Return all unique combinations in A where the candidate numbers sums to B.
	
	
	
	Example Input
	Input 1:
	
	 A = [10, 1, 2, 7, 6, 1, 5]
	 B = 8
	Input 2:
	
	 A = [2, 1, 3]
	 B = 3
	
	
	Example Output
	Output 1:
	
	 [ 
	  [1, 1, 6 ],
	  [1, 2, 5 ],
	  [1, 7 ], 
	  [2, 6 ] 
	 ]
	Output 2:
	
	 [
	  [1, 2 ],
	  [3 ]
	 ]
	
	
	Example Explanation
	Explanation 1:
	
	 1 + 1 + 6 = 8
	 1 + 2 + 5 = 8
	 1 + 7 = 8
	 2 + 6 = 8
	 All the above combinations sum to 8 and are arranged in ascending order.
	Explanation 2:
	
	 1 + 2 = 3
	 3 = 3
	 All the above combinations sum to 3 and are arranged in ascending order.
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CombinationSum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Pair {
		int num;
		int freq;

		public Pair(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
	}

	public void combinationSum(ArrayList<Pair> input, int idx, int target, ArrayList<Integer> curr,
			ArrayList<ArrayList<Integer>> output) {
		// Base Cases
		if (target == 0) {
			output.add(new ArrayList<>(curr));
			return;
		}
		if (target < 0 || idx == input.size()) {
			return;
		}
		for (int i = 0; i <= input.get(idx).freq; ++i) {
			int t = target;
			for (int j = 0; j < i; ++j) {
				curr.add(input.get(idx).num);
				t -= input.get(idx).num;
			}
			combinationSum(input, idx + 1, t, curr, output);
			for (int j = 0; j < i; ++j) {
				curr.remove(curr.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> input, int target) {
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> curr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (Integer integer : input) {
			if (map.containsKey(integer)) {
				map.put(integer, map.get(integer) + 1);
			} else {
				map.put(integer, 1);
			}
		}
		ArrayList<Pair> pairs = new ArrayList<>();
		for (Integer integer : map.keySet()) {
			pairs.add(new Pair(integer, map.get(integer)));
		}
		combinationSum(pairs, 0, target, curr, output);
		return output;

	}
}
