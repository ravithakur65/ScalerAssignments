/*
 * Problem Description
	Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral
	order.
	Input : 2
	Output:
	1 --> 2
	      |
	      |
	4<--- 3
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;

public class SpiralOrderMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateMatrix(21));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		ArrayList<ArrayList<Integer>> filledArray = new ArrayList<ArrayList<Integer>>();
		
		int rowMin =0;
		int colMin = 0;
		int rowMax = A-1;
		int colMax = A-1;
		int count =0;
		for(int i=1;i<=A;i++) {
			ArrayList<Integer> tempArray = new ArrayList<>();
			for(int j=1;j<=A;j++) {
				tempArray.add(-1);
			}
			filledArray.add(tempArray);
		}
		while(rowMin<=rowMax && colMin<=colMax) {
			//Left-->right
				for(int j=colMin;j<=colMax;j++) {
					filledArray.get(rowMin).set(j, ++count);
				}
				rowMin++;
			//Top-->Down
				for(int i=rowMin;i<=rowMax;i++) {
					filledArray.get(i).set(colMax, ++count);
				}
				colMax--;
			
			//Right-->Left
				for(int j=colMax;j>=colMin;j--) {
					filledArray.get(rowMax).set(j, ++count);
				}
				rowMax--;
			//Down-->Top
				for(int i=rowMax;i>=rowMin;i--) {
					filledArray.get(i).set(colMin, ++count);
				}
				colMin++;
		}
		return filledArray;
	}
}
