package com.learn.scaler.advance;
/*Problem Description
	Given an array of integers A, find and return the count of divisors of each element of the array.
	NOTE: The order of the resultant array should be the same as the input array.
	
	Problem Constraints
	1 <= length of the array <= 100000
	1 <= A[i] <= 106
	
	Example Input
	Input 1:
	
	 A = [2, 3, 4, 5]
	Input 2:
	
	 A = [8, 9, 10]
	
	
	Example Output
	Output 1:
	
	 [2, 2, 3, 2]
	Output 1:
	
	 [4, 3, 4]
*/

//Step 1. Calculate the maximum value in array because we need to build an array till that element to hold the number of divisors
//Step 2. Initialize a divisor array of length max+1 i.e. int[] divisor_array = new int[max+1]. Why max+1 because our index starts from 0, and to avoid confusion and to fetch the value of number directly, otherwise for fetching a value of number you have to fetch number+1 value if you don't use max+1. For example: [2,3,4,5], max = 5. If we create array of size 5, max index will be 4 and to fetch 5 value you have to fetch i+1 value, but if I create an array of size 6, I can directly fetch the value of i.
//Step 3. Initialize value of 1 as 1 and rest of the elements as 2 in divisor array because except 1 all will at least have 2 divisors i.e. 1 and itself.
//Step 4. Loop through each number and increment it's multiple by 1.
//Step 5. Fetch the value of each input array element from divisor array and return it.

public class CountDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numb = {2, 3, 4, 5};
		int[] result = solve(numb);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
	public static int[] solve(int[] A) {
	      int max = A[0];

	      //Calculate max to initialize divisor array of max length
	      for(int i=1;i<A.length;i++){
	          if(A[i]>max){
	              max = A[i];
	          }
	      }

	      int[] divisor_array = new int[max+1];
	      divisor_array[1] = 1;  //Setting number of divisor of 1 as 1

	      //Setting initial divisors as 2 as all numbers will have at least 2 divisors i.e. 1 and itself
	      for(int j=2;j<divisor_array.length;j++){
	          divisor_array[j] = 2;
	      }

	      //incrementing the number of divisors for each multiples of numbers
	      for(int k = 2;k<divisor_array.length;k++){

	          for(int l = k+k;l<divisor_array.length;l+=k){
	              divisor_array[l] += 1;
	          }
	      }

	      //Fetching the values of numbers in array directly from divisor_array into the output array
	      for(int c = 0;c<A.length;c++){
	          A[c] = divisor_array[A[c]];
	      }

	      return A;


	  }
}
