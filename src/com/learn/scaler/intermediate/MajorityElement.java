package com.learn.scaler.intermediate;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 1, 1, 2, 3, 5, 7);
		System.out.println(majorityElement(list));
	}

	public static int findMajority(final List<Integer> A) {
		 int cand=0;
	       int votes=0;
	       for(int i=0;i<A.size();i++){
	           if(votes==0){
	               cand=A.get(i);
	           }
	           if(A.get(i)==cand){
	               votes++;
	           }else{
	               votes--;
	           }
	       }
	       return cand;
	}
	
	
	 public static int majorityElement(final List<Integer> A) {
	        int cand = findMajority(A);
	         if (isMajority(A, A.size(), cand))
	           return cand;
	        return -1;
	    }

	    static int findCandidate(List<Integer> A, int size)
	    {
	        int maj_index = 0, count = 1;
	        for (int i = 1; i < size; i++) {
	        	int temp = A.get(maj_index); 
	            if ( temp== A.get(i))
	                count++;
	            else
	                count--;
	            if (count == 0) {
	                maj_index = i;
	                count = 1;
	            }
	        }
	        return A.get(maj_index);
	    }
	    static boolean isMajority(List<Integer> A, int size, int cand)
	    {
	        int count = 0;
	        for (int i = 0; i < size; i++) {
	            if (A.get(i) == cand)
	                count++;
	        }
	        if (count > size / 3)
	            return true;
	        return false;
	    }
}
