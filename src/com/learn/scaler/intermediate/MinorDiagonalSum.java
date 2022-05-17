package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinorDiagonalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		List<Integer> row1 = Arrays.asList(1, -2, -3);
		List<Integer> row2 = Arrays.asList(-4, 5, -6);
		List<Integer> row3 = Arrays.asList(-7, -8, 9);
		ArrayList<Integer> listRow1 = new ArrayList<Integer>();
		ArrayList<Integer> listRow2 = new ArrayList<Integer>();
		ArrayList<Integer> listRow3 = new ArrayList<Integer>();
		listRow1.addAll(row1);
		listRow2.addAll(row2);
		listRow3.addAll(row3);
		A.add(listRow1);
		A.add(listRow2);
		A.add(listRow3);
		System.out.println(A);
		System.out.println("Answer: "+solve(A));


	}
	public static int solve(final List<ArrayList<Integer>> A) {
        int rowIndex = 0;
        int colIndex = A.get(0).size()-1;
        int sum = 0;
        while(rowIndex<=A.get(0).size()-1){
        	System.out.println(A.get(rowIndex).get(colIndex));
            sum+=A.get(rowIndex).get(colIndex);
            rowIndex++;
            colIndex--;
        }
        return sum;
    }
}
