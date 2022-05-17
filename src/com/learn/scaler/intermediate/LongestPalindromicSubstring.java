package com.learn.scaler.intermediate;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("xabbay"));
	}
	 public static String longestPalindrome(String A) {
	        int ans = 0;
	        int maxLen = 0;
	        StringBuilder maxSubString = new StringBuilder();
	        for(int i=0;i<A.length();i++){
	            StringBuilder sub1 = getMaxSubString(A,i,i);
	            StringBuilder sub2 = getMaxSubString(A,i,i+1);
	            maxLen = Math.max(sub1.length(),sub2.length());
	            if(ans<maxLen){
	                 if(sub1.length()>sub2.length()){
	                    maxSubString = sub1;
	                }
	                else{
	                    maxSubString = sub2;
	                }
	                ans = maxLen;
	            }
	        }
	       
	        return maxSubString.toString();
	    }

	    public static StringBuilder getMaxSubString(String str, int i, int j){
	        StringBuilder left = new StringBuilder();
	        StringBuilder right = new StringBuilder();

	        while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
	        	if(i==j)
		        	left.append(str.charAt(i));
	        	else{
	        		left.append(str.charAt(i));
	        		right.append(str.charAt(j));
	        	}
	            i--;
	            j++;
	        }
	        left.reverse();
	        return left.append(right);
	    }
}
