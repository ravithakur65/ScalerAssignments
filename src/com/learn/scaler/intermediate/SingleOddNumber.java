/*
 * Problem Description
 *	Given an array of integers A, every element appears twice except for one. 
 *	Find that integer that occurs once.

	NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without
 	using extra memory?
 */
package com.learn.scaler.intermediate;

import java.util.Arrays;
import java.util.List;

public class SingleOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrA = Arrays.asList(1, 2, 2, 3, 1);
		System.out.println(singleNumber(arrA));
	}
	
	 public static int singleNumber(final List<Integer> A) {
	        int result = 0;
	        for(int i=0;i<A.size();i++){
	            result = result^A.get(i);
	        }
	        return result;
	    }

}
