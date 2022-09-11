package com.learn.scaler.advance;

import java.util.HashSet;

/*
 * Problem Description
	Given an array A of length N. You have to answer Q queries.
	Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
	NOTE The queries are 0-indexed.
	
	Problem Constraints
	0 <= A[i] <= 100000
	1 <= N <= 100000
	1 <= Q <= 100000
	
	Input Format
	The first argument is an array A.
	The second is a 2D array B denoting queries with dimension Q * 4.
	Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].

	Output Format
	Return an array of length Q with answers to the queries in the same order as the input.
	
	Example Input
	Input 1:
	 A = [1, 7, 11, 8, 11, 7, 1]
	 B = [ 
	       [0, 2, 4, 6]
	     ]

	Input 2:
	 A = [1, 3, 2]
	 B = [
	       [0, 1, 1, 2]
	     ] 
	
	Example Output
	Output 1:
	 [1]

	Output 2:
	 [0]
	
	Example Explanation
	Explanation 1:
	 (0, 2) -> [1, 7, 11]
	 (4, 6) -> [11, 7, 1]
	 Both are same when sorted hence 1.

	Explanation 2:
	 (0, 1) -> [1, 3]
	 (1, 2) -> [3, 2] 
	 Both are different when sorted hence 0.
 */
public class CompareSortedSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1, 7, 11, 8, 11, 7, 1};
		int[][] num2 = {{0, 2, 4, 6}};
		for(int num: solve(num1, num2)) {
			System.out.println(num);
		}
	}

	public static int[] solve(int[] A, int[][] B) {
        HashSet<Integer> hashSet = new HashSet<>();        
        int[] result = new int[B.length];
        int diff;
        int a, b;
        int l1, r1, l2, r2;
        
        for ( int i = 0; i < B.length; i++ )
        {
            l1 = B[i][0];
            r1 = B[i][1];            
            l2 = B[i][2];
            r2 = B[i][3];
            diff = r2 - l2+1;
            a = 0;
            b = 0;

            for ( int idx = l1; idx <= r1; idx++ )
            {               
                hashSet.add(A[idx]);                
                if ( hashSet.contains(A[idx]) && A[l2] == A[idx] )
                {
                    l2++;
                    a++;
                    hashSet.remove(A[idx]);
                }
                else if ( hashSet.contains(A[idx]) && A[r2] == A[idx] )
                {
                    r2--;
                    b++;
                    hashSet.remove(A[idx]);                    
                }
                else                 
                    break;                
            }
            if ( diff == a+b )            
                result[i] = 1;            
            else             
                result[i] = 0;            
        }                
        return result;
    }
}
