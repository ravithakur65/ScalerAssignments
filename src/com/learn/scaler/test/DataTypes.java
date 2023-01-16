package com.learn.scaler.test;

public class DataTypes {
    public static void main(String[] args) {
        Integer num = Integer.valueOf(20);
        String str = String.valueOf("Ravi");
        Boolean b = null;
        int a = 5;
        a++;
        num = num+5;
        str = "Thakur";
        System.out.println(b);
        System.out.println(num);
        
        String s1 = "java";
        String s3 = "java";
        String s2 = new String("java");
        short sh = (short)201000;
        Short maxSh = Short.MAX_VALUE;
        Short minSh = Short.MIN_VALUE;
        System.out.println("Max short: "+maxSh);
        System.out.println("Min short: "+minSh);
        if(s1==s3){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        if(s1==s2){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
