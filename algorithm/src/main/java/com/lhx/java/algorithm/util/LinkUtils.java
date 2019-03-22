package com.lhx.java.algorithm.util;

import com.lhx.java.algorithm.link.Node;

/**
 * Created by lihongxin on 2019/2/17
 */
public class LinkUtils {
    public static void printLink(Node head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
