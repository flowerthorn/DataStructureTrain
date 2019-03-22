package com.lhx.java.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lihongxin on 2019/2/17
 */
public class PrintZTree {
    private TreeNode treeNode;

    public PrintZTree(int[] arr) {
        this.treeNode = makeBinaryTreeByArray(arr, 1);

    }

    private TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void print(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        stack1.push(treeNode);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (level % 2 != 0) {
                //奇数层
                List<Integer> list = new ArrayList<>();//为了控制层数
                while (!stack1.isEmpty()) {
                    TreeNode popNode = stack1.pop();
                    list.add(popNode.val);
                    System.out.println(popNode.val);
                    if (popNode.left != null) {
                        stack2.push(popNode.left);
                    }
                    if (popNode.right != null) {
                        stack2.push(popNode.right);
                    }
                }
                if (!list.isEmpty()) {
                    level++;
                }

            } else {
                //偶数层
                List<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode popNode = stack2.pop();
                    list.add(popNode.val);
                    System.out.println(popNode.val);
                    if (popNode.right != null) {
                        stack1.push(popNode.right);
                    }
                    if (popNode.left != null) {
                        stack1.push(popNode.left);
                    }
                }
                if (!list.isEmpty()) {
                    level++;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        PrintZTree printZTree = new PrintZTree(arr);
        printZTree.print(printZTree.treeNode);
    }


}
