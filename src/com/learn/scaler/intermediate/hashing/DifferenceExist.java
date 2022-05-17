/*
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * Input :
	A : [1 5 3]
	k : 2
	Output :
	
	1
	as 3 - 1 = 2
	
	Return 0 / 1 for this problem.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//O/P: 0
		List<Integer> list = Arrays.asList(77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 );
		int B= 53;
		//O/P: 0
		//List<Integer> list = Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29);
		//int B= 97;
		//O/P: 1
		//List<Integer> list = Arrays.asList(95, 97, 52, 51, 98, 41, 88, 12, 61, 32, 78, 9, 51, 39, 28, 28);
		//int B= 43;
		System.out.println(diffPossible(list, B));
	}
	 public static int diffPossible(final List<Integer> A, int B) {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i=0;i<A.size();i++){
	        	if(A.get(i)>B && set.contains(A.get(i)-B)){
	            	System.out.println(A.get(i)+": "+(A.get(i)-B));
	                return 1;
	        	}else if(set.contains(A.get(i)+B)) {
	            	System.out.println(A.get(i)+": "+(A.get(i)-B));
	                return 1;
	            }
	            else
	                set.add(A.get(i));
	        }
	        return 0;
	    }
}
