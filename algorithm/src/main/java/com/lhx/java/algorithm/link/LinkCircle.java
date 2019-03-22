package com.lhx.java.algorithm.link;

/**
 * Created by lihongxin on 2019/2/17
 * 判断一个链表是否有环并找到环的结点
 */
public class LinkCircle {

    public Node getClircleEnterNode(Node head) {
        Node fast = head;
        Node slow = head;
        boolean isHaveCircle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isHaveCircle = true;
                break;
            }
        }
        if (!isHaveCircle) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

}
