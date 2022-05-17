package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(9, 12, 17, 9, 17, 16, 6, 4, 3, 8, 5, 13, 2, 9, 3, 13, 11);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		int B = 302;
		System.out.println(solve(list,B));
	}
	 public static int solve(ArrayList<Integer> A, int B) {
	       int ans=0;
		        for(int i=0;i<A.size();i++){
	                int sum = 0;
		            for(int j=i;j<A.size();j++){
		                sum =sum+((A.size()-j)*(A.get(j)));
	                    if(sum<B)
	                       ans++;
		            }
		        }
		        return ans;
	    }
	     public static int sumOfSubArray(ArrayList<Integer> arr, int start, int end){
		        int sum = 0;
		        for(;start<=end;start++){
		            sum+=arr.get(start);
		        }
		        return sum;
		    }
}
