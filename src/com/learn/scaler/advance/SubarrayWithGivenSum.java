package com.learn.scaler.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * Problem Description
	Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
	If the answer does not exist return an array with a single element "-1".
	First sub-array means the sub-array for which starting index in minimum.
	
	Problem Constraints
	1 <= length of the array <= 100000
	1 <= A[i] <= 109
	1 <= B <= 109

	Example Input
	Input 1:
	 A = [1, 2, 3, 4, 5]
	 B = 5

	Input 2:
	 A = [5, 10, 20, 100, 105]
	 B = 110
	
	Example Output
	Output 1:
	 [2, 3]

	Output 2:
	 -1
	
	Example Explanation
	Explanation 1:
	 [2, 3] sums up to 5.

	Explanation 2:
	 No subarray sums up to required number.
 */
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5};
		int B = 110;
		/*
		 * int[] res = solve(nums,B); for(int temp :res){ System.out.print(temp+" "); }
		 */
		List<Integer> list = Arrays.asList(5, 10, 20, 100, 105);
		ArrayList<Integer> arrList = new ArrayList();
		arrList.addAll(list);
		System.out.println(findPair(arrList,B));
	}
	
	public static int[] solve(int[] A, int B) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int[] result = new int[2];
        for(int i=0;i<A.length;i++){
            int temp = B-A[i];
            if(hs.contains(temp)){
                result[0]=temp;
                result[1]= A[i];
                break;
            }else
                hs.add(A[i]);
            if(i==A.length-1) {
            	result[0]=-1;
            }
        }

        return result;
    }
	
	private static ArrayList<Integer> findPair(ArrayList<Integer> A, int B){
		int s = -1;
        int e = -1;
        long sum =0;
        long su = 0;
        //  Heapmap  Creation 
        HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        hm.put(0l,-1);
        for (int i=0 ;i<A.size() ; i++){
            sum  = A.get(i)+sum;
            su = sum-B;
            if (hm.containsKey(su)){
                s=hm.get(su)+1;
                e=i;
                break ;
            }else {
                hm.put(sum,i);
            }
        }
        if ((s==-1)&&(e==-1)){
            ar.add(-1);
            return ar;
        }
        for (int i =s;i<=e;i++){
            ar.add(A.get(i));
        }
        return ar;
	}

}
