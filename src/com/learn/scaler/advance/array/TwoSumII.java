package com.learn.scaler.advance.array;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSumII obj = new TwoSumII();
        int[] result = obj.twoSum(numbers, target);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        String s = "name";
        char[] ch = s.toC
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i=0;
        int j=numbers.length-1;
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                result[0] = i+1;
                result[1] = j+1;
                break;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
