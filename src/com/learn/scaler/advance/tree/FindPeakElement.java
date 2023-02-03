package com.learn.scaler.advance.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Description
    Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
    For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
    NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 109

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the peak element.

    Example Input
    Input 1:
    A = [1, 2, 3, 4, 5]

    Input 2:
    A = [5, 17, 100, 11]

    Example Output
    Output 1:
    5

    Output 2:
    100

    Example Explanation
    Explanation 1:
    5 is the peak.

    Explanation 2:
    100 is the peak.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(A));

    }
    public static int solve(ArrayList<Integer> A) {
        int low = 0, high = A.size()-1;

        //Complete all edge cases before
        if (A.size() == 1){
            return A.get(0);
        }
        if (A.get(0) >= A.get(1)) {
            return A.get(0);
        } else if(A.get(high) >= A.get(high-1)){
            return A.get(high);
        }

        low=1;
        high=high-1;
        //Start binary search
        while(low<=high){
            int mid = low + (high-low)/2;

            if ((A.get(mid) >= A.get(mid-1) && A.get(mid) >= A.get(mid+1)) ){
                return A.get(mid);
            } else if(A.get(mid) < A.get(mid-1)){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }
}
