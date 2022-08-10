package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem Description
	Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
	
	Problem Constraints
	-1010 <= A[i], B[i] <= 1010
	Example Input
	Input 1:
	
	A = [4, 7, 9 ]
	B = [2, 11, 19 ]
	Input 2:
	
	A = [1]
	B = [2]
	
	
	Example Output
	Output 1:
	
	[2, 4, 7, 9, 11, 19]
	Output 2:
	
	[1, 2]
	
	
	Example Explanation
	Explanation 1:
	
	Merging A and B produces the output as described above.
	Explanation 2:
	
	 Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(4, 7, 9);
		List<Integer> list2 = Arrays.asList(2, 11, 19);
		System.out.println(solve(list,list2));
	}
	  public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for(Integer num: A){
	            for(Integer num2: B)
	            {
	            	if(num<num2) {
	            		result.add(num);
	            	}else
	            		result.add(num2);
	            }
	        }
	        return result;
	    }

}
