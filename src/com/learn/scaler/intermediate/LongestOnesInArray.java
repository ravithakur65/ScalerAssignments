/*
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. 
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 * Input 1:
 *  A = "111000"
 *	
 *	Output 1:
 *  3
 */

package com.learn.scaler.intermediate;

public class LongestOnesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve("11110"));

	}
	public static int solve(String A) {
		int lenOfOnes = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='1')
                lenOfOnes++;
        }
        if(lenOfOnes==A.length())
            return lenOfOnes;

        int sum =0;
        int ans = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='0'){
                //count 1's in left
                int leftCount = 0;
                for(int j=i-1;j>=0;j--){
                    if(A.charAt(j)=='1'){
                        leftCount++;
                    }else
                        break;
                }

                //count 1's in right
                int rightCount = 0;
                for(int j=i+1;j<A.length();j++){
                    if(A.charAt(j)=='1'){
                        rightCount++;
                    }else
                        break;
                }
                if(lenOfOnes>(leftCount+rightCount)){
                    sum = leftCount+rightCount+1;
                }else
                    sum = leftCount+rightCount;
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

}
