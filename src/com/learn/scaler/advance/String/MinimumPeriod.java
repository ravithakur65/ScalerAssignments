package com.learn.scaler.advance.String;


class MinimumPeriod {
    public static void main(String[] args) {
        String str = "abaababaab";
        System.out.println(solve(str));
    }

    public static int solve(String A) {
        int N=A.length();
        int[] chars = new int[26];
        for(int i=0;i< N; i++){
            int index = A.charAt(i)-97;
            chars[index] = chars[index]+1;
        }
        int a = 0,b=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]>0 && a==0){
               a = chars[i];
            }else if(chars[i]>0){
                b = chars[i];
            }
            if(a>0 && b>0)
                a = gcd(a, b);
        }
        int gcd = a;
        int sum = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]>0)
                sum+=chars[i]/gcd;
        }
        return sum;
    }
    public static int gcd(int a,int b){
        int res = 1;
        while (b > 0){
           int temp = b;
           b = a % b;
           a = temp;
           res = a;
        }
        return res;
     }
}