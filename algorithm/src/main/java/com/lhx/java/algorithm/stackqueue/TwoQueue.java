package com.lhx.java.algorithm.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lihongxin on 2019/2/16
 */
public class TwoQueue<T> {
    private Queue<T> queue1 = new ArrayDeque<>();
    private Queue<T> queue2 = new ArrayDeque<>();

    public void add(T t) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(t);
            return;
        }
        if (!queue1.isEmpty()) {
            queue1.add(t);
        }
        if (!queue2.isEmpty()) {
            queue2.add(t);
        }
    }

    public void delete() {
        if (!queue1.isEmpty() && !queue2.isEmpty()) {
            return;
        }
        if (!queue1.isEmpty()) {
            while (queue1.size()>1) {
                queue2.add(queue1.remove());
            }
            System.out.println("删除了" + queue1.remove());
            return;
        }
        if (!queue2.isEmpty()) {
            while (queue2.size()>1) {
                queue1.add(queue2.remove());
            }
            System.out.println("删除了" + queue2.remove());
            return;

        }
    }

    public static void main(String[] args) {
        TwoQueue<Integer> twoQueue = new TwoQueue<>();
        twoQueue.add(1);
        twoQueue.add(2);
        twoQueue.add(3);
        twoQueue.delete();
    }
}
