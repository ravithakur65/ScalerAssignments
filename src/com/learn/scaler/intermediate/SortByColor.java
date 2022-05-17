package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0,
				1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0,
				2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0,
				0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1,
				1, 0, 2, 1, 2);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(sortColors(arrList));
	}

	public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
		
		//By using library function
		Collections.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2);
			}
		});

		//By Not using library function
		Collections.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return (num1 < num2) ? -1 : ((num1 == num2) ? 0 : 1);
			}
		});

		return A;
	}

}
