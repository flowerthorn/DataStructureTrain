package com.lhx.java.algorithm.link;

import java.util.Stack;

/**
 * Created by lihongxin on 2019/2/17
 * 链表的反转
 */
public class LinkReverse {


    //反转链表
    public void linkReverse(Node head) {
        if (head == null) return;
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

    }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    //输入一个链表，按链表值从尾到头的顺序打印链表 但原列表结构并未改变
    public void printReverse(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    public static void main(String[] args) {

    }

}
