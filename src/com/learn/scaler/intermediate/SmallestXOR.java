package com.learn.scaler.intermediate;

public class SmallestXOR {
    public static void main(String[] args) {
        System.out.println(solve(9, 3));
    }
    public static int solve(int A, int B) {
        int x = 0;
        for(int i=30;i>=0;i--){
            if(B==0)
                return x;
            if(((1<<i) & A) == (1<<i)){
                //set the ith bit
                x = x| (1<<i);
                B--;
            }
        }
        for(int i=0;i<=30;i++){
            if(B == 0)
                return x;
            if(((1<<i) & x) == 0){
                x= x| (1<<i);
                B--;
            }
        }
        return x;
    }
}
