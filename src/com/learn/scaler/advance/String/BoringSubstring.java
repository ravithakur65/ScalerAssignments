package com.learn.scaler.advance.String;
/*
 * Problem Description
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is a string A.



Output Format
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.



Example Input
Input 1:

 A = "abcd"
Input 2:

 A = "aab"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:

 No arrangement of string A can make it free of boring substrings.
 */
public class BoringSubstring {
    public static void main(String[] args) {
        String A = "abcd";
        System.out.println(solve(A));
    }
    public static int solve(String A) {
        int evenMax = Integer.MIN_VALUE;
       int evenMin = Integer.MAX_VALUE;
       int oddMax = Integer.MIN_VALUE;
       int oddMin = Integer.MAX_VALUE;

       int n = A.length();
       for(int i = 0; i < n; i++){
           int val = (int) (A.charAt(i) - 'a') + 1;
           if(val % 2 == 0){
               evenMax = Math.max(evenMax, val);
               evenMin = Math.min(evenMin, val);
           }else{
               oddMax = Math.max(oddMax, val);
               oddMin = Math.min(oddMin, val);
           }
       }

       if(Math.abs(evenMax - oddMin) != 1 || Math.abs(oddMax - evenMin) !=1)
           return 1;
       return 0;
   }
}
