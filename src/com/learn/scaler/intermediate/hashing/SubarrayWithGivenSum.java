/*
 * Problem Description
	Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
	If the answer does not exist return an array with a single element "-1".
	First sub-array means the sub-array for which starting index in minimum.

	Problem Constraints
	1 <= length of the array <= 100000
	1 <= A[i] <= 109
	1 <= B <= 109
	
	Input Format
		The first argument given is the integer array A.
		The second argument given is integer B.
	Output Format
		Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
	Input 1:
	 A = [1, 2, 3, 4, 5]
	 B = 5
	Input 2:
	 A = [5, 10, 20, 100, 105]
	 B = 110

	Output 1:
	 [2, 3]
	Output 2:
	 -1

	Explanation 1:
	 [2, 3] sums up to 5.
	Explanation 2:
	 No sub-array sums up to required number.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13,
		 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37,
		 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5,
		 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1,
		 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37);
		//List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		int B = 100;
		System.out.println(subArraySum(arrList, B));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int start = 0;
		int end = -1;
		boolean isFound = false;
		for (int i = 0; i < A.size() - 1; i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (isSumEqual(A, i, j, B)) {
					start = i;
					end = j;
					isFound = true;
				}
				if (isFound)
					break;
			}
		}
		for (; start <= end; start++) {
			result.add(A.get(start));
		}
		if (result.isEmpty())
			result.add(-1);
		return result;
	}

	public static boolean isSumEqual(ArrayList<Integer> A, int start, int end, int B) {
		int sum = 0;
		for (; start <= end; start++) {
			sum += A.get(start);
		}
		if (sum == B)
			return true;
		return false;
	}

	// Optimized solution
	public static ArrayList<Integer> subArraySum(ArrayList<Integer> A, int B) {
		 long sum = 0 ;
         int start = -1,end = -1,j=0,flag = 0;
         for(int i=0;i<A.size();i++){

             if(sum > B){        
                 while(sum > B)
                    sum -= A.get(j++);
             }
             if(sum  == B){
                     start = j;
                     end = i-1;
                     flag =1; break;
                 }
             sum += A.get(i);
         }
         
         if(flag == 0){
            while(sum > B)
                sum -= A.get(j++);
            if(sum == B){
                start = j; end = A.size()-1;
            }
         }
         ArrayList<Integer> res = new ArrayList<>();
         if(start != -1 && end != -1){
             int k=0;
             for(int i=start;i<=end;i++)
                res.add(A.get(i));
         }
         else
            res.add(-1);
         return res;
	}

}
