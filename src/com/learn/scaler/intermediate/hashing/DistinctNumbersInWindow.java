/*
 * Problem Description

	You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return the of count of distinct numbers in all windows of size B.
	Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
	NOTE: if B > N, return an empty array.
	
	Input 1:
	 A = [1, 2, 1, 3, 4, 3]
	 B = 3
	 
	 Output 1:
 	[2, 3, 3, 2]
 	
 	Explanation 1:
	 A=[1, 2, 1, 3, 4, 3] and B = 3
	 All windows of size B are
	 [1, 2, 1]
	 [2, 1, 3]
	 [1, 3, 4]
	 [3, 4, 3]
	 So, we return an array [2, 3, 3, 2].
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,0,0,0,0,0,0);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		int B = 3;
		System.out.println(dNums(arrList, B));
	}
	 public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for(int i=0;i<A.size();i++){
	        	
	            if(i>B-1){
	                if(map.containsKey(A.get(i))){
	                        int temp = map.get(A.get(i));
	                        map.put(A.get(i),++temp);
	                }else 
	                	map.put(A.get(i),1);
	                if(map.containsKey(A.get(i-B)) && (map.get(A.get(i-B))>0)){
	                    int temp = map.get(A.get(i-B));
	                    map.put(A.get(i-B),--temp);
	                }
	                if(map.get(A.get(i-B))==0){
	                    map.remove(A.get(i-B));
	                }
	                result.add(map.size());
	            }else{
	                if(map.containsKey(A.get(i))){
	                    int temp = map.get(A.get(i));
	                    map.put(A.get(i),++temp);
	                }else
	                    map.put(A.get(i),1);
	            }
	            if(i==B-1)
	        		result.add(map.size());
	        }
	        return result;
	    }
}
