package com.learn.scaler.advance;

import java.util.Arrays;

/*
 * Problem Description
	Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
	
	His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
	
	Problem Constraints
	2 <= N <= 100000
	0 <= A[i] <= 109
	2 <= B <= N
	
	Example Input
	Input 1:
	A = [1, 2, 3, 4, 5]
	B = 3

	Input 2:
	A = [1, 2]
	B = 2
	
	Example Output
	Output 1:
	 2

	Output 2:
	 1
	
	Example Explanation
	Explanation 1:
	
	 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
	Explanation 2:
	
	 The minimum distance will be 1.
 */
public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		int cows = 3;
		System.out.println(solve(arr,cows));
	}

	public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int left=1;
        int right=A[A.length-1]-A[0];
        int ans=0;
        while(left <= right){
            int mid=((left+right)>>1);
            if(checkCowsPlacedAtMidAPart(A,mid,B)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }


	
	 public static boolean checkCowsPlacedAtMidAPart(int[] A,int mid,int B){
	        int cowsplaced=A[0];
	        int cowsCount=1;
	        for(int i=1;i<A.length;i++){
	            if(A[i] - cowsplaced >= mid){
	                cowsCount++;
	                cowsplaced=A[i];
	                if(cowsCount == B){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
}
