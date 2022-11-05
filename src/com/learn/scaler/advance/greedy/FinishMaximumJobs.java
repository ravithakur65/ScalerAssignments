package com.learn.scaler.advance.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Problem Description
	There are N jobs to be done, but you can do only one job at a time.
	Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
	Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
	Return the maximum number of jobs you can finish.
	
	Problem Constraints
	1 <= N <= 105
	1 <= A[i] < B[i] <= 109
	
	Input Format
	The first argument is an integer array A of size N, denoting the start time of the jobs.
	The second argument is an integer array B of size N, denoting the finish time of the jobs.
	
	Output Format
	Return an integer denoting the maximum number of jobs you can finish.
	
	Example Input
	Input 1:
	 A = [1, 5, 7, 1]
	 B = [7, 8, 8, 8]

	Input 2:
	 A = [3, 2, 6]
	 B = [9, 8, 9]
	
	Example Output
	Output 1:
	 2

	Output 2:
	 1
	
	Example Explanation
	Explanation 1:
	 We can finish the job in the period of time: (1, 7) and (7, 8).

	Explanation 2:
	 Since all three jobs collide with each other. We can do only 1 job.
 */
public class FinishMaximumJobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Job {
		int start;
		int end;

		public Job(int _start, int _end) {
			this.start = _start;
			this.end = _end;
		}
	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int size = A.size();
		List<Job> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(new Job(A.get(i), B.get(i)));
		}
		Collections.sort(list, (job1, job2) -> job1.end - job2.end);
		int curEnd = list.get(0).end;
		int res = 1;
		for (int i = 1; i < size; i++) {
			int nextStart = list.get(i).start;
			if (curEnd <= nextStart) {
				res++;
				curEnd = list.get(i).end;
			}
		}
		return res;
	}
}
