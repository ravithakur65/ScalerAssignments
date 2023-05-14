package com.learn.scaler.advance.array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes obj = new MoveZeroes();
        int[] result = obj.moveZeros(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    private int[] moveZeros(int[] nums){
        int i=0;
        int j= 0 ;
        while(i<nums.length){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
        return nums;
    }
}
