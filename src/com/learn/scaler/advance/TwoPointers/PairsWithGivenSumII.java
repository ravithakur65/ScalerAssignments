package com.learn.scaler.advance.TwoPointers;

public class PairsWithGivenSumII {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 6, 7, 9, 9 };
        int sum = 13;
        System.out.println(solve(arr, sum));
    }

    public static int solve(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        int l = 0, r = A.length - 1, ans = 0;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum == B) {
                int count = 0, prev = r;
                while (prev > l && A[r] == A[prev]) {// count duplicate values from right pointer
                    count++;
                    prev--;
                }
                ans = (ans + count) % mod;
                l++;
            } else if (sum < B) {
                l++;
            } else if (sum > B) {
                r--;
            }
        }
        return ans;
    }
}
