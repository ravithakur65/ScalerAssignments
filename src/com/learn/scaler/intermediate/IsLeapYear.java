/*
 * Problem Description
	Given an integer A representing a year, Return 1 if it is a leap year else, return 0.
	A year is a leap year if the following conditions are satisfied:
	1. The year is multiple of 400.
	2. Else the year is multiple of 4 and not multiple of 100.
 */
package com.learn.scaler.intermediate;

public class IsLeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(2200)==1?"Leap Year":"Not a Leap Year");
	}

	 public static int solve(int A) {
	        if(A%400==0 || A%4==0 && A%100!=0)
	            return 1;
	        return 0;
	    }
}
