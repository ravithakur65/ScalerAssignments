package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem Description
You are given an array of integers of N size.
You have to find that there is any subsequence exists or not whose sum is equal to B.

	Input 1:
	A=[1,20,13,4,5]
	B=18
	Explanation 1:
 	There is as subsequence present at indexes 1,3,4 whose sum is 18
 */
public class SubsequenceSumProblem {

	public static void main(String[] args) {
		List<Integer> arr = List.of(1,20,13,4,5);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.addAll(arr);
		int B = 5;
		System.out.println(solve(arrList,B));
	}
	 public static int solve(ArrayList<Integer> A, int B) {
	        int n=A.size(),sum;
	        for(int i=0;i<(1<<n);i++){
	            sum=0;
	            for(int j=0;j<20;j++){
	                if((i&(1<<j))>0){
	                    sum=sum+A.get(j);
	                }
	            }
	            if(sum==B)return 1;
	        }
	        return 0;
	    }
}
