package com.learn.scaler.beginner;

public class FindIquilibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 3, 4, 6, 2, 4, 2 };
		System.out.println("Iquilibrium Index is: "+findIquilibrium(arr));
	}

	private static int findIquilibrium(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		int sumL = 0;
		int sumR = 0;
		while (i < j) {
			sumL = sumL + arr[i];
			sumR = sumR + arr[j];
			if (sumL == sumR)
				return i + 1;
			j--;
			i++;
		}
		return -1;
	}

}
