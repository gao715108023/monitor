package com.gcj.test;

public abstract class Test3 {

    public void add(int i, int j) {

    }

    class Test6 extends Test3 {
        public void add(int i, int j) {
            System.out.println(i + j);
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test4();
        Test3 test31 = test3.new Test6();
        test31.add(1, 2);
    }
}
