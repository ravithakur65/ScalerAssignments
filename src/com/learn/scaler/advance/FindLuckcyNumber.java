package com.learn.scaler.advance;

/*Problem Description
	A lucky number is a number that has exactly 2 distinct prime divisors.
	
	You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
	
	
	
	Problem Constraints
	1 <= A <= 50000
	
	
	Example Input
	Input 1:
	
	 A = 8
	Input 2:
	
	 A = 12
	
	
	Example Output
	Output 1:
	
	 1
	Output 2:
	
	 3
	
	
	Example Explanation
	Explanation 1:
	
	 Between [1, 8] there is only 1 lucky number i.e 6.
	 6 has 2 distinct prime factors i.e 2 and 3.
	Explanation 2:
	
	 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
*/
public class FindLuckcyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(12));
	}

	public static int solve(int A) {
		// Step1) Build sieve of Eratosthene
		// Sieve for count of prime factors
		int[] sieve = new int[A + 1];
		sieve[0] = -1;
		sieve[1] = -1;

		for (int i = 2; i < A + 1; i++) {
			// Divisor should be a prime number.
			// Therefore sieve[i] == 0
			if (sieve[i] == 0) {
				for (int j = i; j < A + 1; j += i) {
					sieve[j]++;
				}
			}
		}

		// Step2) Final computation
		int count = 0;
		for (int i = 0; i < A + 1; i++) {
			count += (sieve[i] == 2) ? 1 : 0;
		}

		return count;
	}
}
