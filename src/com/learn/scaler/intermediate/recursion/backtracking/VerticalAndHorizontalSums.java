package com.learn.scaler.intermediate.recursion.backtracking;

/*
 * Problem Description

	Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.
	A special operation involves multiplying any element by -1 i.e. changing its sign.
	Return 1 if it is possible to achieve the answer, otherwise 0.
	
	Problem Constraints
	1 <= N, M <= 10
	0 <= A <= 5
	-105 <= B[i][j], C <= 105
	
	Input Format
	The first argument is an integer A, representing the number of special operations allowed.
	The second argument has the N x M integer matrix, B.
	The third argument is an integer C, as described in the problem statement.
	
	Output Format
	Return 1 if it is possible to achieve the answer, otherwise 0.
	
	Example Input
	Input 1:
	
	 A = 3
	 B = [  
	        [1, 1, 1]
	        [1, 1, 1]
	        [1, 1, 1]
	     ]
	 C = 2
	Input 2:
	
	 A = 1
	 B = [
	        [1, 1, 1]
	        [1, 1, 1]
	        [1, 1, 1]
	     ]
	 C = 2
	
	
	Example Output
	
	Output 1:
	
	 1
	Output 2:
	
	 0
	
	
	Example Explanation
	
	Explanation 1:
	
	 The given matrix does not satisfy the conditions, but if we apply the special operation to B[0][0], B[1][1], B[2][2],
	 then the matrix would satisfy the given conditions i.e. no row or column has a sum greater than 2.
	Explanation 2:
	
	 It is not possible to apply the special operation to 1 element to satisfy the conditions.
 */
public class VerticalAndHorizontalSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int a[][], sum;
	int col[], n, m;

	boolean check(int u, int v, int op_left, int rsum) {
		if (rsum > sum)
			return false;
		if (rsum < 0)
			rsum = 0;
		if (v == m) {
			v = 0;
			u++;
			rsum = 0;
		}
		if (u == n) {
			for (int x : col) {
				if (x > sum)
					return false;
			}
			return true;
		}
		if (col[v] > sum)
			return false;
		int old = col[v];
		col[v] = Math.max(col[v] + a[u][v], 0);
		if (check(u, v + 1, op_left, rsum + a[u][v]))
			return true;
		col[v] = old;
		if (op_left > 0) {
			col[v] = Math.max(col[v] - a[u][v], 0);
			if (check(u, v + 1, op_left - 1, rsum - a[u][v]))
				return true;
			col[v] = old;
		}
		return false;
	}

	public int solve(int A, int[][] B, int C) {
		a = B;
		sum = C;
		n = a.length;
		m = a[0].length;
		col = new int[m];
		return check(0, 0, A, 0) ? 1 : 0;
	}
}
