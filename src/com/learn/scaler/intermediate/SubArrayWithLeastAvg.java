package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithLeastAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> anotherList = Arrays.asList(20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int B= 9;
		list.addAll(anotherList);
		System.out.println(solutionWithPrefixArray(list,B));

	}

	public static int solve(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<=A.size()-B;i++){
            int sum =0;
            for(int j=i;j<i+B;j++){
                sum+=A.get(j);                    
            }
            
            if(min>sum){
                min=sum;
                ans = i;
            }
        }
        return ans;
    }
	//Optimized solution
	public static int solutionWithPrefixArray(ArrayList<Integer> A,int B) {
		ArrayList<Integer> preArray = new ArrayList<Integer>();
		preArray.add(A.get(0));
		for(int i=1;i<A.size();i++) {
			preArray.add(preArray.get(i-1)+A.get(i));
		}
		int sum =0;
		int min = Integer.MAX_VALUE;
		int ans =0;
		for(int i=0;i<=A.size()-B;i++) {
			if(i==0)
				sum=preArray.get(B-1);
			else
				sum = preArray.get(B+i-1)-preArray.get(i-1);
			if(min>sum) {
				min=sum;
				ans=i;
			}
		}
		return ans;
	}
}
