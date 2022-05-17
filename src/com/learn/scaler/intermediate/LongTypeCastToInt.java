package com.learn.scaler.intermediate;

public class LongTypeCastToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=power(10,5); 
		int b=power(10,6);
		int c = a*b;
		System.out.println(a+" * "+b+" = "+c);
	}
	static int power(int base, int exponent)  
	{  
	int power = 1;  
	//increment the value of i after each iteration until the condition becomes false  
	for (int i = 1; i <= exponent; i++)   
	//calculates power  
	power = power * base;  
	//returns power  
	return power;  
	}  

}
