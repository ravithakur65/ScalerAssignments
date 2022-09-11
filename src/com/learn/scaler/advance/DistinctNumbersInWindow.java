package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Description
	You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
	Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
	NOTE: if B > N, return an empty array.
	
	Example Input
	Input 1:
	 A = [1, 2, 1, 3, 4, 3]
	 B = 3

	Input 2:
	 A = [1, 1, 2, 2]
	 B = 1
	
	Example Output
	Output 1:
	 [2, 3, 3, 2]

	Output 2:
	 [1, 1, 1, 1]
	
	Example Explanation
	Explanation 1:
	 A=[1, 2, 1, 3, 4, 3] and B = 3
	 All windows of size B are
	 [1, 2, 1]
	 [2, 1, 3]
	 [1, 3, 4]
	 [3, 4, 3]
	 So, we return an array [2, 3, 3, 2].

	Explanation 2:
	 Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 1, 3, 4, 3};
		int B =3;
		for(int temp: dNums(A, B))
			System.out.print(temp+" ");
		System.out.println("\n-------------------------------------");
		System.out.println(dNums(
				new ArrayList<Integer>(
						Arrays.asList(
								Arrays
								.stream(A)
								.boxed()
								.toArray(Integer[]::new)))
				, B));
	}

	public static int[] dNums(int[] A, int B) {

		int n = A.length;
		int[] ans = new int[n - B + 1];

		// BRUTEFORCE APPROCH
		// for(int i = 0; i < (n - B + 1); i ++){
		// HashSet<Integer> set = new HashSet<>();
		// for(int j = i; j < i + B; j++){
		// set.add(A[j]);
		// }
		// ans[i] = set.size();
		// }
		// return ans;

		// OPTIMISE APPROCH
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B; i++) {
			if (map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
			} else {
				map.put(A[i], 1);
			}
		}
		ans[0] = map.size();
		int start = 1;
		int end = B;
		while (start < (n - B + 1)) {
			if (map.containsKey(A[end])) {
				map.put(A[end], map.get(A[end]) + 1);
			} else {
				map.put(A[end], 1);
			}
			if (map.containsKey(A[start - 1])) {
				map.put(A[start - 1], map.get(A[start - 1]) - 1);
				if (map.get(A[start - 1]) == 0) {
					map.remove(A[start - 1]);
				}
			}
			ans[start] = map.size();
			start++;
			end++;
		}
		return ans;
	}
	
	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        for (int i = 0; i < B; i++) {
            int num = A.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ans.add(map.size());
        for (int i = B; i < n; i++) {
            int num = A.get(i);
            int out = A.get(i - B);
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
            ans.add(map.size());
        }
        return ans;
    }
}
