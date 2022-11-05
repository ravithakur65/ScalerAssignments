package com.learn.scaler.advance;

import java.util.ArrayList;

/*
 * Problem Description
	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	You may assume that the intervals were initially sorted according to their start times.
	
	Problem Constraints
	0 <= |intervals| <= 105
	
	Input Format
	First argument is the vector of intervals
	second argument is the new interval to be merged
	
	Output Format
	Return the vector of intervals after merging
	
	Example Input
	Input 1:
	Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

	Input 2:
	Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
	
	Example Output
	Output 1:
	 [ [1, 5], [6, 9] ]

	Output 2:
	 [ [1, 9] ]
	
	
	Example Explanation
	Explanation 1:
	(2,5) does not completely merge the given intervals

	Explanation 2:
	(2,6) completely merges the given intervals
 */
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval int1 = new Interval(1,3);
		Interval int2 = new Interval(6,9);
		Interval newInt3 = new Interval(2,5);
		ArrayList<Interval> intervalList = new ArrayList<>();
		intervalList.add(int1);
		intervalList.add(int2);
		for(Interval val : insert(intervalList, newInt3))
			System.out.println("Start :"+val.start+ " End :"+val.end);
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int i = 0;
		ArrayList<Interval> merged = new ArrayList<>();
		while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
			merged.add(intervals.get(i));
			i++;
		}

		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			i++;
		}
		merged.add(newInterval);

		while (i < intervals.size()) {
			merged.add(intervals.get(i++));
		}

		return merged;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
