/*
 * You are given a read only array of n integers from 1 to n.

	Each integer appears exactly once except A which appears twice and B which is missing.
	Return A and B.
	Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	Note that in your output A should precede B.
	Input:[3 1 2 5 3] 
	Output:[3, 4] 
	A = 3, B = 4
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatAndMissingNumberArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {4,1,4,5,2};
		System.out.println(Arrays.toString(repeatedNumber(list)));
	}
	
	public static int[] repeatedNumber(final int[] A) {
        int val1 = 0;
        int val2 = 0;
        int xor = 0;
        for(int i=0;i<A.length;i++){
            xor ^= A[i];
        }
        for(int j=1;j<=A.length;j++){
            xor ^= j;
        }
        int temp = xor;
        int set_index = 0;

        while(temp>0){
            if((temp & 1) == 1){
                break;
            }
            else{
                temp = temp>>1;
                set_index += 1;
            }
        }

        for(int k=0;k<A.length;k++){
            if((A[k]>>set_index)%2 == 1){
                val1 ^= A[k];
            }
            
        }
        for(int l=1;l<=A.length;l++){
            if((l>>set_index)%2 == 1){
                val1 ^= l;
            }
        }

        val2 = val1 ^ xor;
        for(int i=0;i<A.length;i++){
            if(val1 == A[i]){
                return new int[] {val1, val2};
            }
        }

        return new int[] {val2, val1};
    }
	 
}
