/*
 * Problem Description
	You are given a string A of size N.
	Return the string A after reversing the string word by word.
	
	NOTE:
	A sequence of non-space characters constitutes a word.
	Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
	If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
package com.learn.scaler.intermediate;

public class ReverseTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv";
		System.out.println(solve(str));
	}
	 public static String solve(String A) {
	        StringBuilder strBuilder = new StringBuilder(A);
	        reverseString(strBuilder,0,A.length()-1);
	        System.out.println(A);
	        System.out.println(strBuilder);
	        int p = 0 ;
	        for(int i=0;i<strBuilder.length();i++){
	            if(i==strBuilder.length()-1 && strBuilder.charAt(i)!=' '){
	                reverseString(strBuilder,p,i);
	            }
	            else if(i!=0 && strBuilder.charAt(i)==' '){
	                reverseString(strBuilder,p,i-1);
	                p=i+1;
	            }
	        }
	        return strBuilder.toString().trim();
	    }
	    public static void reverseString(StringBuilder str, int start, int end){
	        while(start<end){
	            char temp = str.charAt(start);
	            str.setCharAt(start,str.charAt(end));
	            str.setCharAt(end,temp);
	            start++;
	            end--;
	        }
	        
	    }

}
