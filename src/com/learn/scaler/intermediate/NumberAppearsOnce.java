/*
 * Problem Description
	Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
	Find the two integers that appear only once.
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberAppearsOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(1, 2, 3, 1, 2, 4);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		System.out.println(solve(list));

	}
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(A);
        int count =1;
        int prev = A.get(0);
        for(int i=1;i<A.size();i++) {
        	if(prev!=A.get(i)) {
        		if(count==1)
        			result.add(prev);
        		if(i==A.size()-1)
        			result.add(A.get(i));
        		count=1;
        		prev = A.get(i);
        	}else
        		count++;
        }
        return result;
    }

}
