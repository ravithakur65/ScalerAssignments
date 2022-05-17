/*
 * Problem Description

	You are given a function isalpha() consisting of a character array A.
	Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
 */
package com.learn.scaler.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsAlphaNumeric {

	public static void main(String[] args) {
		//List<Character> charList = Arrays.asList( '#','S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0');
		List<Character> charList = Arrays.asList('s', 'g', '7', 'A', 'd', 'v', 't', 'W', '4', 'A', '4', '2', '8', 'f', 'h', 'B', 'p', 'h', '7', '0', 'v', 'q', 'w', '9', 'o' );
		ArrayList<Character> chars = new ArrayList<>();
		chars.addAll(charList);
		System.out.println(solve(chars));
	}
	public static int solve(ArrayList<Character> A) {
        for(int i=0;i<A.size();i++){
            char temp = A.get(i);
            if((temp<65 || temp>90) && (temp<97 || temp>122) && (temp<48 || temp>57)) {
            	System.out.print(temp+" "+(int)temp+" : ");
                return 0;
            }
        }
        return 1;
    }
}
