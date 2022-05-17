/*
 * Write a program to input an integer N from user and print hollow diamond star pattern 
 * series of N lines.
 * Input : 4
 *  output:
				    ********
					***  ***
					**    **
					*      *
					*      *
					**    **
					***  ***
					********
 *
 */
package com.learn.scaler.intermediate;

import java.util.Scanner;

public class PrintHollowStarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        int startIndex = 1;
        int endIndex = num;
        for(int j=1;j<=num*2;j++){
            System.out.print("*");
        }
        System.out.println();
        
        for(int i=1;i<num*2;i++){
        	
        	if(i>num) {
        		startIndex=1;
        		endIndex = i-num;
        	}else {
        		endIndex = num-i;
        	}
        	//First part of stars
            for(int j=startIndex;j<=endIndex;j++){
                System.out.print("*");
            }

            //Empty spaces
            if(endIndex!=0) {
	            for(int j=startIndex;j<=(num-endIndex)*2;j++){
	                System.out.print(" ");
	            }
            }

            //Second part of stars
            for(int j=startIndex;j<=endIndex;j++){
                System.out.print("*");
            }
            if(endIndex!=0)
            	System.out.println();
        }
        for(int j=1;j<=num*2;j++){
            System.out.print("*");
        }
	}

}
