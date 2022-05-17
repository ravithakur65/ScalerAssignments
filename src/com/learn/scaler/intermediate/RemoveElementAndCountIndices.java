package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Problem Description

*	Given an array, arr[] of size N, the task is to find the count of array indices such that 
*	removing an element from these indices makes the sum of even-indexed and odd-indexed array 
*	elements equal.
*	Ex:
*	A=[2, 1, 6, 4]
*	Explanation:
*	Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, 
*	arr[0] + arr[2] = arr[1]. 
*	Therefore, the required output is 1. 
 */
public class RemoveElementAndCountIndices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(2, 1, 6, 4);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int B= 9;
		list.addAll(anotherList);
		System.out.println(solve(list));
	}
	public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> pfixOdd = new  ArrayList<Integer>();
		 ArrayList<Integer> pfixEven = new  ArrayList<Integer>();
		pfixOdd.add(0); pfixEven.add(A.get(0));
		int res =0;
		// creating prefix odd and even array.
		for(int i=1;i<A.size();i++) {
			if(i%2==0) {
				pfixEven.add(pfixEven.get(i-1)+A.get(i));
				pfixOdd.add(pfixOdd.get(i-1));
			}else {
				pfixEven.add(pfixEven.get(i-1));
				pfixOdd.add(pfixOdd.get(i-1)+A.get(i));
			}
		}

		
		for(int i=0;i<A.size();i++) {
			if(i==0) {
				// sumOdd == sumEven
				if(pfixEven.get(A.size()-1)-pfixEven.get(i)==pfixOdd.get(A.size()-1)-pfixOdd.get(i)) 
					res++;
			}else if(i==A.size()-1) {
				// sumOdd == sumEven
				if(pfixEven.get(A.size()-2)==pfixOdd.get(A.size()-2)) res++;
			}else{	
			int sumOdd = pfixOdd.get(i-1) + pfixEven.get(A.size()-1) - pfixEven.get(i);
			int sumEven = pfixEven.get(i-1) + pfixOdd.get(A.size()-1) - pfixOdd.get(i);
			if(sumOdd == sumEven) res++;
			}
		}
		
		return res;
    }
}
