package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithGivenXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(5, 4, 10, 15, 7, 6);
		int B= 5;
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(optimizedApproach(arrList, B));
	}

	//Brute force approach
	 public static int solve(ArrayList<Integer> A, int B) {
	        int count= 0;
	        for(int i=0;i<A.size();i++){
	            for(int j=i+1;j<A.size();j++){
	                if((A.get(i)^A.get(j))==B)
	                    count++;
	            }
	        }
	        return count;
	    }
	 //Optimized Approach
	 public static int optimizedApproach(ArrayList<Integer> A, int B) {
		 int count = 0;
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 for(int i=0;i<A.size();i++) {
			 int curr_Xor = B^A.get(i);
			 if(map.containsKey(curr_Xor))
				 count++;
			 else
				 map.put(A.get(i), i);
		 }
		 return count;
	 }
}
