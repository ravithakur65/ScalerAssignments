/*
 * Problem Description
 * Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarraysWithBitwiseOR1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(1, 0, 1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		int A = 3;
		System.out.println(solve(A,list));
	}
	 public static Long solve(int A, ArrayList<Integer> B) {
	        long zeroSA=0;
	        long count=0;
	        for(int i=0;i<A;i++){
	            if(B.get(i)==0){
	                count=count+1;
	            }else if(B.get(i)==1){
	                zeroSA = zeroSA + (count*(count+1)/(long)2);
	                count=0;
	            }
	            if(i==A-1 && count>0){
	                zeroSA = zeroSA + (count*(count+1)/(long)2);
	            }
	        }

	        return (((long)A*((long)A+1)/(long)2))-zeroSA;
	    }
	 public Long anotherSolution(int A, ArrayList<Integer> B) {
	        Long result = 0L;
	        int check = 0;
	        boolean allOnes = true;
	        int length = B.size();
	        for(int i=0;i<length;i++){
	            if(B.get(i)==0){
	                allOnes=false;
	                break;
	            }
	        }
	        if(allOnes){
	            result= Long.valueOf(length);
	            return result*(result+1)/2;
	        }else{
	            for(int i=0;i<length;i++){
	                check = 0;
	                for(int j=i;j<length;j++){
	                    check=check|(B.get(j));
	                    if(check==1)
	                        result++;
	                }
	            }
	        }
	        return result;
	    }

}
