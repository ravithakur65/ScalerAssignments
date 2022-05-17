/*
 * Problem Description
	You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
	You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 
	alternating subarray.
	A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 
	1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and 
	[0, 1, 0, 0, 1] are not.

	Input 1:
	 A = [1, 0, 1, 0, 1]
	 B = 1 

	 Output 1:
 	[1, 2, 3]
	 
	 Explanation 1:
	 Index 1 acts as a center of alternating sequence: [A0, A1, A2]
	 Index 2 acts as a center of alternating sequence: [A1, A2, A3]
	 Index 3 acts as a center of alternating sequence: [A2, A3, A4]
*/
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternatingSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(1, 0, 1, 0, 1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		int B = 1;
		System.out.println(solve(list,B));

	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = 2*B+1;
        int center = len/2;
        int state =  A.get(0);
        int count = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

       for(int i=0; i<A.size(); i++){
           int t = A.get(i);
           if(state != t){
               count = 0;
           }
           count++;
           if(count == len){
               res.add(i-center);
               count--;
           }
           state = 1 - t;
       }

       return res;
    }

}
