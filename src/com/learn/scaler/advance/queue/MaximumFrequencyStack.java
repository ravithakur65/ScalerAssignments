package com.learn.scaler.advance.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * Problem Description
	You are given a matrix A of size N x 2 which represents different operations.
	Assume initially you have a stack-like data structure you have to perform operations on it.
	Operations are of two types:
	1 x: push an integer x onto the stack and return -1.
	2 0: remove and return the most frequent element in the stack.
	If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
	A.get(i)[0] describes the type of operation to be performed. A.get(i)[1] describe the element x or 0 corresponding to the operation performed.
	
	Problem Constraints
	1 <= N <= 100000
	1 <= A.get(i)[0] <= 2
	0 <= A.get(i)[1] <= 109
	
	Input Format
	The only argument given is the integer array A.
	
	Output Format
	Return the array of integers denoting the answer to each operation.
	
	Example Input
	Input 1:
	
	A = [
        [1, 5]
        [1, 7]
        [1, 5]
        [1, 7]
        [1, 4]
        [1, 5]
        [2, 0]
        [2, 0]
        [2, 0]
        [2, 0]  ]

	Input 2:
	 A =  [   
        [1, 5]
        [2, 0]
        [1, 4]   ]
	
	
	Example Output
	Output 1:
	 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]

	Output 2:
	 [-1, 5, -1]
	
	Example Explanation
	Explanation 1:
	 Just simulate given operations.

	Explanation 2:
	 Just simulate given operations.
 */
public class MaximumFrequencyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[][] matrix = {
				{1, 5}, {1, 7}, {1, 5}, {1, 7}, {1, 4}, {1, 5}, {2, 0}, {2, 0}, {2, 0}, {2, 0}
				};
	        		
		ArrayList<ArrayList<Integer>> matArrList = new ArrayList<ArrayList<Integer>>();
	    for (Integer[] array : matrix) {
	    	List<Integer> list = new ArrayList<Integer>();
	    	ArrayList<Integer> arrList = new ArrayList<>();
	        list.addAll(Arrays.asList(array));
	        arrList.addAll(list);
	        matArrList.add(arrList);
	    }
	    for (ArrayList<Integer> arrayList : matArrList) {
			System.out.println(arrayList);
		}
	    for (Integer arrayList : solve(matArrList)) {
			System.out.println(arrayList);
		}	}

	public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
		int N = A.size(); // no of rows
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> countHm = new HashMap<>();
		HashMap<Integer, Stack<Integer>> frequencyHm = new HashMap<>();
		int highestFrequency = 0;
		for (int i = 0; i < N; i++) {
			int opType = A.get(i).get(0);
			int data = A.get(i).get(1);

			if (opType == 1) { // push
				countHm.put(data, countHm.getOrDefault(data, 0) + 1); // count frequency of each element
				int freq = countHm.get(data);

				if (freq > highestFrequency) // to maintain the highestFrequency count
					highestFrequency = freq;

				Stack st = frequencyHm.get(freq);
				if (st == null) {
					st = new Stack<>(); // for first time
					st.push(data);
				} else
					st.push(data);

				frequencyHm.put(freq, st); // Maintain the stack for each frequency
				ans.add(-1); // add to ans
			} else { // pop
				Stack<Integer> st = frequencyHm.get(highestFrequency); // get highestFrequency stack
				Integer val = st.pop();

				int freq = countHm.get(val);
				countHm.put(val, --freq); // reduse the frequency count from countHm

				if (st.isEmpty()) // if stack is isEmpty reduce highestFrequency count to prevoius count
					highestFrequency--;

				ans.add(val); // add to ans
			}
		}

		return ans;
	}
}
