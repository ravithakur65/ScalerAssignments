package com.learn.scaler.intermediate.recursion;

/*
 * Problem Description
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).

    Problem Constraints
    1 <= A <= 20
    1 <= B <= 2A - 1

    Input Format
    First argument is an integer A.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the Bth indexed symbol in row A.

    Example Input
    Input 1:
    A = 2
    B = 1

    Input 2:
    A = 2
    B = 2

    Example Output
    Output 1:
    0

    Output 2:
    1

    Example Explanation
    Explanation 1:
    Row 1: 0
    Row 2: 01

    Explanation 2:
    Row 1: 0
    Row 2: 01
 */
public class KthSymbol {
    public static void main(String[] args) {
        int A = 2;
        int B = 1;
        System.out.println(new KthSymbol().solve(A, B));
    }

    public int solve(int A, int B) {
        // if you start creating new symbols by reviewing previous
        // it will give TLE
        // observation 1 : evry time the size of new row is multiplied ny two
        // observation 2 : find mid of new row
        // observation 3 : characters from 0 to mid in new row is same as preious
        // row(n-1)
        // observation 4 : characters after mid value is same as previous row with
        // toggle efferct (0->1),(1->0)
        // if B is less than mid than simply use previous row values
        // if B is greater than mid than use previous row with B-mid mapping and toggle
        // efferct

        return findSymbol(A, B);
    }

    private int findSymbol(int n, int k) {
        if (n == 1 && k == 1)
            return 0;
        else {
            // find mid of row using observation 1
            // if n = 0 length is 1
            // n = 1 length is 2, n =3 length 2*2 = 4, n=4 length is 4*2 = 8
            // length = 2^n-1
            // mid = length/2;
            int mid = (int) (Math.pow(2, n - 1)) / 2;

            if (k <= mid) {
                return findSymbol(n - 1, k);
            } else {
                return findSymbol(n - 1, k - mid) == 0 ? 1 : 0;
            }

        }
    }

   
}
