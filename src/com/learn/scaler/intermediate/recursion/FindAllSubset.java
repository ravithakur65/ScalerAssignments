package com.learn.scaler.intermediate.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllSubset {

	public static void main(String[] args) {
		System.out.println(subsets(new ArrayList<Integer>(List.of(1,2,3))));
	}
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
		 ArrayList<ArrayList<Integer>> totalSubsets = new ArrayList<>();
		        Collections.sort(A);
		        backtrack(totalSubsets, new ArrayList<Integer>(), A, 0);
		        return totalSubsets;
		    }

		    private static void backtrack(ArrayList<ArrayList<Integer>> totalSubsets, ArrayList<Integer> subset, 
		        ArrayList<Integer> nums, int start) {
		            totalSubsets.add(new ArrayList<>(subset));
		            for (int k=start; k<nums.size(); k++) {
		                subset.add(nums.get(k));
		                backtrack(totalSubsets, subset, nums, k + 1);
		                subset.remove(subset.size()-1);
		    }
		}
}
