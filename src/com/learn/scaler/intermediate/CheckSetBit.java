package com.learn.scaler.intermediate;

public class CheckSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(4));
	}
	public static int solve(int A) {
        int ans = 0;
        while(A>0){
            if((A&1)==1)
                ans++;
            A=A>>1;
        }
        return ans;
    }

}
