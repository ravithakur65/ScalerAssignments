/*
 * Problem Description
 *	Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *	
 *	If the given array contains a sub-array with sum zero return 1, else return 0.
 *	Problem Constraints
 *	1 <= |A| <= 100000
 *	
 *	-10^9 <= A[i] <= 10^9
 *	Input 1:
 *	
 *	 A = [1, 2, 3, 4, 5]
 *	 Output 1:
 *	 0
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArrayWith0Sum {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
	}
	 public static int solve(ArrayList<Integer> A) {
	        ArrayList<Long> prefixArr = new ArrayList<Long>();
	        if(A.get(0)!=0)
	            prefixArr.add((long)A.get(0));
	        else return 1;
	        for(int i=1;i<A.size();i++){
	            if(A.get(i)==0)
	                return 1;
	            if(prefixArr.get(i-1)+A.get(i)==0)
	                return 1;
	            prefixArr.add(prefixArr.get(i-1)+A.get(i));
	        }
	        Set<Long> set = new HashSet<Long>();
	        for(int i=0;i<prefixArr.size();i++){
	            set.add(prefixArr.get(i));
	        }

	        if(set.size()!=prefixArr.size())
	            return 1;
	        return 0;
	    }
}
