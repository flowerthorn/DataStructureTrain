package com.lhx.java.algorithm.link;

/**
 * Created by lihongxin on 2019/2/16
 */
public class TwoOrderLinkMerge {


    public void merge(Node a, Node b) {
        Node c = null;
        while (a.next != null && b.next != null) {
            if (a.value <= b.value) {
                if (c == null) {
                    c = a;
                } else {
                    c.next = a;
                }

                a = a.next;
            } else {
                if (c == null) {
                    c = b;
                } else {
                    c.next = b;
                }
                b = b.next;
            }
        }
        while (b.next != null) {
            c.next = b;
            b = b.next;
        }
        while (a.next != null) {
            c.next = a;
            a = a.next;
        }

    }
}
