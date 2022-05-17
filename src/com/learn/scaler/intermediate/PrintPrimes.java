/*
 * You need to come up with algorithm to print X number of prime numbers, Take an input X from console. 
// X = 5
// 2, 3, 5 , 7, 11
 */
package com.learn.scaler.intermediate;

import java.util.Scanner;

public class PrintPrimes {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        int count= 3;
	        if(num<0) {
	        	sc.close();
	        	throw new Exception("Invalid Input");
	        }
	        if(num>0)
	        	System.out.print(2+" ");
	        else {
	        	System.out.println("There is no prime number !");
	        	sc.close();
	        	return;
	        }
	        for(int i=1;i<num;){
	            boolean checkPrime = true;
	            for(int j=2;j*j<=count;j++){
	                if(count%j==0){
	                    checkPrime = false;
	                    break;
	                }
	            }
	            if(checkPrime) {
	                System.out.print(count+" ");
	                i++;
	            }
	              count++;  
	        }
	        sc.close();
	}

}
