package com.learn.scaler.advance;

/*
 * Problem Description
	Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
	You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
	
	Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
	NOTE:
	1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
	2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
	
	Return the ans % 10000003.
	
	
	
	Problem Constraints
	1 <= A <= 1000
	1 <= B <= 106
	1 <= N <= 105
	1 <= C[i] <= 106
	
	Example Input
	Input 1:
	 A = 2
	 B = 5
	 C = [1, 10]

	Input 2:
	 A = 10
	 B = 1
	 C = [1, 8, 11, 3]
	
	
	Example Output
	Output 1:
	 50

	Output 2:
	 11
	
	
	Example Explanation
	Explanation 1:
	
	 Possibility 1:- One painter paints both blocks, time taken = 55 units.
	 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
	 There are no other distinct ways to paint boards.
	 ans = 50 % 10000003
	
	Explanation 2:
	 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3 
	 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
	 ans = 11 % 10000003
 */
public class PaintersPartitionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] C = {1, 8, 11, 3};
		int A = 10;
		int B = 1;
		System.out.println(paint(A, B, C));
		System.out.println(paintAnotherSolution(A, B, C));
	}
	
	//Another solution
	 public static int paintAnotherSolution(int A, int B, int[] C) {

	        long m = 10000003;
	        long total_sum = 0;
	        long max_num = C[0];
	        for(int i=0; i<C.length; i++)
	        {
	            total_sum += C[i];
	            if(C[i] > max_num)
	                max_num = C[i];
	        }
	        long low = max_num;
	        long high = total_sum;
	        long ans = 0L;
	        while(low <= high)
	        {
	            long mid = low+high>>1;
	            int k = painterRequired(C, mid);
	            if(k <= A)
	            {
	                ans = mid;
	                high = mid-1;
	            }
	            else
	                low = mid+1;
	        }
	        return (int)((ans*B)%m);
	    }


	    static int painterRequired(int[] C, long unit)
	    {
	        int painter = 1;
	        long cur_unit = 0;
	        for(int i=0; i<C.length; i++)
	        {
	            cur_unit += C[i];
	            if(cur_unit > unit)
	            {
	                painter++;
	                cur_unit = 0;
	                i--;
	            }
	        }
	        return painter;
	    }
	    
	    //The first solution
	 public static int paint(int A, int B, int[] C) {
	        /*
	            target = min time
	            search space = [max(C[])*B, sum(C[])*B]
	        */
	        long l = max(C), h = sum(C);
	        long ans = h;
	        while(l<=h){
	            long mid = (l + ((h-l)/2));
	            if(canDo(A, C, mid)){
	                ans = mid;
	                h = mid-1;
	            } else{
	                l = mid+1;
	            }
	        }
	        return (int)((ans*B)%p);
	    }
	    private static final int p = 10000003;
	    private static int max(int[] C){
	        int maxOfC = C[0];
	        for(int i: C){
	            if(i>maxOfC){
	                maxOfC = i;
	            }
	        }
	        return maxOfC;
	    }
	    private static long sum(int[] C){
	        long sumOfC = 0;
	        for(int i : C){
	            sumOfC = sumOfC+i;
	        }
	        return sumOfC;
	    }

	    private static boolean canDo(int A, int[] C,  long time){
	        //check if task can be done in given 'time'
	        long s = 0l; int painters = 0;
	        for(int i=0; i<C.length; i++){
	            s = (s + C[i]);
	            if(s>time){
	                painters++;
	                s = C[i];
	            }
	        }
	        painters++;
	        if(painters <= A) return true;
	        return false;
	    }
}
