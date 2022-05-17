package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(927, 707, 374, 394, 279, 799, 878, 937, 431, 112);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(solve(arrList));
		
	}
	public static int solve(ArrayList<Integer> A) {
        int maxMod = 0;
        int rem = 0;
        Collections.sort(A);
        int maxVal = A.get(A.size()-1);
        for(int i=0;i<A.size();i++){
            rem = A.get(i)%maxVal;
            maxMod = Math.max(maxMod,rem);
        }
        return maxMod;
    }
}
