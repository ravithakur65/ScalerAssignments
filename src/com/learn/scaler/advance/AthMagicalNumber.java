package com.learn.scaler.advance;
/*
 * Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
    public static void main(String[] args) {

    }

    public int solve(int A, int B, int C) {
        return calculateAthSmallestNumber(A, B, C);
    }

    public static int calculateAthSmallestNumber(int A, int B, int C) {
        long a = A;
        long b = B;
        long c = C;
        int mod = 1000000007;
        long left = 1;
        long right = a * Math.min(B, C);
        long ans = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (totalMagicNumber(mid, b, c) >= a) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (ans % mod);
    }

    // for calculating total magical number till mid.
    public static long totalMagicNumber(long mid, long b, long c) {
        long lcm = (b * c) / gcd(b, c); // LCM = (no1 * no2 / HCF(no1, no2))
        return (((mid / b) + (mid / c)) - (mid / lcm));
    }

    // for calculating GCD
    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
