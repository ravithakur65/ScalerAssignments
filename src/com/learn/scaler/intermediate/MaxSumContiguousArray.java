package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Description
Find the contiguous non empty subarray within an array, A of length N which has the largest sum.
Input 1:
 A = [1, 2, 3, 4, -10]
 Explanation:
 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.  
 */
public class MaxSumContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(-1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int B= 9;
		list.addAll(anotherList);
		System.out.println(maxSubArray(list));

	}
	public static int maxSubArray(final List<Integer> A) {
	       int maxSum=Integer.MIN_VALUE;
		        for(int i=0;i<A.size();i++){
	                 int sum=0;
		            for(int j=i;j<A.size();j++){
	                    sum+=A.get(j);
	                    if(sum>=maxSum)
	                        maxSum = sum;
		            }
		        }
		        return maxSum;
	    }

}
