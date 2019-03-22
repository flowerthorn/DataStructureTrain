package com.lhx.java.algorithm.stackqueue;

import java.util.Stack;

/**
 * Created by lihongxin on 2019/2/16
 */
public class TwoStack<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void add(T t) {
        stack1.push(t);
    }

    public void deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println("删除了" + stack2.pop());
        }
    }


    public static void main(String[] args) {
        TwoStack<Integer> twoStack = new TwoStack<>();
        twoStack.add(1);
        twoStack.add(2);
        twoStack.add(3);
        twoStack.deleteHead();

    }
}
