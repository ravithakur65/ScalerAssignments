package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterestingArrayBitManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(9, 17);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		System.out.println(solve(list));

	}
	
	public static String solve(ArrayList<Integer> A) {
		int merge =A.get(0);
        for(int i=1;i<A.size();i++){
            merge = merge^A.get(i); 
        }
        if(merge%2==0)
            return "Yes";
        else
            return "No";
    }
}
