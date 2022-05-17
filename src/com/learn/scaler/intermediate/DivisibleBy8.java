package com.learn.scaler.intermediate;

public class DivisibleBy8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(solve("9216"));
	}
	 public static int solve(String A) {
	        int num= 0;
	        if(A.length()>3)
	            num = Integer.parseInt(A.substring(A.length()-3, A.length()));
	        else
	            num=Integer.parseInt(A);
	        if(num%8==0)
	            return 1;
	        return 0;        
	    }

}
