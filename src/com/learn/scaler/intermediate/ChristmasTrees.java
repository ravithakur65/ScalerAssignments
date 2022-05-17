/*
 * Problem Description
	You are given an array A consisting of heights of Christmas trees and an array B of the 
	same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, 
	where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, 
	and r), such that Ap < Aq < Ar, where p < q < r.
	The cost of these trees is Bp + Bq + Br.
	
	You are to choose 3 trees such that their total cost is minimum. Return that cost.
	If it is not possible to choose 3 such trees return -1.
	
	Problem Constraints
	1 <= A[i], B[i] <= 109
	3 <= size(A) = size(B) <= 3000
	
	Input 1:
	 A = [1, 3, 5]
	 B = [1, 2, 3]
	 
	 Output 1:
    	6 
	 We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6. 
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChristmasTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrA = Arrays.asList(1, 3, 5);
		ArrayList<Integer> listA = new ArrayList<Integer>();
		listA.addAll(arrA);
		List<Integer> arrB = Arrays.asList(1, 2, 3);
		ArrayList<Integer> listB = new ArrayList<Integer>();
		listB.addAll(arrB);
		System.out.println(solve(listA,listB));
	}
	
	/*
	 * Optimized approach
	 */
		public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		       int minCost = Integer.MAX_VALUE;
				for(int i=1;i<A.size()-1;i++) {
					int temp = A.get(i);
		            int cost=0;
		            int minLeft = Integer.MAX_VALUE;
		            int minRight = Integer.MAX_VALUE; 
					//count left smaller numbers
					for(int j=i-1;j>=0;j--) {
						if(temp>A.get(j))
		                    minLeft = Math.min(minLeft, B.get(j));			
		            }

					//count right greater numbers
					for(int k=i+1;k<A.size();k++) {
						if(temp<A.get(k))
		                    minRight = Math.min(minRight, B.get(k));		
		            }
		            if(minLeft == Integer.MAX_VALUE || minRight == Integer.MAX_VALUE) 
		                continue;
		            else 
		                cost = minLeft + B.get(i) + minRight;

		            minCost = Math.min(minCost, cost);
				}
		         return minCost == Integer.MAX_VALUE ? -1 : minCost;
		    }
	
	/*Brute force approach
	 * 
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<A.size();i++) {
			for(int j=i+1;j<A.size();j++) {
				int sum = 0;
				for(int k=j+1;k<A.size();k++) {
					if(A.get(i)<A.get(j) && A.get(j)<A.get(k) && A.get(i)<A.get(k)) {
						sum = B.get(i)+B.get(j)+B.get(k);
						ans = Math.min(ans, sum);
					}
				}
			}
		}
		if(ans==Integer.MAX_VALUE)
            return -1;
		return ans;
    }
    */
}
