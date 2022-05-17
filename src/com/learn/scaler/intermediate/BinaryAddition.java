package com.learn.scaler.intermediate;

public class BinaryAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "0111";
		String B ="0100";
		String ans = "1011";
		System.out.println(addBinary(A,B));
		System.out.println(ans.equals(addBinary(A,B)));

	}

	 public static String addBinary(String A, String B) {
	        StringBuilder result = new StringBuilder();
	        int carry = 0;
	        int remA = 0;
	        int remB = 0;
	        int indexA = A.length()-1;
	        int indexB = B.length()-1;
	        int maxSize = Math.max(A.length(),B.length());
	        for(int i=maxSize-1;i>=0;i--){
	            remA=0; remB=0;
	            if(indexA>=0)
	                remA= A.charAt(indexA)-'0'; //When two characters get subtracted, their ASCII values get subtracted
	            if(indexB>=0)
	                remB = (int)B.charAt(indexB)-'0'; //When two characters get subtracted, their ASCII values get subtracted
	            int sum =remA+remB+carry; 
	            carry = (sum)/2;
	            result.append(sum%2);
	            indexA--;
	            indexB--;
	        }
	        
	        result = result.reverse();
	        return (carry == 0) ? result.toString() : "1" + result.toString();
	    }
	 
	 public static String addBinarySolution(String A, String B) {
		 int max_len = Math.max(A.length(),B.length());
	        int carry = 0;
	        String result = "";
	        for(int i =0;i<max_len;i++){
	            int p = i < A.length() ? A.charAt(A.length() - 1 - i) - '0' : 0;
	            int q = i < B.length() ? B.charAt(B.length() - 1 - i) - '0' : 0;
	            int sum = p + q + carry;
	            carry = sum / 2;   // dividing by 2 because base is 2
	            result = sum % 2 + result;       // 2 refer here the base value
	        }
	        return (carry == 0) ? result : "1" + result;
	 }
}
