package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * You have given an array A having N integers. Let say G is the product of all elements of A.

    You have to find the number of distinct prime divisors of G.

    Input Format
    The first argument given is an Array A, having N integers.

    Output Format
    Return an Integer, i.e number of distinct prime divisors of G.
    Constraints

    1 <= N <= 1e5
    1 <= A[i] <= 1e5
    For Example

    Input:
        A = [1, 2, 3, 4]
    Output:
        2

    Explanation:
        here G = 1 * 2 * 3 * 4 = 24
        and distinct prime divisors of G are [2, 3]
 */
public class DistinctPrimes {
    public static void main(String[] args) {
        DistinctPrimes obj = new DistinctPrimes();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(obj.solve(A));
    }

    public int solve(ArrayList<Integer> A) {
        // Calcuating prime divisors for individual array elements using sieve array
        int size = 100001;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i < A.size(); i++)
            set.add(A.get(i));
        for (int i = 2; i < size; i++) {
            if (isPrime(i)) {
                for (int j = i; j < size; j += i) {
                    if (set.contains(j)) {
                        ans.add(i);
                    }
                }
            }
        }
        return ans.size();
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
