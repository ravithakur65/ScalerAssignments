package com.learn.scaler.advance;

/*
 * Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109

Example Input
A = 2, B = 3, C = 3

Example Output
2

Example Explanation
23 % 3 = 8 % 3 = 2

 */
public class ImplementPowerFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(pow(2, 3, 3));
		System.out.println(power2(2, 3, 3));
	}

	public static int pow(int A, int B, int C) {
		/*
		 * int ans = findPow(A,B)%C; if(ans<0) ans = ans+C; return ans; } public int
		 * findPow(int A, int B){ if(B==0) return 1; return A*findPow(A,B-1);
		 */
		if (A == 0)
			return 0;
		if (B == 0)
			return 1;

		long p = (long) pow(A, B / 2, C);
		if (B % 2 == 0) {
			return (int) ((p % C * p % C) + C) % C;
		} else {
			return (int) ((A % C * p % C * p % C) + C) % C;
		}
	}
	 public static int power2(int A, int B, int C) {
	        if (A==0)
	            return 0;
	        if (B==0)
	            return 1;
	        long power= pow(A,B/2,C);
	        long powMod= ((power%C)*(power%C))%C;
	        if ((B&1)==0)
	            return (int)powMod;
	        else{
	            int x= (int)((Long.valueOf(powMod%C)*Long.valueOf(A%C))%C);
	            if (x<0)
	                return C+(int)((Long.valueOf(powMod%C)*Long.valueOf(A%C))%C);
	            else
	                return x;
	        }
	    }
}
