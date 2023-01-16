package com.learn.scaler.test;
class JavaModule01{
    public static void main(String[] args) {
        int number = 10;
        String str = "Ravi";
        Boolean b = null;
        System.out.println(b);
        EXIT_CODE.getNumVal();
    }

    private static void print(String str) {
        System.out.println(str);
    }

    protected final void getDetails(){

        System.out.println("Test class");

    }
}
enum EXIT_CODE {
    A(104), B(203);

    private int numVal;

    EXIT_CODE(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}