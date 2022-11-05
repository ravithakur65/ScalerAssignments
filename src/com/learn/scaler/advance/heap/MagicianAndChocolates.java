package com.learn.scaler.advance.heap;

/*
 * Problem Description
	Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
	In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
	
	Find the maximum number of chocolates that the kid can eat in A units of time.
	
	NOTE:
	
	floor() function returns the largest integer less than or equal to a given number.
	Return your answer modulo 109+7
	
	
	Problem Constraints
	1 <= N <= 100000
	0 <= B[i] <= INT_MAX
	0 <= A <= 105
	
	
	
	Input Format
	The first argument is an integer A.
	The second argument is an integer array B of size N.
	
	
	
	Output Format
	Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
	
	
	
	Example Input
	Input 1:
	
	 A = 3
	 B = [6, 5]
	Input 2:
	
	 A = 5
	 b = [2, 4, 6, 8, 10]
	
	
	Example Output
	Output 1:
	
	 14
	Output 2:
	
	 33
	
	
	Example Explanation
	Explanation 1:
	
	 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
	 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
	 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
	 so, total number of chocolates eaten are 6 + 5 + 3 = 14
	Explanation 2:
	
	 Maximum number of chocolates that can be eaten is 33.
 */
public class MagicianAndChocolates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sizeHeap = 0;

	public int nchoc(int A, int[] B) {

		int mod = (int) 1e9 + 7;

		sizeHeap = B.length;

		maxHeapify(B);

		int ans = 0;

		int i = 0;

		while (i < A && sizeHeap > 0) {

			int max = B[0];
			removeMax(B);
			ans = ((ans % mod) + (max % mod)) % mod;
			int newEle = max / 2;
			insert(newEle, B);
			i++;
		}

		return ans;
	}

	void insert(int ele, int[] B) {

		if (ele > 0) {
			B[sizeHeap] = ele;
			upHeapify(B);
			sizeHeap++;
		}

	}

	void upHeapify(int[] B) {

		int ind = sizeHeap - 1;

		while (ind > 0) {

			int p = (ind - 1) / 2;

			if (B[p] < B[ind]) {
				int temp = B[p];
				B[p] = B[ind];
				B[ind] = temp;
			} else {
				break;
			}

			ind = p;
		}
	}

	void removeMax(int A[]) {

		if (sizeHeap == 0) {
			return;
		}

		int temp = A[sizeHeap - 1];
		A[sizeHeap - 1] = A[0];
		A[0] = temp;

		A[sizeHeap - 1] = -1;
		sizeHeap--;

		downHeapify(0, A);

	}

	void maxHeapify(int[] A) {

		int size = A.length;
		int end = (size - 2) / 2;

		for (int i = end; i >= 0; i--) {
			downHeapify(i, A);
		}
	}

	void downHeapify(int ind, int[] A) {

		int len = sizeHeap;

		while (ind < len) {

			int left = 2 * ind + 1;
			int right = 2 * ind + 2;

			int max = ind;

			if (left < len) {
				if (A[left] > A[max]) {
					max = left;
				}
			}

			if (right < len) {
				if (A[right] > A[max]) {
					max = right;
				}
			}

			if (ind == max) {
				break;
			}

			int temp = A[max];
			A[max] = A[ind];
			A[ind] = temp;

			ind = max;
		}

	}
}
