package com.learn.scaler.advance.dp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Problem Description
 * Given a strictly increasing array A of positive integers forming a sequence.
 * 
 * A sequence X1, X2, X3, ..., XN is fibonacci like if
 * 
 * 
 * N > =3
 * Xi + Xi+1 = Xi+2 for all i+2 <= N
 * Find and return the length of the longest Fibonacci-like subsequence of A.
 * 
 * If one does not exist, return 0.
 * 
 * NOTE: A subsequence is derived from another sequence A by deleting any number
 * of elements (including none) from A, without changing the order of the
 * remaining elements.
 * 
 * 
 * 
 * Problem Constraints
 * 3 <= length of the array <= 1000
 * 
 * 1 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format
 * The only argument given is the integer array A.
 * 
 * 
 * 
 * Output Format
 * Return the length of the longest Fibonacci-like subsequence of A.
 * If one does not exist, return 0.
 * 
 * 
 * 
 * Example Input
 * Input 1:
 * 
 * A = [1, 2, 3, 4, 5, 6, 7, 8]
 * Input 2:
 * 
 * A = [1, 3, 7, 11, 12, 14, 18]
 * 
 * 
 * Example Output
 * Output 1:
 * 
 * 5
 * Output 2:
 * 
 * 3
 * 
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
 * Explanation 2:
 * 
 * The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or
 * [7, 11, 18].
 * The length will be 3.
 */
public class LengthOfLongestFibSubseq {
    public static void main(String[] args) {
        LengthOfLongestFibSubseq obj = new LengthOfLongestFibSubseq();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        System.out.println(obj.solve(A));
    }

    public int solve(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.size(); i++) {
            hm.put(A.get(i), i);
        }
        int maxLength = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int a = i, b = j, count = 0;
                while (hm.containsKey(A.get(a) + A.get(b))) {
                    // System.out.print("---"+A.get(a)+"----"+A.get(b)+"---");
                    int temp = b;
                    b = hm.get(A.get(a) + A.get(b));
                    a = temp;
                    count++;
                }

                if (count != 0) {
                    count += 2;
                    maxLength = Math.max(maxLength, count);
                }
            }
        }
        return maxLength;
    }
}
