/*
 * Problem Description
	You are given a 2D integer matrix A, make all the elements in a row or column zero if
 	the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
 	
 	Input:
	[1,2,3,4]
	[5,6,7,0]
	[9,2,0,4]
	
	Output:
	[1,2,0,0]
	[0,0,0,0]
	[0,0,0,0]
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowToColumnZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		List<Integer> row1 = Arrays.asList(1,2,3,4);
		List<Integer> row2 = Arrays.asList(5,6,7,0);
		List<Integer> row3 = Arrays.asList(9,2,0,4);
		ArrayList<Integer> listRow1 = new ArrayList<Integer>();
		ArrayList<Integer> listRow2 = new ArrayList<Integer>();
		ArrayList<Integer> listRow3 = new ArrayList<Integer>();
		listRow1.addAll(row1);
		listRow2.addAll(row2);
		listRow3.addAll(row3);
		A.add(listRow1);
		A.add(listRow2);
		A.add(listRow3);
		//System.out.println(A);
		System.out.println(betterSolution(A));

	}

	//Brute force approach
	public static ArrayList<ArrayList<Integer>> bruteForceSolution(ArrayList<ArrayList<Integer>> A) {
		
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<A.get(0).size();j++) {
				if(A.get(i).get(j)==0) {
					makeChangeInColumn(A,j);
					makeChangeInRow(A, i);
				}
			}
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				if (A.get(i).get(j) == -1) {
					A.get(i).set(j, 0);
				}
			}
		}
		return A;
	}
	
	//put -1 in complete column 
	public static void makeChangeInColumn(ArrayList<ArrayList<Integer>> A, int col) {
		for(int i=0;i<A.size();i++) {
			A.get(i).set(col, -1);
		}
	}
	//put -1 in complete row 
	public static void makeChangeInRow(ArrayList<ArrayList<Integer>> A, int row) {
		for(int i=0;i<A.get(0).size();i++) {
			A.get(row).set(i, -1);
		}
		
	}
	
	
	//Another approach
	public static ArrayList<ArrayList<Integer>> betterSolution(ArrayList<ArrayList<Integer>> A) {
	
		ArrayList<Integer> rowZero = new ArrayList<Integer>();
		ArrayList<Integer> colZero = new ArrayList<Integer>();
		
		for(int i=0;i<A.size();i++) {
			rowZero.add(-1);
		}
		for(int i=0;i<A.get(0).size();i++) {
			colZero.add(-1);
		}		
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<A.get(0).size();j++) {
				if(A.get(i).get(j)==0) {
					rowZero.set(i,0);
					colZero.set(j,0);
				}
			}
		}
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<A.get(0).size();j++) {
				if(rowZero.get(i)==0 || colZero.get(j)==0) {
					A.get(i).set(j, 0);
				}
			}
		}
		
		return A;
	}	

	//Optimized Approach
	public static ArrayList<ArrayList<Integer>> optimizedSolution(ArrayList<ArrayList<Integer>> A) {
		boolean col = true;
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<A.get(0).size();j++) {
				if(A.get(i).get(j)==0) {
					A.get(0).set(j,0);
					A.get(i).set(0,0);
				}
				if(A.get(i).get(0)==0)
					col=false;
			}
		}
		for(int i=0;i<A.size();i++) {
			for(int j=0;j<A.get(0).size();j++) {
				if(A.get(0).get(j)==0 || A.get(i).get(0)==0) {
					A.get(i).set(j, 0);
				}
				if(!col)
					A.get(i).set(0,0);
			}
		}
		
		return A;
	}	

}
