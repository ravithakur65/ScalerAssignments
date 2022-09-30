package com.learn.scaler.advance.queue;

/*
 * Problem Description
	Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
	B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
	
	Problem Constraints
	1 <= |A| <= 100000
	
	Input Format
	The only argument given is string A.

	Output Format
	Return a string B after processing the stream of lowercase alphabets A.
	
	Example Input
	Input 1:
	 A = "abadbc"

	Input 2:
	 A = "abcabc"
	
	Example Output
	Output 1:
	"aabbdd"

	Output 2:
	"aaabc#"
	
	Example Explanation
	Explanation 1:
	
	"a"      -   first non repeating character 'a'
	"ab"     -   first non repeating character 'a'
	"aba"    -   first non repeating character 'b'
	"abad"   -   first non repeating character 'b'
	"abadb"  -   first non repeating character 'd'
	"abadbc" -   first non repeating character 'd'
	
	Explanation 2:
	
	"a"      -   first non repeating character 'a'
	"ab"     -   first non repeating character 'a'
	"abc"    -   first non repeating character 'a'
	"abca"   -   first non repeating character 'b'
	"abcab"  -   first non repeating character 'c'
	"abcabc" -   no non repeating character so '#'
 */
import java.util.LinkedList;
import java.util.Queue;

public class FirstNon_Repeatingcharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("abadbc"));
	}

	public static String solve(String A) {
		// If you adding string to same string var Eg ans +="xyz". For a very long input
		// it would give TLE.
		// Reason : Basic 101, String create anew variable each time.
		// Sol : Use String builder.
		Queue<Character> q = new LinkedList<Character>();

		int[] arr = new int[26];
		StringBuilder ans = new StringBuilder();
		int len = A.length();

		for (int i = 0; i < len; i++) {

			int x = (int) A.charAt(i) - 'a';
			arr[x]++;

			if (arr[x] == 1)
				q.add(A.charAt(i));
			while (!q.isEmpty()) {
				x = (int) q.peek() - 'a';
				if (arr[x] > 1) {
					q.remove();
				} else {
					break;
				}
			}

			if (!q.isEmpty())
				ans.append(q.peek());
			else
				ans.append('#');
		}
		return ans.toString();
	}

// TC : O(N+K)
// SC : O(K)

	/*
	 * Using HashMap
	 * 
	 * public String solve(String A) { Queue<Character> q = new
	 * LinkedList<Character>();
	 * 
	 * HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	 * StringBuilder ans = new StringBuilder(); int len = A.length();
	 * 
	 * for(int i =0; i< len ; i++){ if(!hm.containsKey(A.charAt(i)))
	 * hm.put(A.charAt(i),1); else hm.put(A.charAt(i),hm.get(A.charAt(i))+1);
	 * if(hm.containsKey(A.charAt(i)) && hm.get(A.charAt(i))==1) q.add(A.charAt(i));
	 * while(!q.isEmpty()){ if(hm.get(q.peek())>1){ q.remove(); }else{ break; } }
	 * if(!q.isEmpty()) ans.append(q.peek()); else ans.append('#'); } return
	 * ans.toString(); }
	 */
}
