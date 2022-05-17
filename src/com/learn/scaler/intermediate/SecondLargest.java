package com.learn.scaler.intermediate;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,1,2};
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= first) {
				second = first;
				first = A[i];
			} else if (A[i] > second) {
				second = A[i];
			}
		}
		System.out.println(second);
	}

}
