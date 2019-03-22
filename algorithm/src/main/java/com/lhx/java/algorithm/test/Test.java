package com.lhx.java.algorithm.test;

/**
 * Created by lihongxin on 2019/3/19
 */
public class Test {
    String string = "super";

    public Test() {
        print(string);
    }

    public void print(String string) {
        System.out.println(string);
    }

    static class Son extends Test {
        String string2 = "son";

        public Son() {
            print(string2);
        }

        @Override
        public void print(String string) {
            System.out.println(string);

        }
    }

    public static void main(String[] args) {
        new Son();
    }
}
