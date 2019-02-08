package com.lhx.java.algorithm.tree;


import java.util.ArrayDeque;

/**
 * Created by lihongxin on 2019/2/7
 * 非递归打印二叉树
 * 深度优先遍历 先中后序
 * 广度优先遍历 按层从上到下遍历
 * 递归打印二叉树
 * 前中后序
 * 求树的深度
 * 递归 非递归
 * ArrayDeque 双端队列 既可以当栈 又可以当作队列
 */
public class BinaryTree {
    private TreeNode root;

    static class TreeNode {
        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public BinaryTree(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    private TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.leftNode = makeBinaryTreeByArray(array, index * 2);
                t.rightNode = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历 根左右
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversalNonRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "    ");
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversalNonRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.value + "    ");
            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
        System.out.print("\n");
    }

    /**
     * 13
     * /  \
     * 65    5
     * /  \    \
     * 97  25   37
     * /    /\   /
     * 22   4 28 32
     */

    public static void main(String[] args) {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        //构建一个二叉树
        BinaryTree tree = new BinaryTree(arr);
        System.out.println("深度优先遍历结果\n");
        tree.depthOrderTraversalNonRecursive(tree.getRoot());
        System.out.println("广度/按层遍历结果\n");
        tree.levelOrderTraversalNonRecursive(tree.getRoot());
        System.out.println("递归得到二叉树的深度为:" + tree.getHeightByRecursive(tree.getRoot()));
        System.out.println("非递归得到二叉树的深度为:" + tree.getHeightNonRecursive(tree.getRoot()));


    }

    /**
     * 返回二叉树的深度
     * 递归实现
     *
     * @return
     */
    private int getHeightByRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getHeightByRecursive(treeNode.leftNode);
        int right = getHeightByRecursive(treeNode.rightNode);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 返回二叉树的深度
     * 非递归实现
     *
     * @return
     */
    private int getHeightNonRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        //队列
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.add(treeNode);
        int depth = 0;
        while (!arrayDeque.isEmpty()) {
            ++depth;
            int levelNodesCount = arrayDeque.size();
            int i = 0;
            while (i < levelNodesCount) {
                ++i;
                TreeNode node = arrayDeque.remove();
                if (node.leftNode != null) {
                    arrayDeque.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    arrayDeque.add(node.rightNode);
                }
            }

        }
        return depth;
    }
}
