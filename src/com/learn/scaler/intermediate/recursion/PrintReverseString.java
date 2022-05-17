package com.learn.scaler.intermediate.recursion;

import java.util.Scanner;

public class PrintReverseString {

	 public static void main(String[] args) {
	        // YOUR CODE GOES HERE
	        // Please take input and print output to standard input/output (stdin/stdout)
	        // DO NOT USE ARGUMENTS FOR INPUTS
	        // E.g. 'Scanner' for input & 'System.out' for output
	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        printReverse(str, str.length()-1);
	        sc.close();
	    }
	    public static void printReverse(String str, int len){
	        if(len==0){
	            System.out.print(str.charAt(len));
	            return;
	        }
	        System.out.print(str.charAt(len));
	        printReverse(str,--len);
	    }

}
