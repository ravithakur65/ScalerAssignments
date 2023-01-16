package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Problem Description

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

Problem Constraints
0 <= N <= 7000
-108 <= A[i] <= 108

Input Format
Single argument representing a 1-D array A.

Output Format
Output a 2-D vector where each row represent a unique triplet.

Example Input
A = [-1,0,1,2,-1,4]

Example Output
[ [-1,0,1],
  [-1,-1,2] ]

Example Explanation
Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
public class ThreeSumZero {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(-1);
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(-1);
        A.add(4);
        System.out.println(new ThreeSumZero().threeSum(A));

    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        Collections.sort(A);
        int count = 0;
        for (int c = 0;c<A.size()-2 ; c++) {
            int j = c+1;
            int k = A.size()-1;
            int i = (-1*(A.get(c)));
            while(j<k){
                if ((A.get(j)+A.get(k))==i){
                        result.add(new ArrayList<Integer>());
                        result.get(count).add(A.get(c));
                        result.get(count).add(A.get(j));
                        result.get(count).add(A.get(k));
                        count++;
                    j++;
                    k--;
                }else if ((A.get(j)+A.get(k))>i){
                    k--;
                }else{
                    j++;
                }
            }
        }
        Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
        set.addAll(result);
        result.clear();
        result.addAll(set);
        return result;    
    }
}
