/*
 * Problem Description

	You are given an integer array A of size N.
	You can pick B elements from either left or right end of array A to get the maximum sum.
	Find and return this maximum possible sum.
	NOTE: Suppose B = 4, and array A contains 10 elements, then
	You can pick the first four elements or can pick the last four elements, or can pick 1 from 
	front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.
	
	Problem Constraints
	1 <= N <= 105
	1 <= B <= N
	-103 <= A[i] <= 103
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickFromBothSides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(5, -2, 3 , 1, 2);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int B= 3;
		list.addAll(anotherList);
		System.out.println(solve(list,B));

	}
	public static int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefixArr = new ArrayList<Integer>();
        prefixArr.add(A.get(0));
        for(int i=1;i<A.size();i++){
            prefixArr.add(prefixArr.get(i-1)+A.get(i));
        }
        int rightHigh = A.size();
        int maxSum= Integer.MIN_VALUE;
        int sum = 0;
        int elements = 0;
        // if B==size of the array
        if(rightHigh==B)
            maxSum=prefixArr.get(rightHigh-1);
        else{
            for(int i=0;i<=B;i++){
                elements = B-i;
                if(i==0)
                    sum =prefixArr.get(rightHigh-1)-prefixArr.get(rightHigh-elements-1);
                else
                    sum =prefixArr.get(i-1)+(prefixArr.get(rightHigh-1)-prefixArr.get(rightHigh-elements-1));
                if(maxSum<sum)
                    maxSum=sum;
            }
        }
        return maxSum;
    }

}
