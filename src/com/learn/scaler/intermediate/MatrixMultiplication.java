package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		List<Integer> listA = Arrays.asList(1,2);
		List<Integer> anotherListA = Arrays.asList(3,4);
		ArrayList<Integer> listArrA = new ArrayList<Integer>();
		ArrayList<Integer> listArrAnotherA = new ArrayList<Integer>();
		listArrA.addAll(listA);
		listArrAnotherA.addAll(anotherListA);
		A.add(listArrA);
		A.add(listArrAnotherA);
		List<Integer> listB = Arrays.asList(5,6,9);
		List<Integer> anotherListB = Arrays.asList(7,8,2);
		ArrayList<Integer> listArrB = new ArrayList<Integer>();
		ArrayList<Integer> listArrAnotherB = new ArrayList<Integer>();
		listArrB.addAll(listB);
		listArrAnotherB.addAll(anotherListB);
		B.add(listArrB);
		B.add(listArrAnotherB);
		System.out.println(solve(A,B));
	}
	public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int rowA = A.size();
        int colA = A.get(0).size();
        int colB = B.get(0).size();
        for(int rowIndexA = 0;rowIndexA<rowA;rowIndexA++) {
        	ArrayList<Integer> prod = new ArrayList<Integer>();
	        for(int colIndexB = 0;colIndexB<colB;colIndexB++) {
	        	int sum = 0;
	        	for(int colIndexA = 0;colIndexA<colA;colIndexA++) {
	        		sum+=A.get(rowIndexA).get(colIndexA)*B.get(colIndexA).get(colIndexB);
	        	}
	        	prod.add(sum);
	        }
	        result.add(prod);
        }
        return result;
    }
}
