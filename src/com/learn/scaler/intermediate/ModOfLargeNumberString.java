/*
 * Problem Description
	You are given a large number in the form of a string A where each character denotes a digit 
	of the number.
	You are also given a number B. You have to find out the value of A % B and return it.
	
	Problem Constraints
	1 <= A.length() <= 105
	0 <= Ai <= 9
	1 <= B <= 109
	
	Input:
	A = "43535321"
	B = 47
	
	Output:
	20
	
	
	One Line Solution: return Math.abs(A-B);
	If a and b are the numbers, then we consider:
	a = nx + r
	b = ny + r
	Where n is the modulus we want to find, and r is the common remainder. So,
	
	a - b = n(x - y)   
	=> n = (a-b)/(x-y)
	Maximum n is achieved with x - y = 1. So,
	
	n = a - b
 */
package com.learn.scaler.intermediate;

public class ModOfLargeNumberString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(anotherSol("782901299957657657657812083098123719287361293701263961203912397129858761207012698129370123965765558787687676765656654654654547576565656565768282782777272782901299957657657657812083098123719287361293701263961203912397129858761207012698129370123965765558787687676765656654654654547576565656565768282782777272782901299957657657657812083098123719287361293701263961203912397129858761207012698129370123965765558787687676765656654654654547576565656565768282782777272782901299957657657657812083098123719287361293701263961203912397129858761207012698129370123965765558787687676765656654654654547576565656565768282782777272782901299957657657657812083098123719287361293701263961203912397129858761207012698129370123965765558787687676765656654654654547576565656565768282782777272",47));
	}
	 public static int findMod(String A, int B) {
	        int carry = 1;
	        int ans = 0;
	        for(int i=A.length()-1;i>=0;i--){
	            int temp = A.charAt(i)-'0';
	            ans=ans+((temp%B)*carry)%B;
	            carry=(carry*10)%B;
	        }
	        return ans%B;
	    }
	 
	 public static int findModForLargeNumber(String A, int B) {
	        long num = 0,rem = 0;
	        for(int i=0;i<A.length();i++){
	            num = rem*10 + (A.charAt(i)-'0');
	            rem = num%B;
	        }
	        int remainder = (int)rem;
	        return remainder;
	 }
	 
	 public static int anotherSol(String A, int B) {
		 long ans = 0, r = 1;
	        int N = A.length();
	        for (int i = N-1; i >= 0; i--)
	        {
	            ans = ans%B + ((A.charAt(i) - '0')%B * r%B)%B;
	            r = (r * 10) % B;
	        }
	        return (int)ans%B;
	 }
}
