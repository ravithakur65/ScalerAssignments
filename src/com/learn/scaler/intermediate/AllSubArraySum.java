package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(anotherList);
		System.out.println(subarraySum(list));

	}
	
	/*Optimized solution:
	 * public Long subarraySum(ArrayList<Integer> A) {
        Long sum=0L;
        for(int i=0;i<A.size();i++){
           int start = i+1;
           int end = A.size()-i;
           int freq = start*end;
           sum=sum+freq*A.get(i);
        }
        return sum;
    } 
	 * 
	 */
	
	 public static Long subarraySum(ArrayList<Integer> A) {
	        Long sum=0L;
	        for(int i=0;i<A.size();i++){
	            for(int j=i;j<A.size();j++){
	                sum=sum+sumOfSubArray(A,i,j);
	            }
	        }
	        return sum;
	    }

	    public static Long sumOfSubArray(ArrayList<Integer> arr, int start, int end){
	        Long sum = 0L;
	        for(;start<=end;start++){
	            sum+=Long.valueOf(arr.get(start));
	        }
	        return sum;
	    }
}
