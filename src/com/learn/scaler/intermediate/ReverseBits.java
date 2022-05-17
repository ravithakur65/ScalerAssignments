package com.learn.scaler.intermediate;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num = 3;
		System.out.println(reverse(num));

	}
	public static long reverse(long a) {
        StringBuilder binary = convertIntoBinary(a).reverse();
        return convertBinaryToLong(binary);
	}

    public static StringBuilder convertIntoBinary(long num){
        StringBuilder binary = new StringBuilder();
        while(num>0){
            int rem = (int)num%2;
            binary.append(rem);
            num/=2;
        }
        for(int i=binary.length();i<32;i++) {
        	binary.append(0);
        }
        return binary.reverse();
    }
    
    public static long convertBinaryToLong(StringBuilder binary) {
    	long num = 0L;
    	int pow = 0;
    	for(int i=binary.length()-1;i>=0;i--) {
    		double temp = binary.charAt(i)-'0';
    		if(temp==1)
    			num=num+(long)(Math.pow(2, pow));
    		pow++;
    	}
    	return num;
    }
}
