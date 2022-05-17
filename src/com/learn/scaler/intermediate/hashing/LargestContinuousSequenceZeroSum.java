/*
 * Problem Description
	Given an array A of N integers.
	Find the largest continuous sequence in a array which sums to zero.
	Return an array denoting the longest continuous sequence with total sum of zero.
	NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

	Problem Constraints
	1 <= N <= 106
	-107 <= A[i] <= 107
	
	Example Input
	A = [1,2,-2,4,-4]
	
	Example Output
	[2,-2,4,-4]
	
	Example Explanation
	[2,-2,4,-4] is the longest sequence with total sum of zero.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(-1, 1, 1, -1, -1, 1, 1, -1);
		//List<Integer> list = Arrays.asList(1, 2, -3, 3 );
		//List<Integer> list = Arrays.asList(-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25 );
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(lszero(arrList));
	}
	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> prefixArr = new ArrayList<Integer>();
        //Prepare prefix array from the input arrayList
        prefixArr.add(A.get(0));
         for(int i=1;i<A.size();i++){
            prefixArr.add(prefixArr.get(i-1)+A.get(i));
        }
        
        int maxSize = Integer.MIN_VALUE;
        int start=0, end=-1;
        int diff = 0;
        //Iterate through the prefix array to find the largest sub-array which sum is 0
        for(int i=0;i<prefixArr.size();i++){
        	//If prefix array contains 0 then largest size would be i+1;
            if(prefixArr.get(i)==0){
                start = 0;
                end = i;
                maxSize = i+1;
            }
            //If Map contains duplicate value then check the max size and update start and end indexes
            if(map.containsKey(prefixArr.get(i))){
                int temp = map.get(prefixArr.get(i));
                diff = i-(temp);
                if(maxSize<diff){
                    maxSize = diff;
                    start=temp+1;
                    end=i;
                }
                
            }else
                map.put(prefixArr.get(i),i);// add new element to the map
           
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        //once start and end index finalized, iterate through the array and get the sub-array
        for(;start<=end;start++){
            result.add(A.get(start));
        }
        return result;
    }
}
