package com.learn.scaler.advance.TwoPointers;

import java.util.Arrays;

/*
 * Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 2, 1, -4 };
        int sum = 1;
        System.out.println(threeSumClosest(arr, sum));
    }
    public static int threeSumClosest(int[] A, int B) {
        int n = A.length;
        //base case
        if(n <= 3){
            int sum = 0;
            for(int a : A)
                sum += a;
            return sum;
        }

        long closestSum = Integer.MAX_VALUE;
        Arrays.sort(A); // as input array is not sorted
        int i = 0; // first pointer

        for(i = 0; i < n-2; i++){
            int j = i+1;
            int k = n-1;
            if (i > 0 && A[i] == A[i-1]) //escaping repeated values of i
                continue;
            while(j<k){
                int sum = A[i] + A[j] + A[k];
               
                if(Math.abs(B-sum)<Math.abs(B-closestSum))
                   closestSum=sum;

                if(sum < B)
                    j++;
                else
                    k--;
            }
        }
        return (int)closestSum;
    }
}
