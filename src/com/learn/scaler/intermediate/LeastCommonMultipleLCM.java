/*
 * Problem Description
	You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.
	LCM of two integers is the smallest positive integer divisible by both.
 */
package com.learn.scaler.intermediate;

public class LeastCommonMultipleLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCM(350,136));
	}

	public static int LCM(int A, int B) {
		if (A == B)
			return A;
		int max = Math.max(A, B);
		int min = max == A ? B : A;
		for (int i = 2; i < max; i++) {
			int mul = min * i;
			if (mul % max == 0)
				return mul;
		}
		return A * B;
	}
}
