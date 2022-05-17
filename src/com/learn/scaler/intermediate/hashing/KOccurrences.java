/*
 * Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
	He wants to select some trees to replace his broken branches.
	But he wants uniformity in his selection of trees.
	So he picks only those trees whose heights have frequency K.
	He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
	But the sum he ended up getting was huge so he prints it modulo 10^9+7.
	In case no such cluster exists, Groot becomes sad and prints -1.
	
	Constraints:

	1.   1<=N<=100000
	2.   1<=K<=N
	3.   0<=H[i]<=10^9
	
	N=5 ,K=2 ,A=[1 2 2 3 3]
	
	There are 3 distinct numbers in the array which are 1,2,3.
	Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.
 */
package com.learn.scaler.intermediate.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KOccurrences {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 2, 3, 3);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.addAll(list);
		System.out.println(getSum(5,2,arrList));
	}
	public static int getSum(int A, int B, ArrayList<Integer> C) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<A;i++){
            if(map.containsKey(C.get(i))){
                int temp = map.get(C.get(i));
                map.put(C.get(i),++temp);
            }else
                map.put(C.get(i),1);
        }
        boolean hasOccurance = false;
        long sum = 0L;
        for(Integer key : map.keySet() ){
            if(map.get(key)==B){
                hasOccurance= true;
                sum+=(long)key;
            }
        }
        if(!hasOccurance)
            return -1;
        return (int)sum;
    }
}
