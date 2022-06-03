/*
 * Problem Description
	Given a string A consisting of lowercase characters.
	
	Check if characters of the given string can be rearranged to form a palindrome.
	
	Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
	Problem Constraints
	1 <= |A| <= 105
	
	A consists only of lower-case characters.
	Input 1:
	
	 A = "abcde"
	Input 2:
	
	 A = "abbaee"
	 Explanation 1:
	
	 No possible rearrangement to make the string palindrome.
	Explanation 2:
	
	 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * N = len(A) # A is the input string
Case 1: When the string is of EVEN len
OBSERVATION: Each char must have its own duplucate for the input string A
to be a palindrome
Using XOR Property: x ^ x = 0
if N & 1 == 0:
xor = ord(A[0])
for i in range(1, N):
xor ^= ord(A[i])
# Check if the XOR of all the chars in the string is 0
if xor == 0: return 1 # A palindrome can be formed
else: return 0
 */
public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abbaee"));
	}
	 public static int solve(String A) {
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        for(int i=0;i<A.length();i++){
	            if(map.containsKey(A.charAt(i))){
	                int temp = map.get(A.charAt(i));
	                map.put(A.charAt(i),++temp);
	            }else
	                map.put(A.charAt(i),1);
	        }
	        int count = 0;
	        for(Character key : map.keySet() ){
	            if(map.get(key)%2==1){
	                count++;
	            if(count>1)
	                return 0;
	            }
	        }
	    return 1;
	    }
}
