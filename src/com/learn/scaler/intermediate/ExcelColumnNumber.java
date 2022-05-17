package com.learn.scaler.intermediate;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ZZZZZ"));
	}
	public static int titleToNumber(String A) {
        A=A.toUpperCase();
        int ans = 0;
        int pow = 0;
        for(int i=A.length()-1;i>=0;i--){
            int num = A.charAt(i)-'@';
            ans = ans+num*(power(26,pow));
            pow++;
        }
        return ans;
    }

    public static int power(int base, int pow){
        int result = 1;
        for(int i=0;i<=pow;i++) {
        	if(i==0)
        		result = 1;
        	else
        		result*=(26);
        }
        
        return result;
    }

}
