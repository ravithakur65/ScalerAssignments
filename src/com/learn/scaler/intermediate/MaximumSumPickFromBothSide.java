package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumPickFromBothSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35);
		int B =48;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		System.out.println(solve(list,B));
	}

	public static int solve(ArrayList<Integer> A, int B) {
		int low = 0;
		int high = A.size() - 1;
		int count = 0;
		int sum = 0;
		while (low < high) {
			if (A.get(low) > A.get(high)) {
				sum += A.get(low);
				low++;
			} else {
				sum += A.get(high);
				high--;
			}
			count++;
			if (count == B)
				break;
		}
		return sum;
	}
}
