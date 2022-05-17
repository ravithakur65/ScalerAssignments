package com.learn.scaler.intermediate;

import java.util.ArrayList;

public class IquilibriumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A=[-7, 1, 5, 2, -4, 3, 0]
		ArrayList<Integer> list = new ArrayList<Integer>();
		/*
		 * list.add(-7); list.add(1); list.add(5); list.add(2); list.add(-4);
		 * list.add(3); list.add(0);
		 */
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		System.out.println(solve(list));
	}
	
	public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> sumArrList = new ArrayList<Integer>();
        sumArrList.add(A.get(0));
        for(int i=1;i<A.size();i++){
            sumArrList.add(sumArrList.get(i-1)+A.get(i));
        }

        int sumLeft = 0;
        int sumRight =  0;
        for(int i=0;i<A.size();i++){
            if(i==0){
                sumLeft=0;
            }else
                sumLeft=sumArrList.get(i-1);
            if(i==A.size()-1){
                sumRight = 0;
            }else
                sumRight=sumArrList.get(A.size()-1)-sumArrList.get(i);
            if(sumLeft==sumRight){
                return i;
            }

        }
        return -1;
    }

}
