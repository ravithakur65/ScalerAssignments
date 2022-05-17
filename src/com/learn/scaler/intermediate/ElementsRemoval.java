/*
 * Problem Description
	Given an integer array A of size N. You can remove any element from the array in one operation.
	The cost of this operation is the sum of all elements in the array present before this operation.
	Find the minimum cost to remove all elements from the array.
	
	Input:  A = [2, 1]
	explanation:
	Given array A = [2, 1]
	 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
	 Remove 1 from the array => []. Cost of this operation is (1) = 1.
	 So, total cost is = 3 + 1 = 4.
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ElementsRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = Arrays.asList(2, 1);
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(arr);
		System.out.println(solve(list));
	}

	 public static int solve(ArrayList<Integer> A) {
	        Collections.sort(A,Collections.reverseOrder());
	        int cost = 0;
	        for(int i=0;i<A.size();i++){
	            cost = cost+A.get(i)*(i+1);
	        }
	        return cost;
	    }
}
