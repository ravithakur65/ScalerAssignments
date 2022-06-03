package com.learn.scaler.intermediate.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.List;

public class DivisiblePairs {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("12","15","16","1");
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.addAll(list);
		System.out.println(solve(arrList, 2));
	}
	 public static int solve(ArrayList<String> A, int B){
	        int count = 0;
	        for(int i=0;i<A.size();i++){
	            for(int j=i+1;j<A.size();j++){
	                long temp = Long.parseLong(""+A.get(i)+A.get(j));
	                if(temp%B==0)
	                    count++;
	                 long tempReverse = Long.parseLong(""+A.get(j)+A.get(i));
	                if(tempReverse%B==0)
	                    count++;
	            }
	        }
	        return count;
	    }
}
