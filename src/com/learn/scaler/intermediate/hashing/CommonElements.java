/*
 * Problem Description
	Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
	
	NOTE:
	Each element in the result should appear as many times as it appears in both arrays.
	The result can be in any order.
	Problem Constraints
	1 <= N, M <= 105
	1 <= A[i] <= 109
	
	 Input 1:
	 A = [1, 2, 2, 1]
	 B = [2, 3, 1, 2]
	 
	 Output 1:
	 [1, 2, 2]
	 
	 Explanation 1:
	 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonElements {

	public static void main(String[] args) {
		List<Integer> listA = Arrays.asList(1, 2, 2, 1);
		ArrayList<Integer> arrListA = new ArrayList<Integer>();
		arrListA.addAll(listA);
		List<Integer> listB = Arrays.asList(2, 3, 1, 2);
		ArrayList<Integer> arrListB = new ArrayList<Integer>();
		arrListB.addAll(listB);
		System.out.println(solve(arrListA, arrListB));
	}
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))) {
            	int temp = map.get(A.get(i));
               map.put(A.get(i),++temp);
            }
            else
                map.put(A.get(i),1);
        }

        for(int i=0;i<B.size();i++){
            if(map.containsKey(B.get(i)) && map.get(B.get(i))>0){
               result.add(B.get(i));
               int temp = map.get(B.get(i));
               map.put(B.get(i),--temp);
            }
        }
        return result;
    }
}
