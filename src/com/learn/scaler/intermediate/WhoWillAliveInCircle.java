package com.learn.scaler.intermediate;

public class WhoWillAliveInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(whoWillAlive(100));
	}
	
	public static int whoWillAlive(int peoples) {
		int i = 0;
		int power = 1;
		while(power<=peoples/2) {
			power=1<<i;
			i++;
		}
		int alive = peoples-power;
		
		return 2*alive+1;
	}

}
