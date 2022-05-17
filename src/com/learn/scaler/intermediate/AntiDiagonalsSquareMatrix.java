package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonalsSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		List<Integer> listA = Arrays.asList(1,2,3);
		List<Integer> anotherListA = Arrays.asList(4,5,6);
		List<Integer> another = Arrays.asList(7,8,9);
		ArrayList<Integer> listArrA = new ArrayList<Integer>();
		ArrayList<Integer> listArrAnotherA = new ArrayList<Integer>();
		ArrayList<Integer> listArrrA = new ArrayList<Integer>();
		listArrA.addAll(listA);
		listArrAnotherA.addAll(anotherListA);
		listArrrA.addAll(another);
		A.add(listArrA);
		A.add(listArrAnotherA);
		A.add(listArrrA);
		System.out.println(diagonal(A));

	}
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int colSize = A.get(0).size();
        int rowSize = A.size();
        //Find the diagonals from 0th index to cols
        for(int col=0;col<colSize;col++){
            int i=0;
            int j=col;
            ArrayList<Integer> diagonals = new ArrayList<Integer>();
            while(i<colSize && j>=0){
                diagonals.add(A.get(i).get(j));
                i++;
                j--;
            }
            int addedElement = diagonals.size();
            for(int k=0;k<colSize-addedElement;k++)
                diagonals.add(0);
            result.add(diagonals);
        }

        //Find the diagonals from N-1 index to rows
        for(int row=1;row<rowSize;row++){
            int i=row;
            int j=colSize-1;
            ArrayList<Integer> diagonals = new ArrayList<Integer>();
            while(i<rowSize && j>=0){
                diagonals.add(A.get(i).get(j));
                i++;
                j--;
            }
            int addedElement = diagonals.size();
            for(int k=0;k<colSize-addedElement;k++)
                diagonals.add(0);
            result.add(diagonals);
        }
        return result;
    }
}
