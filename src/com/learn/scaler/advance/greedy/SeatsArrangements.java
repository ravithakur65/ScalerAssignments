package com.learn.scaler.advance.greedy;

/*
 * Problem Description
	There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
	There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
	An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
	Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
	In one jump a person can move to the adjacent seat (if available).
	
	NOTE: 1. Return your answer modulo 107 + 3.
	
	Problem Constraints
	1 <= N <= 1000000
	A[i] = 'x' or '.'
	
	Input Format
	The first and only argument is a string A of size N.
	
	Output Format
	Return an integer denoting the minimum number of jumps required.
	
	Example Input
	Input 1:
	 A = "....x..xx...x.."

	Input 2:
	 A = "....xxx"
	
	Example Output
	Output 1:
	 5
	
	Output 2:
	 0
	
	Example Explanation
	Explanation 1:
	 Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) 
	                 . . . . x . . x x . . . x . . 
	 Now to make them sit together one of approaches is -
	                 . . . . . . x x x x . . . . .
	 Steps To achieve this:
	 1) Move the person sitting at 4th index to 6th index: Number of jumps by him =   (6 - 4) = 2
	 2) Bring the person sitting at 12th index to 9th index: Number of jumps by him = (12 - 9) = 3
	 So, total number of jumps made: 2 + 3 = 5 which is the minimum possible.
	
	 If we other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.
	 
	Explanation 2:
	
	 They are already together. So, the cost is zero.
 */
public class SeatsArrangements {
	public static void main(String[] args) {

	}

	public int seats(String A) {
		int mod = 10 * 1000 * 1000 + 3;
		if (A == null || A.length() == 0)
			return 0;
		int n = A.length();
		// find start, end positions & # persons
		// Use this approach to avoid O(N) extra space to store indexes of character 'x'
		int start_position = -1, end_position = -1;
		int persons = 0;
		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == 'x') {
				if (start_position == -1)
					start_position = i;
				end_position = i;
				persons++;
			}
		}

		if (persons < 2 || persons == n)
			return 0;
		// median position can be found mid_count distance from start_position
		int mid_count = (persons - 1) / 2;
		int i = start_position;
		while (i < end_position && mid_count >= 0) {
			if (A.charAt(i) == 'x') {
				mid_count--;
			}
			i++;
		}

		// previous location is where median position lies, as variable 'i' incremented
		// by 1
		int median_position = i - 1;

		// sum all absolute differences from median towards left side
		long minCost = 0;
		int curr_position = median_position - 1, vacant_position = median_position - 1;
		while (curr_position >= start_position) {
			if (A.charAt(curr_position) == 'x') {
				minCost = (minCost + (vacant_position - curr_position)) % mod;
				vacant_position--;
			}
			curr_position--;
		}
		// sum all absolute differences from median towards right side
		curr_position = median_position + 1;
		vacant_position = median_position + 1;
		while (curr_position <= end_position) {
			if (A.charAt(curr_position) == 'x') {
				minCost = (minCost + (curr_position - vacant_position)) % mod;
				vacant_position++;
			}
			curr_position++;
		}
		return (int) minCost;
	}
}
