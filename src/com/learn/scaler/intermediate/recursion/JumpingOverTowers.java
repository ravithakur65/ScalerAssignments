package com.learn.scaler.intermediate.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingOverTowers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 70));
        System.out.println(new JumpingOverTowers().solve(new ArrayList<>(list), 68, 35));    
    }
    public int solve(ArrayList<Integer> A, int B, int C) {
        return cost(0, A, B, C);
    }
    public int cost(int i, ArrayList<Integer> A, int B, int C){
        if(i == A.size()-1) return 0;
        if(i > A.size()-1) return Integer.MAX_VALUE;
        int a = B* Math.abs(A.get(i)-A.get(i+1))+cost(i+1, A, B, C);
        int b = C* Math.abs(A.get(i)-A.get(i+2))+cost(i+2, A, B, C);
        
        return Math.min(a, b);
    }
}
