package com.learn.scaler.intermediate;

import java.util.ArrayList;

public class LeftRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		listB.add(88);
		listB.add(76);
		System.out.println("Reverse ArrayList");
		printList(solve(list,listB));

	}
	 public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 for(int i=0;i<B.size();i++){
	            ArrayList<Integer> tempList = new ArrayList<Integer>(A);
	            int last = tempList.size()-1;
	            int temp =tempList.size()-B.get(i);
	            reverse(tempList,0,last);
	            reverse(tempList,0,temp-1);
	            reverse(tempList,temp,last);
	            result.add(tempList);
	        }
	        return result;
	    }
	public static void printList(ArrayList<ArrayList<Integer>> aarList) {
		for(int i=0;i<aarList.size();i++)
			System.out.print(aarList.get(i)+" ");
	}

	public static void reverse(ArrayList<Integer> list, int low, int high) {
		while (low < high) {
			int temp = list.get(low);
			list.set(low, list.get(high));
			list.set(high, temp);
			low++;
			high--;
		}
	}
}
